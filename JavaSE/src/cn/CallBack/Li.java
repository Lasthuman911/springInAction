package cn.CallBack;

/**
 * Name: admin
 * Date: 2017/3/3
 * Time: 22:56
 */
public class Li {

    public void executeMessage(CallBack callBack, String question) {
        System.out.println("小王的问题----->" + question);
        for (int i = 0; i < 10000; i++){}
        String result = "2";
        callBack.solve(result);
    }
}
