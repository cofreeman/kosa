package day3.practice;

public class ForLab7 {
    public static void main(String[] args) {
        final char STAR = '*';
        for (int i = 0; i < 7; i++) {
            for (int j = 7; j > i; j--) {
                System.out.print(STAR);
            }
            System.out.println();
        }
    }
}
