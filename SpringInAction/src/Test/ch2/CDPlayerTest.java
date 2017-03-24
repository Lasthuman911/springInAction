package ch2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

/**
 * Name: admin
 * Date: 2017/3/24
 * Time: 17:33
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CDPlayerConfig.class)
public class CDPlayerTest {
    @Autowired
    private CompactDisc cd;//初始化的时候是null

    @Test
    public void cdShouldNotBeNull(){
        assertNotNull(cd);//若测试通过，表示成功的在spring上下文中创建了bean
    }
}
