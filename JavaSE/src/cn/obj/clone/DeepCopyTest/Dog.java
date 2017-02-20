package cn.obj.clone.DeepCopyTest;

/**
 * Created by wzm on 2017/2/20 0020.
 */
public class Dog implements Cloneable {
    private String name;

    public String getName() {
        return name;
    }

    @Override
    public Object clone() {
        Dog dog = null;
        try {
            dog = (Dog) super.clone();
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        return dog;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    private String age;

    public Dog(String name, String age) {
        this.name = name;
        this.age = age;
    }
}
