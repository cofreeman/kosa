package week1.day3.practice;

public class ForLab5 {
    public static void main(String[] args) {
        int randNum1 = (int) (Math.random() * 8) + 3;
        int randNum2 = (int) (Math.random() * 3) + 1;
        if (randNum2 == 1) {
            System.out.println("*".repeat(randNum1));
        } else if (randNum2 == 2) {
            System.out.println("$".repeat(randNum1));
        } else if (randNum2 == 3) {
            System.out.println("#".repeat(randNum1));
        }
    }
}
