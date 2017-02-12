package springinaction.ORM.object;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.NoSuchFileException;
import java.util.Map;

/**
 * Created by admin on 2017/2/10.
 */
public class ObjectUtil {
    private static Log log = LogFactory.getLog(ObjectUtil.class);

    public static Object getFieldValue(Object dataInfo, String fieldName) {
        try {
            if (fieldName.equalsIgnoreCase("udfs"))
                return getUdfsValue(dataInfo);

            Field field = dataInfo.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            return field.get(dataInfo);
        } catch (NoSuchFieldException e) {
            String newFieldName = getChangeField(fieldName);
            if (!newFieldName.equals(fieldName))
                return getFieldValue(dataInfo, newFieldName);
            if (log.isDebugEnabled())
                log.warn(e, e);
            else log.warn(e);
        } catch (Exception e) {
            if (log.isDebugEnabled())
                //TODO
                log.warn(e, e);
            else log.warn(e);
        }
        return null;
    }

    private static String getChangeField(String fieldName) {
        char first = fieldName.charAt(0);
        int asciiCode = (int) first;
        //小写
        if (asciiCode >= 65 && asciiCode <= 90) {
            String firstChar = fieldName.substring(0, 1);
            return firstChar.toLowerCase() + fieldName.substring(1, fieldName.length());
        }
        return fieldName;
    }

    private static Map<String, String> getUdfsValue(Object dataInfo) {

        try {
            Method method = dataInfo.getClass().getMethod("getUdfs");
            return (Map<String, String>) method.invoke(dataInfo, null);
        } catch (Exception e) {
            if (log.isDebugEnabled())
                log.warn(e, e);
            else
                log.warn(e);
        }
        return null;
    }

    public static String getString(Object[] bindSet) {
        if (bindSet == null || bindSet.length ==0)
            return "";
        StringBuilder str = new StringBuilder();
        for (int i=0;i<bindSet.length;i++){
            str.append(bindSet[i]).append(",");
        }
        return str.delete(str.length()-1,str.length()).toString();
    }

    public static void setFieldValue(Object object,String fieldName ,Object value){
        try {
            if (fieldName.equals("udfs"))
                setUdfsValue(object,(Map<String,String>)value);
            else {
                try {
                    Field field = object.getClass().getDeclaredField(fieldName);
                    field.setAccessible(true);
                    copyFieldValue(field,object,value);
                }catch (NoSuchFieldException e){

                    fieldName = getChangeField(fieldName);
                    Field field = object.getClass().getDeclaredField(fieldName);
                    field.setAccessible(true);
                    copyFieldValue(field, object, value);
                }
            }

        }catch (Exception e){

        }
    }

    public static void setUdfsValue(Object dataInfo,Map<String ,String > value) {
        try {
            Method method = dataInfo.getClass().getMethod("setUdfs", Map.class);
            method.invoke(dataInfo, value);
        } catch (Exception e) {
            if (log.isDebugEnabled())
                log.warn(e, e);
            else
                log.warn(e);
        }
    }

    public static void copyFieldValue(Field field, Object target, Object value)
    {
        try
        {
            Class type = field.getType();

            if ( type.equals( Double.class ) || type.equals( double.class ))
                field.set(target, Double.parseDouble(String.valueOf(value)));
            else if ( type.equals( Long.class ) || type.equals( long.class ))
                field.set(target, Long.parseLong(String.valueOf(value)));
            else if ( type.equals( Integer.class ) || type.equals( int.class ))
                field.set(target, Integer.parseInt(String.valueOf(value)));
            else if ( type.equals( Float.class ) || type.equals( float.class ))
                field.set(target, Float.parseFloat(String.valueOf(value)));
            else if ( type.equals( Short.class ) || type.equals( short.class ))
                field.set(target, Short.parseShort(String.valueOf(value )));
            else if ( type.equals( Boolean.class ) || type.equals( boolean.class ))
                field.set(target, Boolean.parseBoolean(String.valueOf(value)));
            else
            {
                if (field.getName().equalsIgnoreCase("key"))
                {
                    if (ObjectUtil.getFieldValue(target, "key") != null
                            && !ObjectUtil.getFieldValue(target, "key").getClass().equals(value.getClass()))
                        return;
                }
                field.set(target, value);
            }
        } catch (Throwable e)
        {
            if (log.isDebugEnabled())

                log.warn(e, e);
            else
                log.warn(e);
        }

    }
}
