package cn.thread.initial.p2;

/**
 * Name: admin
 * Date: 2017/2/22
 * Time: 16:14
 */
public class Test2 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }

    public static void main(String[] args) {
        Thread thread0 = new Thread(new Test2());
        thread0.start();
    }
}
