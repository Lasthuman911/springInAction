package springinaction.ORM.common;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;

/**
 * Created by admin on 2017/2/10.
 */
public class CommonUtil {
    private static Log log = LogFactory.getLog(CommonUtil.class);

    public static String toStringFromCollection(Object objects) {
        StringBuffer temp = new StringBuffer("");

        if (objects instanceof Object[]) {
            for (Object element : (Object[]) objects) {
                if (!temp.toString().isEmpty())
                    temp.append(",");
                try {
                    temp.append(element.toString());
                } catch (Exception e) {
                    if (log.isDebugEnabled())
                        log.debug(e.getMessage());
                }
            }

        }
        else if (objects instanceof List){
            for (Object element :(List<Object>) objects){
                if (!temp.toString().isEmpty())
                    temp.append(",");

                try {
                    temp.append(element.toString());
                }catch (Exception e){
                    if (log.isDebugEnabled())
                        log.debug(e.getMessage());
                }
            }
        }
        return temp.toString();
    }
}
