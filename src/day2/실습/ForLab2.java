package day2.실습;

public class ForLab2 {
    public static void main(String[] args) {
        for (int i = 9; i >= 4; i--) {
            System.out.println(i +" : " + (i%2 == 1?"홀수":"짝수"));
        }
    }
}
