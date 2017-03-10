package book.effectivejava.number49;

/**频繁的进行装箱拆箱操作，导致性能低下
 * Name: admin
 * Date: 2017/3/10
 * Time: 13:39
 */
public class Test {
    public static void main(String[] args) {
        Long sum = 0L;
        for (long i = 0; i< Integer.MAX_VALUE;i++){
            sum +=i;
        }
        System.out.println(sum);
    }
}
