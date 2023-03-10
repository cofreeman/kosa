package week1.personal;

import java.util.*;

public class Main {
    int[] arr;
    int arr2[] = new int[3];
    boolean[] barr = new boolean[3];
    float[] farr = new float[3];
    double[] darr = new double[3];
    int[] arr3 = new int[]{1,2,3};
    public static void main(String[] args) {
        Main main = new Main();
        main.method();
    }
    public void method(){
        System.out.println(arr);
        System.out.println("---");
        Arrays.stream(arr2).forEach(System.out::println);
        System.out.println(barr[0]);
        System.out.println(farr[0]);
        System.out.println(darr[0]);
    }
}
