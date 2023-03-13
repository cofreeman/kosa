package week2.day1.practice;

class Student{
    String name;
    int age;
    String subject;

    public Student() {
        this("듀크", 28, "스프링");

    }

    public Student(String name, int age, String subject) {
        this.name = name;
        this.age = age;
        this.subject = subject;
    }


    void printStudentInfo(){
        System.out.printf("%s 학생의 나이는 %d 입니다.\n",name,age);
    }
    void study(){
        System.out.printf("%s 학생은 %s 과목을 공부합니다.\n",name,subject);
    }

}
public class StudentTest {
    public static void main(String[] args) {
        Student st1 = new Student();
        Student st2 = new Student();
        System.out.println("st1이 참조하는객체 정보: " +st1);
        System.out.println("st1이 참조하는객체 정보: " +st2);

        st1.name = "둘리";
        st1.age = 10;
        st1.subject = "HTML5";

        st1.printStudentInfo();
        st1.study();

        st2.name = "또치";
        st2.age = 10;
        st2.subject = "CSS3";

        st2.printStudentInfo();
        st2.study();

    }
}
