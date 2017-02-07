package springinaction.soundsystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by admin on 2017/2/7.
 */
@Configuration
public class CDConfig {
    @Bean
    public CompactDisc compactDisc(){
        return new SgtPeppers();
    }
}
