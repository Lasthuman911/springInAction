package quiz.huawei;

/**
 * str 是局部变量
 * 这里虽然是一个静态方法，但是里面的变量是一个局部变量，
 * 所以这里不因为是静态方法，就误认为里面的变量也是静态变量了
 * Name: admin
 * Date: 2017/2/22
 * Time: 13:27
 */
public class TestStaticField {
    public static String change(String str){
        str = "lishuzhen";
        return str;
    }
    public static void main(String[] args) {
        String str = "wzm";
        change(str);
        System.out.println(str);
    }
}
/*
wzm
*/

