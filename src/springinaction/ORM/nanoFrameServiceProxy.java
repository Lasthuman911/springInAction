package springinaction.ORM;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.osgi.framework.BundleContext;
import springinaction.ORM.common.BundleUtil;
import springinaction.ORM.exception.ErrorSignal;
import springinaction.ORM.exception.nanoFrameErrorSignal;
import springinaction.ORM.standard.info.ObjectAttributeMap;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by admin on 2017/2/10.
 */
public class nanoFrameServiceProxy {

    private static Log log			= LogFactory.getLog(nanoFrameServiceProxy.class);

    private static Map<Long, Thread> threadMap = new ConcurrentHashMap<Long,Thread>();

    private static BundleContext bundleContext;
    public static BundleContext getBundleContext()
    {
        if (bundleContext == null)
        {
            Thread thread = Thread.currentThread();
            log.info("GETBUNDLE : " + thread.getName());
            threadMap.put(thread.getId(), thread);

            try
            {
                Thread.sleep(BundleUtil.getServiceLookupTimeout());
            }
            catch (InterruptedException ex)
            {
                return bundleContext;
            }
            finally
            {
                threadMap.remove(thread.getId());
            }

            throw new nanoFrameErrorSignal(ErrorSignal.NotActive, "nanoframe.kernel is not Active.");
        }
        else
            return bundleContext;
    }

    public static ObjectAttributeMap getObjectAttributeMap() {
        return (ObjectAttributeMap) BundleUtil.waitForService(ObjectAttributeMap.class.getName());
    }

    public static SqlTemplate getSqlTemplate()
    {
        return (SqlTemplate) BundleUtil.waitForService(SqlTemplate.class.getName());
    }
}
