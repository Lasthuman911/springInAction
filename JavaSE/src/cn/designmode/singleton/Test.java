package cn.designmode.singleton;

/**
 * Name: admin
 * Date: 2017/3/15
 * Time: 11:22
 */
public class Test {
    public static void main(String[] args) {
        SimpleSingletonTest2 a1 = SimpleSingletonTest2.getSimpleSingleton();
        SimpleSingletonTest2 a2 = SimpleSingletonTest2.getSimpleSingleton();
        System.out.println(a1.hashCode() + " "+a2.hashCode());

    }
}
