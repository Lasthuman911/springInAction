package springinaction.advancedwried;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by admin on 2017/2/7.
 */
@Component
@Qualifier("code")//自定义限定词，在要注入的地方也使用相同的限定词即可，松耦合
//@Qualifier("cookies")//java 不允许一个条目上出现相同类型的注解
@Creamy//使用自定义的注解
public class Cookies implements Desert {
}
