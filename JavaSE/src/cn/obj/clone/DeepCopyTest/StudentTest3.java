package cn.obj.clone.DeepCopyTest;

/**浅表复制，改变了Student1 没有改变student
 * Created by wzm on 2017/2/20 0020.
 */
public class StudentTest3 {
    public static void main(String[] args) {
        Dog dog = new Dog("wangcai2","15");
        Student student = new Student(12,"wzm",dog);
        Student student1 = (Student) student.clone();
        student1.getDog().setName("mimi");
        student1.getDog().setAge("1");
        System.out.println("Student's dog name = "+student.getDog().getName());
        System.out.println("Student's dog age = "+student.getDog().getAge());
    }
}

/*
        Student's dog name = wangcai2
        Student's dog age = 15
*/
