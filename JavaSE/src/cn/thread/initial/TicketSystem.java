package cn.thread.initial;

/**
 * 为什么一般都使用Runable，因为一般情况下，都要共享变量
 * Name: admin
 * Date: 2017/2/24
 * Time: 17:22
 */
public class TicketSystem implements Runnable {
    private int ticketCount = 10;
    @Override
    public void run() {
        for (int i=0;i<10 ;i++) {
            if (ticketCount >= 0) {
                System.out.println(Thread.currentThread().getName() + "卖票，还剩" + ticketCount-- + "张票");
            }
        }
    }

    public static void main(String[] args) {
        TicketSystem ticketSystem = new TicketSystem();
        new Thread(ticketSystem,"1号票贩子").start();
        new Thread(ticketSystem,"2号票贩子").start();
        new Thread(ticketSystem,"3号票贩子").start();//使用了共享变量，总共只能卖出10张票，若使用继承Thread，则一共会卖出30张票，不符合实际
    }
}
