package springinaction.ORM.CTORM;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Map;

/**
 * Created by admin on 2017/2/11.
 */
public class SQLLogUtil {
    public static String getLogFromatSqlStatement(String sql, Object args, Log log){
        try {
            if (args instanceof Object[]){
                Object[] objs = (Object[]) args;
                for (Object obj : objs){
                    sql = StringUtils.replaceOnce(sql,"?",getLogFormatArgument(obj));
                }
            else if (args instanceof Map){
                    Map<String,Object> map = (Map<String, Object>) args;


                }
            }
        }catch (Throwable e){
            if (log.isDebugEnabled())
                log.error(e,e);
            else
                log.error(e);
        }
        return  sql;
    }

    private static String getLogFormatArgument(Object arg) {
        if (arg instanceof String)
            return "'"+(String) arg+"'";
        else if (arg instanceof Timestamp || arg instanceof Date)
            return "timestamp '"+arg.toString()+"'";
        else if (arg == null)
            return null;
        else
            return arg.toString();
    }
}
