package week1.day3.practice2;

public class ControlLab1 {
    public static void main(String[] args) {
        int loopCounter = 0;
        while (true){
            int randNum = (int) (Math.random() * 11) + 10;
            if (randNum % 3 == 0 || randNum % 5 == 0){
                loopCounter++;
                int tmp = 0;
                for (int i = 1; i <= randNum; i++) {
                    tmp +=i;
                }
                System.out.println(tmp);
            }else if (randNum == 11 || randNum == 17 || randNum == 19) {
                System.out.printf("%d회 반복함",loopCounter);
                break;
            }else {
                System.out.println("재수행");
            }
        }
    }
}
