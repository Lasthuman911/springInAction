package cn.range.protectedrange.p1;

/**相同package 的protected 相当于public
 * Created by wzm on 2017/2/20 0020.
 */
public class TestSamePackage {
    public static void main(String[] args) {
        Base base = new Base();
        base.protectedMethod();

        Sub sub = new Sub();
        sub.protectedMethod();
    }
}
