package cn.thread.sync;

/**
 * Name: admin
 * Date: 2017/2/27
 * Time: 14:51
 */
public class DrawTest {

    public static void main(String[] args) {
        Account account = new Account("yyy",1000);
        DrawThread firstThread = new DrawThread("甲",account,800);
        DrawThread secondThread = new DrawThread("乙",account,800);
        firstThread.start();
        secondThread.start();
    }
}
