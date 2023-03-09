package day4.practice2;

public class TwoArrayLab2 {
    public static void main(String[] args) {
        char cArr[][] = new char[][]{{'B', 'C', 'A', 'A'}, {'C', 'C', 'B', 'B'}, {'D', 'A', 'A', 'D'}};
        int[] arr = new int[4];
        for (int i = 0; i < cArr.length; i++) {
            for (int j = 0; j < cArr[i].length; j++) {
                arr[cArr[i][j] - 'A']++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%c는 %d개 입니다.",(char)('A' + i),arr[i]);
            System.out.println();
        }
    }
}
