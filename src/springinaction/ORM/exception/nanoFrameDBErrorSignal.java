package springinaction.ORM.exception;

/**
 * Created by admin on 2017/2/11.
 */
public class nanoFrameDBErrorSignal extends nanoFrameErrorSignal {
    public nanoFrameDBErrorSignal(String errorCode, String msg) {
        super(errorCode, msg);
    }
}
