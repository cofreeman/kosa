package day4.practice2;

public class TwoArrayLab5 {
    public static void main(String[] args) {
        int[][] arr = new int[5][3];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        int initNum = 0;
        for (int i = 0; i < arr[0].length; i++) {
            for (int j = i; j < arr.length - i; j++) {
                arr[j][i] = ++initNum;
            }
        }
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }
}
