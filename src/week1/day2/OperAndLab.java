package week1.day2;

public class OperAndLab {
    public static void main(String[] args) {
        int grade = (int)(Math.random() * 6) + 1;
        if (true && grade == 1 || grade == 2 || grade == 3){
            System.out.println(grade + " 학년은 저학년입니다.");
        } else if (true && grade == 4 || grade == 5 || grade == 6){
            System.out.println(grade + " 학년은 고학년입니다.");
        }
    }
}