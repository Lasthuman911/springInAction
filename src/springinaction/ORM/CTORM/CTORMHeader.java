package springinaction.ORM.CTORM;

import java.lang.annotation.*;

/**
 * Created by admin on 2017/2/9.
 */
//TODO:各代表什么意思
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface CTORMHeader {
    String tag();
    String divider();
}
