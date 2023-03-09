package day4.practice2;

public class TwoArrayLab4 {
    public static void main(String[] args) {
        int[][] arr = {
                {10,20,30,40,50},
                {5,10,15},
                {11,22,33,44},
                {9,8,7,6,5,4,3,2,1}
        };
        for (int i = 0; i < arr.length; i++) {
            int sumOfRow = 0;
            for (int j = 0; j < arr[i].length; j++) {
                sumOfRow += arr[i][j];
            }
            System.out.printf("%d행의 합은 %d 입니다.",i + 1,sumOfRow);
            System.out.println();
        }
    }
}
