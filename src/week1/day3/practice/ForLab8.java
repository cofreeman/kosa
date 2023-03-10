package week1.day3.practice;

public class ForLab8 {
    public static void main(String[] args) {
        final char STAR = '*';
        for (int i = 0; i < 5; i++) {
            System.out.print(" ".repeat(i));
            for (int j = 0; j < 10; j++) {
                System.out.print(STAR);
            }
            System.out.println();
        }
    }
}
