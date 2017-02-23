package quiz.huawei;

/**
 * 考察for循环的执行过程，注意 && 条件，只要有一个条件不符合，后续则不再执行，提高程序效率
 * Name: admin
 * Date: 2017/2/22
 * Time: 13:39
 */
public class TestFor {
    public static boolean foo(char c) {
        System.out.print(c);
        return true;
    }

    public static void main(String[] args) {
        int i = 0;
        //ABDCBDC
/*        for (foo('A'); (i < 2) && foo('B'); foo('C')) {
            i++;
            foo('D');
        }  */
        //ABDCBDCB
        for (foo('A'); foo('B') && (i < 2); foo('C')) {
            i++;
            foo('D');
        }
    }
}
