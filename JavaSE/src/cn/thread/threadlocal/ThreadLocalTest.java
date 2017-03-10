package cn.thread.threadlocal;

/**
 * Name: admin
 * Date: 2017/2/28
 * Time: 9:27
 */
public class ThreadLocalTest {
    public static void main(String[] args) {
        Account at = new Account("初始名");
        new MyThread("线程甲",at).start();
        new MyThread("线程已",at).start();
    }
}
