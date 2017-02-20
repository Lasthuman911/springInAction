package cn.range.protectedrange.p2;

import cn.range.protectedrange.p1.Base;
import cn.range.protectedrange.p1.Sub;

/**测试不同package下非子类的protected的使用范围
 * Created by wzm on 2017/2/20 0020.
 */
public class TestDifferentPackage {
    public static void main(String[] args) {
        Base base = new Base();
//        base.protectedMethod();// 编译器报错。父类的protected方法不可以在不同一个包中的其它类中被访问
        Object o = new Object();
//        o.clone();//编译器报错。父类的protected方法不可以在不同一个包中的其它类中被访问

        Sub sub = new Sub();
//        sub.protectedMethod();// 编译器报错。子类的protected方法不可以在不同一个包中的其它类中被访问
    }
}
