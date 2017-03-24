package ch2;

/**
 * Name: admin
 * Date: 2017/3/24
 * Time: 17:14
 */

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
//@ComponentScan//默认扫描的是同一个目录下的包
//@ComponentScan("ch2")//指定特定的包名
@ComponentScan(basePackages = {"ch2"})
public class CDPlayerConfig {
}
