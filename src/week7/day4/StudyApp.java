package week7.day4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudyApp {

    public static void main(String[] args) {
        ApplicationContext factory
            = new ClassPathXmlApplicationContext("bean1.xml");
        Student st1 = (Student) factory.getBean("st1");
        Student st2 = (Student) factory.getBean("st2");
        Student st3 = (Student) factory.getBean("st3");
        System.out.printf("%s는 %s를 학습합니다.\n", st1.getName(), st1.getMyHomework().getHomeworkName());
        System.out.printf("%s는 %s를 학습합니다.\n", st2.getName(), st2.getMyHomework().getHomeworkName());
        System.out.printf("%s는 %s를 학습합니다.\n", st3.getName(), st3.getMyHomework().getHomeworkName());

        ((ClassPathXmlApplicationContext) factory).close();
    }
}
