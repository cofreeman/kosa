package day4.practice;

public class ArrayLab2 {
    public static void main(String[] args) {
        int[] arr = new int[10];
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 17) + 4;
        }
        for (int e: arr) {
            sum+= e;
        }
        System.out.print("모든 원소의 값: ");
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1){
                System.out.print(arr[i]);
                break;
            }
            System.out.print(arr[i] + ",");
        }
        System.out.println();
        System.out.printf("모든 원소의 합 : %d\n",sum);
    }
}
