package cn.thread.initial;

/**
 * Name: admin
 * Date: 2017/2/22
 * Time: 15:50
 */
public class Test1 extends Thread {
    public Test1(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(this.getName() + " " + i);
        }
    }

    public static void main(String[] args) {

        Test1 thread0 = new Test1("线程1");
        Test1 thread1 = new Test1("线程2");

        System.out.println("thread0 的线程优先级= " + thread0.getPriority());
        System.out.println("thread1 的线程优先级= " + thread1.getPriority());

        //手动设置为最高优先级，thread1 将会优先于 thread0 执行
        thread1.setPriority(Thread.MAX_PRIORITY);
        System.out.println("thread1 的线程优先级= " + thread1.getPriority());
        System.out.println("current thread = " + Thread.currentThread().getName());
        System.out.println("current thread priority = " + Thread.currentThread().getPriority());

        //执行start方法并不表示里面执行，只是表示它处于可执行状态
        thread0.start();
        // thread0.start();//IllegalThreadStateException,只能对处于new状态的线程执行start方法
        thread1.start();
    }
}
