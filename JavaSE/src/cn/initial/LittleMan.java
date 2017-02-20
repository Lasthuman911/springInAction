package cn.initial;

/**
 * Created by admin on 2017/2/20.
 */
public class LittleMan extends Man {
    String a2 = "huhu";
    public LittleMan() {
        st();
    }

    public void st(){
        System.out.println("LittleMan ="+a2);
    }

    public static void main(String[] args){
        new LittleMan();

    }
}
