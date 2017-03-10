package cn.CallBack;

/**
 * Name: admin
 * Date: 2017/3/3
 * Time: 23:02
 */
public class CallBackTest {
    public static void main(String[] args) {
        Li li = new Li();
        Wang wang = new Wang(li);
        wang.askQuestion("1 + 1 = ?");
    }
}
