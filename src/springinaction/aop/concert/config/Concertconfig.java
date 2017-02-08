package springinaction.aop.concert.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import springinaction.aop.concert.Audience;

/**
 * Created by admin on 2017/2/8.
 */
@Configuration
@ComponentScan(basePackageClasses = Audience.class)
@EnableAspectJAutoProxy //启用AspectJ 自动代理
public class Concertconfig {

    @Bean
    public Audience audience(){
        return new Audience();
    }
}
