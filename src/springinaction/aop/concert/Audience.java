package springinaction.aop.concert;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * Created by admin on 2017/2/8.
 */
//@Aspect //case 1~3
public class Audience {
/*    //case 3
    //注意* 后面要跟一个空格
    @Pointcut("execution(* springinaction.aop.concert.Persormance.perform(..))")
    public void performance() {}
    @Around("performance()")//定义环绕通知
    public void watchePerformacnce(ProceedingJoinPoint jp) {
        try {
            System.out.println("make phone silent");
            jp.proceed();
            System.out.println("good");
        } catch (Throwable e) {
            System.out.println("bad");
        }
    }
*/

/*  //case2
  @Before("performance()")
    public void silenceCellPhones() {
        System.out.println("make phone silent");
    }

    @Before("performance()")
    public void seat() {
        System.out.println("take a seta");
    }

    @AfterReturning("performance()")
    public void applause() {
        System.out.println("good");
    }

    @AfterThrowing("performance()")
    public void demandRefund() {
        System.out.println("bad");
*/


/*     //case 1:
    @Before("execution(**springinaction.aop.concert.Persormance.perform(..))")
    public void silenceCellPhones() {
        System.out.println("make phone silent");
    }

    @Before("execution(**springinaction.aop.concert.Persormance.perform(..))")
    public void seat() {
        System.out.println("take a seta");
    }

    @AfterReturning("execution(**springinaction.aop.concert.Persormance.perform(..))")
    public void applause() {
        System.out.println("good");
    }

    @AfterThrowing("execution(**springinaction.aop.concert.Persormance.perform(..))")
    public void demandRefund() {
        System.out.println("bad");
*/

//case 4 :基于xml
public void silenceCellPhones() {
    System.out.println("make phone silent");
}

    public void seat() {
        System.out.println("take a seta");
    }

    public void applause() {
        System.out.println("good");
    }

    public void demandRefund() {
        System.out.println("bad");
    }

    public void watchePerformacnce(ProceedingJoinPoint jp) {
        try {
            System.out.println("make phone silent");
            jp.proceed();
            System.out.println("good");
        } catch (Throwable e) {
            System.out.println("bad");
        }
    }
}

