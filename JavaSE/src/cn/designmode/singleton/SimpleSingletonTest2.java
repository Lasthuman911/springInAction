package cn.designmode.singleton;

/**
 * Created by admin on 2017/2/20.
 */
public class SimpleSingletonTest2 {
    //在内部自己定义一个实例，private 限制只供内部调用
    private static SimpleSingletonTest2 simpleSingleton = buildSimpleSingletonTest2();

    //在内部自己定义一个实例，private 限制只供内部调用
    private SimpleSingletonTest2() {
    }

    public static SimpleSingletonTest2 buildSimpleSingletonTest2(){
        return new SimpleSingletonTest2();
    }

    //静态工厂方法，提供一个供外部访问得到对象的静态方法
    public static SimpleSingletonTest2 getSimpleSingleton() {
        return simpleSingleton;
    }
}
