package week1.day5.practice2;

public class MethodLab7 {
    public static void main(String[] args) {
        printArray(powerArray(2));
        printArray(powerArray(3));
        printArray(powerArray(4));
    }
    static void printArray(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ((arr.length - 1 != i)?",":"\n"));
        }
    }
    static int[] powerArray(int i){
        int[] ints = new int[10];
        for (int j = 0; j < ints.length; j++) {
            ints[j] = i * (j+1);
        }
        return ints;
    }
}
