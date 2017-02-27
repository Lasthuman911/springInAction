package cn.thread.sync.version2;

/**
 * Name: admin
 * Date: 2017/2/27
 * Time: 15:11
 */
public class DrawThread extends Thread {

    private Account account;
    private double drawQty;

    public DrawThread(String threadName, Account account, double drawQty) {
        super(threadName);
        this.account = account;
        this.drawQty = drawQty;
    }

    /**
     * 不添加同步代码块，容易出现线程安全问题
     */
    @Override
    public void run() {
        double result = account.drawMoney(drawQty);
        if (result == 0)
            System.out.println(Thread.currentThread().getName() + "取钱失败" + "账户当前余额为" + account.getBalance());
        else
            System.out.println(Thread.currentThread().getName() + "成功取出" + drawQty + "当前账户余额为" + account.getBalance());
    }
}
