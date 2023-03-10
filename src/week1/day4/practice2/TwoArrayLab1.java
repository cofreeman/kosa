package week1.day4.practice2;

public class TwoArrayLab1 {
    public static void main(String[] args) {
        int[][] arr = new int[4][4];
        int initInt = 10;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = initInt;
                initInt+=2;
            }
        }
        System.out.printf("1행 1열의 데이터 : %d\n",arr[0][0]);
        System.out.printf("3행 4열의 데이터 : %d\n",arr[2][3]);
        System.out.printf("행의 갯수: %d\n",arr.length);
        System.out.printf("열의 갯수: %d\n",arr[0].length);
        System.out.print("3행의 데이터들: ");
        for (int i = 0; i < arr[2].length; i++) {
            System.out.print(arr[2][i] + " ");
        }
        System.out.println();
        System.out.print("2열의 데이터들: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i][1] + " ");
        }
        System.out.println();
        System.out.print("왼쪽 대각선의 데이터들 : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i][i] + " ");
        }
        System.out.println();
        System.out.print("오른쪽 대각선의 데이터들 : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i][arr.length - 1 - i] + " ");
        }
    }
}
