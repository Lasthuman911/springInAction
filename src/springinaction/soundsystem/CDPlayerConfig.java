package springinaction.soundsystem;

/**
 * Created by admin on 2017/2/4.
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springinaction.soundsystem.auto.CDPlayer;

@Configuration//表示此类是配置类
@ComponentScan(basePackageClasses = {CDPlayerConfig.class})//(basePackages={"springinaction.soundsystem"})//启用了组件扫描，默认情况下Spring是不启动自动扫描的，当前设置会扫描与配置类相同的包及子包(需要手动指定，书上说的有问题
//后续看源码,最新的spring 4.0 不需要手动设置，但是4.0 以下的版本还是需要手动配置)
public class CDPlayerConfig {
    @Bean(name = "lonelyHeartsCludBand")//默认情况 bean ID = 方法名
    //Spring會攔截所有對他的調用，并確保直接返回該方法所創建的bean，而不是每次都對其進行實際的調用
    public CompactDisc sgtPeppers() {
        return new SgtPeppers();
    }

/*    @Bean
    public CompactDisc randomBeatlesCD() {
        int choice = (int) Math.floor(Math.random() * 4);
        if (choice == 0)
            return new SgtPeppers();
        return null;
    }*/
    @Bean//最簡單的方式：引用創建bean的方法
    public CDPlayer cdPlayer(){
        return new CDPlayer(sgtPeppers());
    }
/*
    @Bean//兩個CDPlayer bean會得到相同的sgtPeppers實例
    public CDPlayer anotherCdPlayer(){
        return  new CDPlayer(sgtPeppers());
    }*/
/*    //最佳選擇
    @Bean
    public CDPlayer cdPlayer(CompactDisc compactDisc){
        return new CDPlayer(compactDisc);
    }*/
/*    //採用Setter方法注入CompactDisc
    @Bean
    public CDPlayer cdPlayer(CompactDisc compactDisc){
        CDPlayer cdPlayer = new CDPlayer(compactDisc);
        cdPlayer.setCompactDisc(compactDisc);
        return  cdPlayer;
    }*/
}