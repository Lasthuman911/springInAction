package cn.thread.threadlocal;

import cn.thread.sync.*;

/**
 * Name: admin
 * Date: 2017/2/28
 * Time: 9:23
 */
public class MyThread extends Thread {
    private Account account;

    public MyThread( String name, Account account) {
        super(name);
        this.account = account;
    }

    @Override
    public void run() {
        for (int i=0 ;i<10;i++){
            if (i==6)
                account.setName(getName());
            System.out.println(account.getName()+"账户i="+i);
        }
    }
}
