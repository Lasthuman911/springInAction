package cn.thread.sync;

/**
 * Name: admin
 * Date: 2017/2/27
 * Time: 14:44
 */
public class DrawThread extends Thread {

    private Account account;
    private double drawQty;

    public DrawThread(String threadName,Account account, double drawQty) {
        super(threadName);
        this.account = account;
        this.drawQty = drawQty;
    }

    /**
     * 不添加同步代码块，容易出现线程安全问题
     */
    @Override
    public void run() {
        synchronized (account) {
            if (account.getBalance() - drawQty > 0) {
                System.out.println(Thread.currentThread().getName() + "取出了" + drawQty);
                account.setBalance(account.getBalance() - drawQty);
                System.out.println("账户余额为" + account.getBalance());
            }

        }
/*      if (account.getBalance() - drawQty >0){
          System.out.println(Thread.currentThread().getName()+"取出了"+drawQty);
          account.setBalance(account.getBalance()-drawQty);
          System.out.println("账户余额为"+account.getBalance());
      }*/

    }
}
