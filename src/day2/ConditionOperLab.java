package day2;

public class ConditionOperLab {
    public static void main(String[] args) {
        int var = (int) (Math.random() * 5) + 1;
        int e1 = 300;
        int e2 = 50;
        int result = 0;
        if (var == 1) {
            result = e1 + e2;
        } else if (var == 2) {
            result = e1 - e2;
        } else if (var == 3) {
            result = e1 * e2;
        } else if (var == 4) {
            result = e1 / e2;
        } else if (var == 5) {
            result = e1 % e2;
        }
        System.out.println("결과값 : " + result);
    }
}
