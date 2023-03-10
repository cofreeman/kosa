package day5.practice;

public class MethodLab5 {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.print(getRandom(10) + (i != 4?", ":"\n"));
        }
        for (int i = 0; i < 5; i++) {
            System.out.print(getRandom(10,20) + (i != 4?", ":"\n"));
        }
    }

    public static int getRandom(int n) {
        return (int) (Math.random() * n) + 1;
    }

    public static int getRandom(int n1, int n2) {
        return (int) (Math.random() * (n2 - n1 + 1)) + n1;
    }

}
