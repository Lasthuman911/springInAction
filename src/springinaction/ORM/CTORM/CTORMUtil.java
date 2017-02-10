package springinaction.ORM.CTORM;

import org.springframework.util.ObjectUtils;
import springinaction.ORM.exception.ErrorSignal;
import springinaction.ORM.object.ObjectUtil;
import sun.swing.BakedArrayList;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static springinaction.ORM.exception.ErrorSignal.NullPointKeySignal;
import static sun.org.mozilla.javascript.internal.Token.ELSE;

/**
 * Created by admin on 2017/2/9.
 */
public class CTORMUtil {

    public static String getHeader(Class clazz) {
        String headerName = "";
        String connector = "";

        if (clazz.isAnnotationPresent(CTORMHeader.class)) {
            CTORMHeader header = (CTORMHeader) clazz.getAnnotation(CTORMHeader.class);
            if (header != null) {
                headerName = header.tag();
                connector = header.divider();

                if (headerName.isEmpty()) headerName = "CT";
                if (connector.isEmpty()) connector = "_";
            }
        }
        return new StringBuilder(headerName).append(connector).toString();
    }

    public static String getTableNameByClassName(Class clazz) {
        String tableName = clazz.getSimpleName();
        tableName = new StringBuffer().append(getHeader(clazz)).append(tableName).toString();
        return tableName;
    }

    public static String getInsertSql(Class dataInfo, String tablename) {
        StringBuffer sql = new StringBuffer();
        sql.append("INSERT").append(" ").append("INTO").append(" ").append(tablename).append(" ");

        StringBuilder attrBuilder = new StringBuilder("");
        StringBuilder valueBuilder = new StringBuilder("");

        for (Field column : dataInfo.getDeclaredFields()) {
            if (column.isAnnotationPresent(CTORMTemplate.class)) {
                CTORMTemplate annotation = column.getAnnotation(CTORMTemplate.class);

                String name = annotation.name();
                String type = annotation.type();
                String dataType = annotation.dataType();
                String initial = annotation.initial();

                if (initial.equalsIgnoreCase("never"))
                    continue;
                {
                    //column generation
                    if (!attrBuilder.toString().isEmpty())
                        attrBuilder.append(",");
                    attrBuilder.append(name);
                }

                {
                    //value generation
                    if (!valueBuilder.toString().isEmpty())
                        valueBuilder.append(",");
                    if ((dataType.equalsIgnoreCase("timestamp") || dataType.equalsIgnoreCase("systemtime")
                    ) && initial.equalsIgnoreCase("current")) {
                        valueBuilder.append("SYSDATE");
                    } else {
                        valueBuilder.append("?");
                    }
                }
            }

        }
        sql.append("(").append(attrBuilder).append(")").append(" VALUES").append("(").append(valueBuilder).append(")");
        return sql.toString();
    }

    public static List<Object> makeKeyParam(Object dataInfo) {
        List<Object> temp = new ArrayList<Object>();
        if (dataInfo == null)
            return temp;

        int fieldIndex = 0;

        for (Field column : dataInfo.getClass().getDeclaredFields()) {
            if (column.isAnnotationPresent(CTORMTemplate.class)) {
                CTORMTemplate annotation = column.getAnnotation(CTORMTemplate.class);

                String name = annotation.name();
                String type = annotation.type();

                if (type.equalsIgnoreCase("key")) {
                    temp.add(fieldIndex, ObjectUtil.getFieldValue(dataInfo, name));
                    fieldIndex++;
                }
            }
        }

        return temp;
    }

    public static String validateKeyParam(Object dataInfo, Object[] args) {
        try {
            if (dataInfo == null)
                throw new Exception("dataInfo is null");
            int keyCnt = 0;

            for (Field column : dataInfo.getClass().getDeclaredFields()) {
                if (column.isAnnotationPresent(CTORMTemplate.class)) {
                    CTORMTemplate annotation = column.getAnnotation(CTORMTemplate.class);

                    String type = annotation.type();

                    if (type.equalsIgnoreCase("key"))
                        keyCnt++;
                }
            }
            if (keyCnt != args.length)
                throw new Exception("key value is null");
        } catch (Exception e) {
            return ErrorSignal.NullPointKeySignal;
        }
        return "";
    }

    public static List<Object> makeNonkeyParam(Object dataInfo){
        List<Object> temp = new ArrayList<Object>();

        if (dataInfo == null)
            return temp;
        int idx = 0;
        for (Field column : dataInfo.getClass().getDeclaredFields()){
            if (column.isAnnotationPresent(CTORMTemplate.class)){
                CTORMTemplate annotation = column.getAnnotation(CTORMTemplate.class);

                String name = annotation.name();
                String type = annotation.type();

                String initial = annotation.initial();

                if (!type.equalsIgnoreCase("key")&& !initial.equalsIgnoreCase("never")){
                    temp.add(idx,ObjectUtil.getFieldValue(dataInfo,name));
                    idx++;
                }
            }

        }
        return temp;
    }
}
