package cn.obj.clone.SimpleCopyTest;

/**
 * Created by wzm on 2017/2/20 0020.
 */
public class Dog {
    private String name;

    public String getName() {
        return name;
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
