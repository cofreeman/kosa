package day2;

public class AlphaTest {
    public static void main(String[] args) {
        int num = (int) (Math.random() * 26) + 1;
        char c1 = 'A';
        System.out.println((char) (c1 - 1 + num));
    }
}
