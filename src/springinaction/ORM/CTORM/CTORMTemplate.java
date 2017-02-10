package springinaction.ORM.CTORM;

import java.lang.annotation.*;

/**
 * Created by admin on 2017/2/10.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface CTORMTemplate {
    String seq();
    String name();
    String type();
    String dataType();
    String initial();
    String history();
}
