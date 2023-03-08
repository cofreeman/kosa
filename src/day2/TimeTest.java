package day2;

public class TimeTest {
    public static int SECOND_TO_HOUR = 60 * 60;
    public static int SECOND_TO_MINUTE = 60;


    public static void main(String[] args) {
        int time = 32150;
        int hour = time / (60 * 60);
        int minute = (time % (60 * 60)) / 60;
        int second = time % 60;

        System.out.println(time / SECOND_TO_HOUR + "시간 " + ((time - SECOND_TO_HOUR * (time / SECOND_TO_HOUR))/SECOND_TO_MINUTE) +"분 " +time % SECOND_TO_MINUTE + "초");
        System.out.println(hour);
        System.out.println(minute);
        System.out.println(second);
    }
}
