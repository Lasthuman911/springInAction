package cn.obj.clone.DeepCopyTest;


import cn.obj.clone.DeepCopyTest.Dog;

/**
 * Created by wzm on 2017/2/20 0020.
 */
public class Student implements Cloneable {

    int id;
    String name;

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    Dog dog;

    public Student(int id, String name, Dog dog) {
        this.id = id;
        this.name = name;
        this.dog = dog;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Object clone() {
        Student s = null;
        try {
            s = (Student) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        s.dog = (Dog) dog.clone();
        return s;
    }
}
