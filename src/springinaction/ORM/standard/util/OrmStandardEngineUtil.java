package springinaction.ORM.standard.util;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import springinaction.ORM.exception.ErrorSignal;
import springinaction.ORM.exception.nanoFrameErrorSignal;
import springinaction.ORM.nanoFrameServiceProxy;
import springinaction.ORM.object.ObjectUtil;
import springinaction.ORM.standard.DataInfo;
import springinaction.ORM.standard.KeyInfo;
import springinaction.ORM.standard.info.ObjectAttributeDef;
import springinaction.ORM.standard.info.ObjectAttributeMap;
import sun.swing.BakedArrayList;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2017/2/13.
 */
public class OrmStandardEngineUtil {
    private static Log log = LogFactory.getLog(OrmStandardEngineUtil.class);

    public static KeyInfo getKeyInfo(Object dataInfo) {
        if (dataInfo instanceof KeyInfo)
            return (KeyInfo) dataInfo;
        else if (dataInfo instanceof DataInfo) {
            try {
                return ((DataInfo) dataInfo).getKey();
            } catch (Exception e) {
                log.warn(e, e);
            }
        }
        return null;
    }

    public static String generateSqlStatement(String queryType, Object dataKeyObject) throws nanoFrameErrorSignal {
        StringBuilder strBuilder = new StringBuilder();

        String tableName = OrmStandardEngineUtil.getTableName(dataKeyObject);

        if (queryType.equalsIgnoreCase("select"))
            strBuilder.append("SELECT * FROM " + tableName);
        else if (queryType.equalsIgnoreCase("delete"))
            strBuilder.append("DELETE " + tableName);
        else if (queryType.equalsIgnoreCase("update"))
            strBuilder.append("UPDATE " + tableName).append("SET");
        else if (queryType.equalsIgnoreCase("insert"))
            strBuilder.append("INSERT INTO").append(tableName);

        return generateCondition(strBuilder, queryType, tableName, dataKeyObject).toString();
    }

