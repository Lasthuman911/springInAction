package ch2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by lszhen on 2017/3/25.
 */
@Component
public class CDPlayer implements MediaPlayer {
    private CompactDisc cd;

    public CompactDisc getCd() {
        return cd;
    }

    public void setCd(CompactDisc cd) {
        this.cd = cd;
    }

    @Autowired(required = false)//默认是true，若上下文中没有此类型的bean，则会报异常
//    @Inject java注解规范，在大多数情况下和Autowired可以通用
    public CDPlayer(CompactDisc cd){
        this.cd = cd;
    }

    public CDPlayer(){}
    @Override
    public String paly() {
       return cd.play();
    }
}
