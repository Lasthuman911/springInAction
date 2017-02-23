package cn.designmode.singleton;

/**
 * Created by admin on 2017/2/20.
 */
public class SimpleSingleton {
    //在内部自己定义一个实例，private 限制只供内部调用
    private static SimpleSingleton simpleSingleton = new SimpleSingleton();

    //在内部自己定义一个实例，private 限制只供内部调用
    private SimpleSingleton() {
    }

    //静态工厂方法，提供一个供外部访问得到对象的静态方法
    public static SimpleSingleton getSimpleSingleton() {
        return simpleSingleton;
    }
}
