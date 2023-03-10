package day5.practice2;

public class MethodLab10 {
    public static void main(String[] args) {
        int a1[] = new int[]{1,2,3,4,5};
        MethodLab7.printArray(a1);
        powerArray(a1,3);
        MethodLab7.printArray(a1);

        int a2[] = new int[]{10,20,30,40,50,60};
        MethodLab7.printArray(a2);
        powerArray(a2,10);
        MethodLab7.printArray(a2);
    }

    static void powerArray(int[] arr, int i){
        if (i >5 && i<2) return;
        for (int j = 0; j < arr.length; j++) {
            arr[j] = arr[j] * i;
        }
    }
}