    private static StringBuilder generateCondition(StringBuilder strBuilder, String queryType, String tableName, Object dataKeyObject) throws nanoFrameErrorSignal {
        List<ObjectAttributeDef> objectAttributeDefs = nanoFrameServiceProxy.getObjectAttributeMap().getAttributeNames(tableName, ObjectAttributeMap.Standard_Type);
        if (objectAttributeDefs == null)
            throw new nanoFrameErrorSignal(ErrorSignal.NotDefineObjectAttributeSignal, tableName);
        if (queryType.equalsIgnoreCase("select") || queryType.equalsIgnoreCase("delete")) {
            strBuilder = selectAndDeleteCondition(strBuilder, objectAttributeDefs);
            return strBuilder;
        } else if (queryType.equalsIgnoreCase("update")) {
            StringBuilder where = new StringBuilder(" WHERE ");
            List<ObjectAttributeDef> objectAttributeCDefs = nanoFrameServiceProxy.getObjectAttributeMap().getAttributeNames(tableName, ObjectAttributeMap.ExtendedC_Type);
            Object[] attributes = new Object[]{objectAttributeDefs, objectAttributeCDefs};

            for (int h = 0; h < attributes.length; h++) {
                if (attributes[h] == null)
                    continue;
                List<ObjectAttributeDef> oads = (List<ObjectAttributeDef>) attributes[h];
                for (ObjectAttributeDef attributeDef : oads) {
                    if (attributeDef.getPrimaryKeyFlag().equalsIgnoreCase("y"))
                        where = where.append(attributeDef.getAttributeName()).append("=").append("?").append(" AND");
                    else {
                        if (h == 1) { // udfs
                            if (checkNotNullValue(dataKeyObject, attributeDef, ObjectUtil.getUdfsValue(dataKeyObject)))
                                strBuilder.append(attributeDef.getAttributeName()).append("=").append("?").append(",");
                            else if (attributeDef.getDataType().equalsIgnoreCase("timestamp"))
                                strBuilder.append(attributeDef.getAttributeName()).append("=").append("null").append(",");
                        } else {
                            if (checkNotNullValue(dataKeyObject, attributeDef, null))
                                strBuilder.append(attributeDef.getAttributeName()).append("=").append("?").append(",");
                            else if (attributeDef.getDataType().equalsIgnoreCase("timestamp"))
                                strBuilder.append(attributeDef.getAttributeName()).append("=").append("null").append(",");
                        }
                    }
                }
            }
            String whereToString = where.toString().substring(0, where.length() - 5);
            strBuilder.delete(strBuilder.length() - 1, strBuilder.length()).append(whereToString);
            return strBuilder;
        } else if (queryType.equalsIgnoreCase("insert")) {

            strBuilder.append(" (");

            StringBuilder strBuilder2 = new StringBuilder();
            List<ObjectAttributeDef> ObjectAttributeCDefs =
                    nanoFrameServiceProxy.getObjectAttributeMap().getAttributeNames(tableName, ObjectAttributeMap.ExtendedC_Type);
            Object[] attributes = new Object[]{objectAttributeDefs, ObjectAttributeCDefs};

            for (int h = 0; h < attributes.length; h++) {
                if (attributes[h] == null)
                    continue;

                List<ObjectAttributeDef> oads = (List<ObjectAttributeDef>) attributes[h];

                for (ObjectAttributeDef attributeDef : oads) {
                    if (h == 1) {
                        if (checkNotNullValue(dataKeyObject, attributeDef, ObjectUtil.getUdfsValue(dataKeyObject))) {
                            if (attributeDef.getDataType().equalsIgnoreCase("timestamp")
                                    && attributeDef.getAttributeName().equalsIgnoreCase("systemtime")) {
                                strBuilder.append(attributeDef.getAttributeName()).append(",");
                                strBuilder2.append("SYSDATE").append(",");
                            } else {
                                strBuilder.append(attributeDef.getAttributeName()).append(",");
                                strBuilder2.append("?").append(",");
                            }
                        } else if (StringUtils.isNotEmpty(attributeDef.getDefaultValue())) // DefaultValue 瘤盔
                        {
                            strBuilder.append(attributeDef.getAttributeName()).append(",");
                            strBuilder2.append("?").append(",");
                        }
                    } else {
                        if (checkNotNullValue(dataKeyObject, attributeDef, null)) {
                            if (attributeDef.getDataType().equalsIgnoreCase("timestamp") && attributeDef.getAttributeName().equalsIgnoreCase("systemtime")) {
                                strBuilder.append(attributeDef.getAttributeName()).append(",");
                                strBuilder2.append("SYSDATE").append(",");
                            } else {
                                strBuilder.append(attributeDef.getAttributeName()).append(",");
                                strBuilder2.append("?").append(",");
                            }
                        } else if (StringUtils.isNotEmpty(attributeDef.getDefaultValue())) // DefaultValue 瘤盔
                        {
                            strBuilder.append(attributeDef.getAttributeName()).append(",");
                            strBuilder2.append("?").append(",");
                        }
                    }
                }
            }

            strBuilder.delete(strBuilder.length() - 1, strBuilder.length()).append(")").append(" values (");
            strBuilder.append(strBuilder2.delete(strBuilder2.length() - 1, strBuilder2.length()));
            strBuilder.append(")");

            return strBuilder;

        } else
            throw new nanoFrameErrorSignal(ErrorSignal.InvalidQueryType, queryType);
    }

