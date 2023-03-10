package day5.practice2;

public class MethodLab8 {
    public static void main(String[] args) {
        System.out.printf("호출 1 : %d\n",addEven(10,2,5,13,7));
        System.out.printf("호출 2 : %d\n",addEven(11,22,33,44,55,66));
        System.out.printf("호출 3 : %d\n",addEven());
        System.out.printf("호출 4 : %d\n",addEven(100,101,103));
    }
    static int addEven(int... ints){
        int result = 0;
        int sumEvenCounter = 0;
        for (int i: ints) {
            if(i % 2 ==0){
                result+=i;
                sumEvenCounter++;
            }
        }
        return (sumEvenCounter == 0)? -1:result;
    }
}
