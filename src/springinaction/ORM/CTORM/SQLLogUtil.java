package springinaction.ORM.CTORM;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import springinaction.ORM.StringComparator;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by admin on 2017/2/11.
 */
public class SQLLogUtil {

    private static StringComparator stringComparator = new StringComparator(false);

    public static void logBeforeExecuting(String sql, Log log) {
        if (log.isDebugEnabled())
            log.debug("SQL [" + sql + "]");
    }

    public static void logAfterUpdate(int result, Log log) {
        if (log.isDebugEnabled())
            log.debug("SQL update affected " + result + "rows");
    }

    public static String getLogFormatSqlStatement(String sql, Object args, Log log){
        try {
            if (args instanceof Object[]) {
                Object[] objs = (Object[]) args;
                for (Object obj : objs) {
                    sql = StringUtils.replaceOnce(sql, "?", getLogFormatArgument(obj));
                }
            } else if (args instanceof Map) {
                Map<String, Object> map = (Map<String, Object>) args;

                TreeMap<String, Object> treeMap = new TreeMap<String, Object>(stringComparator);
                treeMap.putAll(map);

                Iterator<Map.Entry<String, Object>> iter = treeMap.entrySet().iterator();
                while (iter.hasNext()) {
                    Map.Entry<String, Object> entry = iter.next();
                    sql = sql.replace(":" + entry.getKey(), getLogFormatArgument(entry.getValue()));
                }
            }
        } catch (Throwable e) {
            if (log.isDebugEnabled())
                log.error(e, e);
            else
                log.error(e);
        }
        return sql;
    }

    private static String getLogFormatArgument(Object arg) {
        return null;
    }

}
