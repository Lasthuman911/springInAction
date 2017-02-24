package cn.thread.initial;

/**
 * Name: admin
 * Date: 2017/2/22
 * Time: 16:14
 */
public class Test2 implements Runnable {

    private int i;

    public static void main(String[] args) {

        for (int i = 0; i < 200; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            if (i == 10) {
                //start 方法不代表立刻执行，初始化若不指定线程名字，以thread-0 -1 来表示
                Test2 test2 = new Test2();
                Test2 test3 = new Test2();
                new Thread(test2, "thread-1").start();
                new Thread(test3, "thread-2").start();
            }
        }
    }

    @Override
    public void run() {
        for (; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}
