package springinaction.ORM.exception;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created by admin on 2017/2/10.
 */
public class nanoFrameErrorSignal extends RuntimeException {
    protected Log log = LogFactory.getLog(this.getClass());

    private String errorCode;
    public nanoFrameErrorSignal(String errorCode, String msg) {
        super(makeMessage(errorCode, msg));
        this.errorCode = errorCode;
        log.info(super.getMessage());
    }

    public static String makeMessage(String errorCode,String msg){
        return String.format("%s: %s",errorCode,msg);
    }
}