    private static boolean checkNotNullValue(Object dataKeyObject, ObjectAttributeDef objectAttributeDef, Map<String, String> udfs) {
        if (objectAttributeDef.getDataType().equalsIgnoreCase("timestamp")
                && objectAttributeDef.getAttributeName().equalsIgnoreCase("systemtime"))
            return true;
        Object value = null;

        if (objectAttributeDef.getPrimaryKeyFlag().equalsIgnoreCase("y"))
            value =
                    ObjectUtil.getFieldValue(OrmStandardEngineUtil.getKeyInfo(dataKeyObject),
                            objectAttributeDef.getAttributeName());
        else if (udfs == null)
            value = ObjectUtil.getFieldValue(dataKeyObject, objectAttributeDef.getAttributeName());
        else
            value = udfs.get(objectAttributeDef.getAttributeName());

        if (value == null)
            return false;

        if (objectAttributeDef.getDataType().equalsIgnoreCase("timestamp")) {
            if (value.equals(new Timestamp(0)) || value.toString().length() == 0)
                return false;
        } else if (value != null
                && (objectAttributeDef.getDataType().equalsIgnoreCase("Long") || objectAttributeDef.getDataType()
                .equalsIgnoreCase("Double"))) {
            if (value.toString().length() == 0) {
                return false;
            }
        }
        return true;
    }

    public static StringBuilder selectAndDeleteCondition(StringBuilder strBuilder, List<ObjectAttributeDef> objectAttributeDefs) {
        strBuilder.append(" WHERE");
        for (ObjectAttributeDef attributeDef : objectAttributeDefs) {
            if (attributeDef.getPrimaryKeyFlag().equalsIgnoreCase("y")) {
                strBuilder.append(attributeDef.getAttributeName()).append("=").append("?");
                strBuilder.append(" AND ");
            }
        }
        if (strBuilder.toString().endsWith(" AND "))
            strBuilder.delete(strBuilder.length() - 5, strBuilder.length());
        return strBuilder;
    }


    public static String getTableName(Object dataKeyInfo) {
        String tableName = dataKeyInfo.getClass().getSimpleName();
        if (dataKeyInfo instanceof KeyInfo)
            tableName = tableName.substring(0, tableName.length() - 3);
        return tableName.toUpperCase();
    }

    public static String getTableNameByClassName(Class clazz) {
        String tableName = clazz.getSimpleName();
        if (tableName.endsWith("Key"))
            tableName = tableName.substring(0, tableName.length() - 3);
        else if (tableName.endsWith("ServiceImpl"))
            tableName = tableName.substring(0, tableName.length() - 11);
        else if (tableName.endsWith("Service"))
            tableName = tableName.substring(0, tableName.length() - 7);

        return tableName;
    }

    public static Object[] getSelectOrDeleteBindObjects(Object dataKeyInfo) {
        String tableName = getTableName(dataKeyInfo);

        KeyInfo keyInfo = null;
        if (dataKeyInfo instanceof DataInfo)
            keyInfo = getKeyInfo(dataKeyInfo);
        else if (dataKeyInfo instanceof KeyInfo)
            keyInfo = (KeyInfo) dataKeyInfo;
        List<Object> objectValue = new ArrayList<>();
        List<ObjectAttributeDef> objectAttributeDefs = nanoFrameServiceProxy.getObjectAttributeMap().getAttributeNames(tableName, ObjectAttributeMap.Standard_Type);
        for (ObjectAttributeDef attributeDef : objectAttributeDefs) {
            if (attributeDef.getPrimaryKeyFlag().equalsIgnoreCase("y"))
                objectValue.add(ObjectUtil.getFieldValue(keyInfo, attributeDef.getAttributeName()));
            else {
                if (dataKeyInfo instanceof KeyInfo)
                    break;
            }
        }
        return objectValue.toArray();
    }

    public static Object[] getUpdateBindObjects(Object dataKeyInfo) throws nanoFrameErrorSignal {
        String tableName = getTableName(dataKeyInfo);

        KeyInfo keyInfo = null;
        if (dataKeyInfo instanceof DataInfo)
            keyInfo = getKeyInfo(dataKeyInfo);
        else if (dataKeyInfo instanceof KeyInfo)
            keyInfo = (KeyInfo) dataKeyInfo;

    }
}
