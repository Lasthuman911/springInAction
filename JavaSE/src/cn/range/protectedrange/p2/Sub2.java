package cn.range.protectedrange.p2;

import cn.range.protectedrange.p1.Base;

/**测试不同package下子类的protected使用范围
 * Created by wzm on 2017/2/20 0020.
 */
public class Sub2 extends Base {
    public static void main(String[] args) {
        Base base = new Base();
//      base.protectedMethod();// 编译器报错。父类的protected方法不可以在不同一个包中的子类中被访问

        Sub2 sub2 = new Sub2();
        sub2.protectedMethod();
    }
}
