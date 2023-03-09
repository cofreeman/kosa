package day4.practice2;

public class TwoArrayLab3 {
    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {5,2,1,0,2,3,6},
                {4,3,2,1,1,0,5},
                {3,1,2,1,3,1,3},
                {4,3,1,0,4,2,7}
        };
        String[] day = {"일","월","화","수","목","금","토"};
        int[] sumOfGameTimeByDay = new int[7];
        int[] sumOfGameTimeByWeek = new int[4];
        for (int i = 0; i < arr[0].length; i++) {
            for (int j = 0; j < arr.length; j++) {
                sumOfGameTimeByDay[i] += arr[j][i];
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                sumOfGameTimeByWeek[i] += arr[i][j];
            }
        }
        for (int i = 0; i < sumOfGameTimeByDay.length; i++) {
            System.out.printf("%s요일 : %d시간",day[i],sumOfGameTimeByDay[i]);
            System.out.println();
        }
        System.out.println("-----");
        for (int i = 0; i < sumOfGameTimeByWeek.length; i++) {
            System.out.printf("%d주차 : %d시간",i + 1,sumOfGameTimeByWeek[i]);
            System.out.println();
        }
    }
}
