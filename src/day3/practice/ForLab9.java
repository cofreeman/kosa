package day3.practice;

public class ForLab9 {
    public static void main(String[] args) {
        int randNum = (int) (Math.random() * 2) + 1;
        if (randNum == 1) {
            for (int i = 1; i < 10; i+=2) {
                for (int j = 1; j <= 9; j++) {
                    System.out.printf("%dx%d=%d ",i,j,i * j);
                }
                System.out.println();
            }
        } else if(randNum == 2){
            for (int i = 2; i < 10; i+=2) {
                for (int j = 1; j <= 9; j++) {
                    System.out.printf("%dx%d=%d ",i,j,i * j);
                }
                System.out.println();
            }
        }
    }
}
