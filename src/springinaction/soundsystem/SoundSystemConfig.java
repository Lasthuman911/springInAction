package springinaction.soundsystem;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by admin on 2017/2/7.
 */
@Configuration
@ImportResource("classpath:player.xml")
@Import({CDConfig.class,CDPlayerConfig.class})
//TODO 这种方式暂时没成功实现，会使cdPlayconfig中的compactDisc 找不到装配的bean
public class SoundSystemConfig {
}
