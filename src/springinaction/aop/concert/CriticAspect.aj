package springinaction.aop.concert;

/**
 * Created by admin on 2017/2/8.
 */
public aspect CriticAspect {
    public CriticAspect() {
    }
  //  pointcut performance(): execution(* springinaction.aop.concert.Persormance.perform(..));
    pointcut performance(): execution(* perform(..));

    after():performance(){
        System.out.println(criticismEngine.getCriticism());
    }

    private CriticismEngine criticismEngine;

    public void setCriticismEngine(CriticismEngine criticismEngine) {
        this.criticismEngine = criticismEngine;
    }

}
