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
    int[][] arr5 = new int[3][5];
    int arr6[][] = new int[3][5];

    int arr7[][] = new int[][]{{1,2,3},{1,2,3},{1,2}};
    int arr8[][][][][][][][][][] = new int[3][3][3][3][3][3][3][3][3][3];
    //시간이 오래걸림
//    int arr9[][][][][][][][][][][][][][][][][][][][] = new int[3][3][3][3][3][3][3][3][3][3][3][3][3][3][3][3][3][3][3][3];

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
        System.out.println(arr7[0][0] + " " + arr7[2][1]);
        System.out.println(arr6[2][2]);
        System.out.println("----");
        System.out.println(arr8[0][0][0][2][2][2][2][1][1][1]);
//        System.out.println(arr9[2][2][2][2][2][2][2][2][2][2][2][2][2][2][2][2][2][2][2][2]);
    }
}
