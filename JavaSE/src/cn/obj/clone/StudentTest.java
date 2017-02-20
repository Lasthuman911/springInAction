package cn.obj.clone;

/**
 * 修改student1 之后  对student 无影响
 * Created by wzm on 2017/2/20 0020.
 */
public class StudentTest {
    public static void main(String[] args) {
        Student student = new Student(1, "wzm");
        Student student1 = (Student) student.clone();
        System.out.println("Student1'name：" + student1.getName() + " id：" + student1.getId());
        System.out.println("Student'name：" + student.getName() + " id：" + student.getId());
        student1.setId(2);
        student1.setName("lishuzhen");
        System.out.println("After reSet " + "Student1'name：" + student1.getName() + " id：" + student1.getId());
        System.out.println("After reSet " + "Student'name：" + student.getName() + " id：" + student.getId());

        StudentTest studentTest = new StudentTest();
        // studentTest.clone();
    }
}
/*      Student1'name：wzm id：1
        Student'name：wzm id：1
        After reSet Student1'name：lishuzhen id：2
        After reSet Student'name：wzm id：1
*/
