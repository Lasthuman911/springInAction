package springinaction.advancedwried;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by admin on 2017/2/7.
 */
//自定义注解
    @Target({ElementType.CONSTRUCTOR,ElementType.FIELD,
            ElementType.METHOD,ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @Qualifier
public @interface Creamy {
}
