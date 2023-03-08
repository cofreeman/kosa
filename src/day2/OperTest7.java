package day2;

import java.util.Random;
import java.util.stream.Stream;

public class OperTest7 {

    public static void main(String[] args) {
        int a = 60;  // 0011 1100
        int b = 13;  // 0000 1101
        byte c = 0;

        c = (byte)(a & b);   // 0000 1100
        System.out.println(c);
    }
}
