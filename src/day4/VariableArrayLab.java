package day4;

import java.util.Arrays;

public class VariableArrayLab {
    int[] arr;
    int arr2[] = new int[3];
    boolean[] barr = new boolean[3];
    float[] farr = new float[3];
    double[] darr = new double[3];
    int[] arr3 = new int[]{1, 2, 3};
    int[] arr4 = {1,2,3,4};

    public static void main(String[] args) {
        VariableArrayLab main = new VariableArrayLab();
        main.method();
    }

    public void method() {
        System.out.println(arr);
        System.out.println("---");
        Arrays.stream(arr2).forEach(System.out::print);
        System.out.println(barr[0]);
        System.out.println(farr[0]);
        System.out.println(darr[0]);
    }
}
