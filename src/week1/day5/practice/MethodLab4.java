package week1.day5.practice;

public class MethodLab4 {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            int randNum1 = (int) (Math.random() * 30) + 1;
            int randNum2 = (int) (Math.random() * 30) + 1;
            System.out.printf("%d 와 %d 의 차는 %d 입니다.\n",randNum1,randNum2,getGapOfNum(randNum1,randNum2));
        }

    }
    static int getGapOfNum(int num1, int num2){
        return Math.abs(num1 - num2);
    }
}
