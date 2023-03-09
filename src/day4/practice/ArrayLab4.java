package day4.practice;

public class ArrayLab4 {
    public static void main(String[] args) {
        int randNum = (int) (Math.random() * 6) + 5;
        int[] arr = new int[randNum];
        char[] cArr = new char[randNum];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 26) + 1;
        }
        for (int i = 0; i < cArr.length; i++) {
            cArr[i] = (char)(arr[i] + 'a' - 1);
        }
        for (int i = 0; i < arr.length; i++) {
            if(i == arr.length - 1){
                System.out.println(arr[i]);
                break;
            }
            System.out.print(arr[i] + ",");
        }
        for (int i = 0; i < cArr.length; i++) {
            if(i == cArr.length - 1){
                System.out.println(cArr[i]);
                break;
            }
            System.out.print(cArr[i] + ",");
        }
    }
}
