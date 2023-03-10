package day5.practice;

public class MethodLab3 {
    public static void main(String[] args) {
        System.out.printf("%d은 %s 입니다.",10,isEven(10)?"짝수":"홀수");
        System.out.println();
        System.out.printf("%d은 %s 입니다.",13,isEven(13)?"짝수":"홀수");
    }

    static boolean isEven(int num) {
        return num % 2 == 0;
    }
}
