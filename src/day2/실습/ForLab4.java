package day2.실습;

public class ForLab4 {
    public static void main(String[] args) {
        int evenNum = 0;
        int oddNum = 0;
        for (int n = 1;n <= 100;n++){
            if (n % 2 == 0) evenNum +=n;
            if (n % 2 == 1) oddNum +=n;
        }
        System.out.printf("1부터 100까지의 숫자들 중에서 \n짝수의 합은 %d 이고\n홀수의 합은 %d 이다.",evenNum,oddNum);
    }
}
