package cn.designmode.singleton.lazyinitial;

/**
 * Created by admin on 2017/2/20.
 */
public class lazyinitial {
    private static lazyinitial instance = null;

    private lazyinitial() {
    }

    /*    public static lazyinitial getInstance() {
            if (instance == null) {
                instance = new lazyinitial();
            }
            return instance;
        }  */

    /**
     * synchronize 保证了多线程环境下的单例实现
     * @return
     */

    public static synchronized lazyinitial getInstance() {
        if (instance == null) {
            instance = new lazyinitial();
        }
        return instance;
    }
}
