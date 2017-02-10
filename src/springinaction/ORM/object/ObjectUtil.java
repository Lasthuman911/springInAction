package springinaction.ORM.object;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
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
        char first =fieldName.charAt(0);
        int asciiCode = (int) first;
        //小写
        if (asciiCode>=65 && asciiCode<=90){
            String firstChar = fieldName.substring(0,1);
            return firstChar.toLowerCase()+fieldName.substring(1,fieldName.length());
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
}
