package day3.practice;

public class ForLab6 {
    public static void main(String[] args) {
        final char c = '&';
        int randNum = (int)(Math.random() * 6) + 5;
        for (int i = 0; i < randNum; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
