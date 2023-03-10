package week1.day2.실습;

public class ForLab3 {
    public static void main(String[] args) {
        int e1 = (int) (Math.random() * 10) + 1;
        int e2 = (int) (Math.random() * 10) + 30;
        int result = 0;
        for (int n = e1; n <= e2; n++) {
            if (n % 2 == 0) result += n;
        }
        System.out.printf("%d 부터 %d 까지의 짝수의 합 : %d", e1, e2, result);
    }
}
