package week1.day3.practice2;

public class WhileLab1 {
    public static void main(String[] args) {
        int randNum = (int) (Math.random() * 6) + 1;
        int num = 0;
        System.out.println("[ for 결과 ]");
        for (int i = 1; i <= randNum; i++) {
            System.out.printf("%d -> %d\n", i, i * i);
        }
        System.out.println("[ while 결과 ]");
        while (num++ < randNum) {
            System.out.printf("%d -> %d\n", num, num * num);

        }
    }
}
