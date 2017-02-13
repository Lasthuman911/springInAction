package springinaction.ORM.common;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;
import org.springframework.context.ApplicationContext;
import springinaction.ORM.exception.ErrorSignal;
import springinaction.ORM.exception.nanoFrameErrorSignal;
import springinaction.ORM.nanoFrameProperties;
import springinaction.ORM.nanoFrameServiceProxy;

/**
 * Created by admin on 2017/2/10.
 */
public class BundleUtil {

    private static long serviceLookupTimeout = 30000;
    private static Log log = LogFactory.getLog(BundleUtil.class);

    public static Object getBundleServiceClass(Class clazz) throws nanoFrameErrorSignal {
        return getBundleServiceClass(nanoFrameServiceProxy.getBundleContext(), null, clazz, "", -1);
    }

    public static long getServiceLookupTimeout() {
        return serviceLookupTimeout;
    }

    public static Object getBundleServiceClass(BundleContext bc, ApplicationContext ac, Class clazz, String beanName,
                                               long timeOut) throws nanoFrameErrorSignal {
        try {
            serviceLookupTimeout = Long.parseLong(System.getProperty(nanoFrameProperties.SERVICE_LOOKUP_TIMEOUT));
        } catch (Exception e) {
        }
        if (bc != null) {
            Object service = null;
            ServiceTracker serviceTracker = new ServiceTracker(bc, clazz.getName(), null);
            serviceTracker.open();
            try {
                if (timeOut <= -1)
                    service = serviceTracker.waitForService(serviceLookupTimeout);
                else
                    service = serviceTracker.waitForService(timeOut);
                if (service != null) {
                    serviceTracker.close();
                    return service;
                }
            } catch (Exception e) {
            }
        }
        if (ac != null && beanName != null) {
            if (ac.containsBean(beanName))
                return ac.getBean(beanName);
        }
        throw new nanoFrameErrorSignal(ErrorSignal.NoDefineServiceBean, clazz.getName());
    }


    public static Object waitForService(String interfaceName) {
        return waitForService(interfaceName, serviceLookupTimeout);
    }

    public static Object waitForService(String interfaceName, long timeout) {
        ServiceTracker serviceTracker = new ServiceTracker(nanoFrameServiceProxy.getBundleContext(), interfaceName, null);
        serviceTracker.open();

        Object service = null;
        try {
            service = serviceTracker.getService();

            if (service == null) {
                log.info("Waiting for service(" + interfaceName + ") until timeout(" + String.valueOf(timeout) + " milliseconds");
                service = serviceTracker.waitForService(timeout);

                if (service == null)
                    throw new nanoFrameErrorSignal(ErrorSignal.NoServiceRegistered, interfaceName);
                else
                    log.info("Returning service under interface(" + interfaceName + ")");
            }
            return service;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            serviceTracker.close();
        }
    }
}
