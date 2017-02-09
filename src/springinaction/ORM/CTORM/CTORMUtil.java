package springinaction.ORM.CTORM;

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

    public static String getTableNameByClassName(Class clazz){
        String tableName = clazz.getSimpleName();
        tableName = new StringBuffer().append(getHeader(clazz)).append(tableName).toString();
        return tableName;
    }
}
