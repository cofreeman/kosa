package week2.day2.exercise;

public class StudentTest {
    public static void main(String[] args) {
        Student student1 = new Student("홍길동",20,171,81,"201101","영문");
        Student student2 = new Student("고길동",21,183,72,"201102","건축");
        Student student3 = new Student("백길동",22,175,65,"201103","컴공");
        Student arrays[] = new Student[3];
        arrays[0] = student1;
        arrays[1] = student2;
        arrays[2] = student3;
        System.out.println("name 나이 신장 몸무게 학번 전공");
        for (int i = 0; i < arrays.length; i++) {
            System.out.println(arrays[i].printInformation());
        }
    }
}
