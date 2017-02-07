package springinaction.soundsystem;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import springinaction.soundsystem.auto.MediaPlayer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


/**
 * Created by admin on 2017/2/4.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= CDPlayerConfig.class)
/*@ActiveProfiles("dev")//在测试的时候激活某个pfile*/
public class CDPlayerTest
{
    @Rule//基于控制台的输出编写断言
    public final StandardOutputStreamLog log = new StandardOutputStreamLog();

    @Autowired
    private MediaPlayer player;

    @Autowired
    private CompactDisc cd;

    @Test
    public void cdShouldNotBeNull()
    {
        assertNotNull(cd);
    }

    @Test
    public void play(){
        player.play();
        assertEquals("Playingsgt.title by sgt.artist",log.getLog());
    }
}
