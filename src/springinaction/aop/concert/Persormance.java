package springinaction.aop.concert;

/**
 * Created by admin on 2017/2/8.
 */
public interface Persormance {
    public void perform();

    /*execution：在执行perform方法时应用通知*/
    //within 限定：此包下的任意类的方法被调用时
    //execution(*springinaction.aop.concert.Persormance.perform(..)) and within(springinaction.*)

    //bean指示器：限定bean 的id 为 woodstock
    //execution(*springinaction.aop.concert.Persormance.perform(..)) and bean("woodstock")

    //execution(*springinaction.aop.concert.Persormance.perform(..)) and !bean("woodstock")


}
