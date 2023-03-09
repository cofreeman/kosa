package day4.practice;

public class ArrayLab1 {
    public static void main(String[] args) {
        int[] ary = new int[10];
        for (int e: ary) {
            System.out.print(e + " ");
        }
        for (int i = 0; i < 10; i++) {
            ary[i] = 10 * (i + 1);
        }
        System.out.println();
        System.out.printf("첫번째: %d\n마지막 : %d\n합: %d\n",ary[0],ary[ary.length - 1], ary[0] + ary[ary.length -1]);
        for (int i = 0; i < ary.length; i++) {
            System.out.print(ary[ary.length - i - 1] + " ");
        }
        System.out.println();
        for (int i = 1; i < ary.length; i+=2) {
            System.out.print(ary[i] + " ");
        }
    }
}
