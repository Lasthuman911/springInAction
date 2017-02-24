package cn.thread.initial;

/**
 * Name: admin
 * Date: 2017/2/24
 * Time: 13:56
 */
public class FirstThread extends Thread {
    private int i;

    @Override
    public void run() {
        for (; i < 100; i++) {
            System.out.println(this.getName() + " " + i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 200; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            if (i == 10) {
                //start 方法不代表立刻执行，初始化若不指定线程名字，以thread-0 -1 来表示
                new FirstThread().start();

                new FirstThread().start();
            }
        }
    }
}
