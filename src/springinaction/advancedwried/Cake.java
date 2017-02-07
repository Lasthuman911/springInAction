package springinaction.advancedwried;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * Created by admin on 2017/2/7.
 */
@Component
@Primary//声明为首选bean，相同的类型只能设置一个，否则将产生歧义
public class Cake implements Desert {
}
