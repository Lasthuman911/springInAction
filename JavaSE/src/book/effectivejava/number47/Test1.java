package book.effectivejava.number47;

import java.util.Random;

/**产生0 到 n 之间的随机整数
 * Name: admin
 * Date: 2017/3/9
 * Time: 16:18
 */
public class Test1 {
    private static final Random random = new Random();
    public static void main(String[] args) {
        System.out.println(random(10));
    }
    static int random(int n){
        return Math.abs(random.nextInt(n))%n;
    }
}
