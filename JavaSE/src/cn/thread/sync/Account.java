package cn.thread.sync;

/**
 * Name: admin
 * Date: 2017/2/27
 * Time: 14:24
 */
public class Account {
    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    String accountNo;
    double balance;

    public Account(String accountNo, double balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }

    /**
     * 重写equals方法，当accountNo相同时，认为两个对象相等
     *
     * @param o 要比较的对象
     * @return boolean，两个对象Account是否相等，若accountNo相同返回true，否则返回false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Account.class != o.getClass()) return false;

        Account account = (Account) o;

        return account.getAccountNo().equals(accountNo);

    }

    /**
     * 重写了equals方法，也必须同时重写hashCode方法，将会影响equals的变量参与hashCode的计算
     *
     * @return int 返回accountNo对应的hash值
     */
    @Override
    public int hashCode() {
        return accountNo.hashCode();
    }
}
