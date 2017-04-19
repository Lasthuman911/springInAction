package ch2;

/**
 * Name: admin
 * Date: 2017/3/24
 * Time: 17:14
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
//@ComponentScan//默认扫描的是同一个目录下的包
//@ComponentScan("ch2")//指定特定的包名
//@ComponentScan(basePackages = {"ch2"})//手动指定包名
//@ComponentScan(basePackageClasses = CDPlayerConfig.class)//也可以手动指定类所在的包
public class CDPlayerConfig {
    @Bean//默认情况下，bean ID = 方法名
//    @Bean(name = "lonelyHeartsClubBand")//手动指定bean名
    public CompactDisc sgtPeppers(){
        return new SgtPeppers();//方法内包含产生bean的逻辑
    }

    @Bean//将CDPlayer和CompactDisc装配在一起
    public CDPlayer cdPlayer(){
        return new CDPlayer(sgtPeppers());
    }

    @Bean//和cdPlayer得到的两个相同的CompactDict
    //Spring此时会拦截对sgtPepper的调用，返回Spring已经创建的sgtPeppers实例
    public CDPlayer anotherCDPlayer(){
        return new CDPlayer(sgtPeppers());
    }

    @Bean//最佳方法
    public CDPlayer thridCDPlayer(CompactDisc compactDisc){
        return new CDPlayer(compactDisc);
    }

    @Bean//通过setter方式注入
    public CDPlayer fourthCDPlayer(CompactDisc compactDisc){
        CDPlayer cdPlayer = new CDPlayer();
        cdPlayer.setCd(compactDisc);
        return cdPlayer;
    }
}
