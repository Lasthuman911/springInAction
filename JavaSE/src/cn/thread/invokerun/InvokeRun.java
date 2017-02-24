package cn.thread.invokerun;

/**
 * Name: admin
 * Date: 2017/2/24
 * Time: 15:18
 */
public class InvokeRun extends Thread {
    private int i;

    @Override
    public void run() {
        for (; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+ " " + i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 200; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            if (i == 10) {
                //初始化若不指定线程名字，以thread-0 -1 来表示
                //直接执行run方法，
                new InvokeRun().run();

                new InvokeRun().run();
            }
        }
    }
}
