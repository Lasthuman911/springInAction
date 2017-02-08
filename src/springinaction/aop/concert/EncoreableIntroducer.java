package springinaction.aop.concert;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

/**
 * Created by admin on 2017/2/8.
 */
@Aspect
public class EncoreableIntroducer {

    @DeclareParents(value = "springinaction.aop.concert.Persormance+",
    defaultImpl = DefaultEncoreable.class)
    public static Encoreable encoreable;
}
