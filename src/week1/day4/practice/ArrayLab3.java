package week1.day4.practice;

public class ArrayLab3 {
    public static void main(String[] args) {
        char[] cArr = {'J','a','v','a'};
        for (char c: cArr) {
            System.out.println(Character.isUpperCase(c)?Character.toLowerCase(c):Character.toUpperCase(c));
        }
    }
}
