package springinaction.soundsystem.config.javaConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.activation.DataSource;

/**
 * Created by admin on 2017/2/7.
 */
@Configuration
public class DataSourceConfig {
    @Bean
    @Profile("dev")
    public DataSource embeddedDataSource(){
        //TODO
        return null;
    }

    @Bean
    @Profile("pro")
    public DataSource jndiDataSource(){
        //TODO
        return null;
    }
}
