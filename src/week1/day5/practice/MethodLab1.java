package week1.day5.practice;

public class MethodLab1 {
    public static void main(String[] args) {
        printTitle();
        System.out.printf("가격은 %,d원입니다.",getPrice());
    }
    static void printTitle(){
        System.out.println("우리의 자바교재명은 <이것은 자바다> 입니다.");
    }

    static int getPrice(){
        return 36000;
    }
}
