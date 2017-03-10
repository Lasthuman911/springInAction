package cn.thread.threadlocal;

/**
 * Name: admin
 * Date: 2017/2/28
 * Time: 9:19
 */
public class Account {
    private ThreadLocal<String> name  = new ThreadLocal<>();

    public Account(String name) {
        this.name.set(name);
        System.out.println("----"+this.name.get());
    }

    public String getName() {
        return name.get();
    }

    public void setName(String str) {
        this.name.set(str);
    }
}
