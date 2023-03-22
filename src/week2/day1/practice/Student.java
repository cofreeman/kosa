package week2.day1.practice;

import java.io.Serializable;

public class Student implements Serializable {
    public static final int serialVersionUID = 1;
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


    public void printStudentInfo(){
        System.out.printf("%s 학생의 나이는 %d 입니다.\n",name,age);
    }
    void study(){
        System.out.printf("%s 학생은 %s 과목을 공부합니다.\n",name,subject);
    }

}
