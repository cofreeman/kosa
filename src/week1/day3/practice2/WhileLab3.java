package week1.day3.practice2;

public class WhileLab3 {
    public static void main(String[] args) {
        int loopCounter = 0;
        while (true) {
            int randNum = (int) (Math.random() * 31);
            if (randNum >= 27) {
                System.out.printf("출력횟수는 %d 번입니다.", loopCounter);
                break;
            } else {
                loopCounter++;
                System.out.printf("%d-%c, %d, 0x%X\n", randNum, randNum + 'A' - 1, randNum + 'A' - 1, randNum + 'A' - 1);
            }
        }
    }
}
