package springinaction.advancedwried;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created by admin on 2017/2/7.
 */
public class DesertTest {
    @Autowired
  //  @Qualifier("cookies")//若不限定则按照Primary 限定的首选bean，紧耦合
    @Qualifier("code")
    public void setDesert(Desert desert) {
        this.desert = desert;
    }

    private Desert desert;

}
