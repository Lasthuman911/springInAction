package quiz.huawei;

/**
 * Name: admin
 * Date: 2017/2/22
 * Time: 14:10
 */
public class TestInnerClass {
//    成员内部类
    public class inner {
    }

    public static void main(String[] args) {
        TestInnerClass out = new TestInnerClass();
//        new inner();//java 无法从静态上下文中引用非静态变量this
//        new out.inner();
//        new TestInnerClass.inner();//java 无法从静态上下文中引用非静态变量this
        TestInnerClass.inner innerClass = out.new inner();//OK
    }

    public void someOUtterMethod() {
        new inner();//OK
    }
}
