package day3.practice;

public class ForLab9 {
    public static void main(String[] args) {
        int randNum = (int) (Math.random() * 2) + 1;
        for (int i = randNum; i < 10; i+=2) {
            for (int j = 1; j <= 9; j++) {
                System.out.printf("%dx%d=%d ",i,j,i * j);
            }
            System.out.println();
        }
    }
}
