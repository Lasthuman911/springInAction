package cn.CallBack;

/**
 * Name: admin
 * Date: 2017/3/3
 * Time: 22:52
 */
public class Wang implements CallBack {
    private Li li;

    public Wang(Li li) {
        this.li = li;
    }

    @Override
    public void solve(String result) {
        System.out.println("小李告诉小王的答案是--->" + result);
    }

    public void play() {
        System.out.println("去逛街");
    }

    public void askQuestion(final String question) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                li.executeMessage(Wang.this, question);
            }
        }).start();

        play();
    }
}
