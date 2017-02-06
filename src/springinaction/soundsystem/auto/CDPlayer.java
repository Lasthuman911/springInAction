package springinaction.soundsystem.auto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import springinaction.soundsystem.CompactDisc;

/**
 * Created by admin on 2017/2/4.
 */
@Component
public class CDPlayer implements MediaPlayer {
/*    @Autowired
    public void setCd(CompactDisc cd) {
        this.cd = cd;
    }*/
/*    @Autowired//作用于普通方法上一样可以实现自动装配
    public void insertDisc(CompactDisc cd){
        this.cd = cd;
    }*/
    private CompactDisc cd;

    @Autowired(required = false)
    //如果设置为true则一定要有匹配的bean，否则将抛出异常
    //设置为false，若无匹配的bean，则bean处于未装配状态，需要在代码中进行null的检查
    public CDPlayer(CompactDisc cd){
        this.cd = cd;
    }
    @Override
    public void play() {
        cd.play();
    }
}
