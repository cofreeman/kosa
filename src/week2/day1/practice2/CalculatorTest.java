package week2.day1.practice2;

import java.util.Objects;
import java.util.Scanner;

class CalculatorExpr{
    private int num1;
    private int num2;

    public CalculatorExpr(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }
    int getAddition(){
        return num1 + num2;
    }
    int getSubtraction(){
        return num1 - num2;
    }
    int getMultiplication(){
        return num1 * num2;
    }
    double getDivision(){
        return (float)num1 / num2;
    }
    void setNum1(int num1) {
        this.num1 = num1;
    }
    void setNum2(int num2) {
        this.num2 = num2;
    }
}
public class CalculatorTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print("숫자 두개를 입력하시오: ");
            int num1 = scanner.nextInt();
            int num2 = scanner.nextInt();
            CalculatorExpr calculatorExpr = new CalculatorExpr(num1,num2);
            System.out.printf("입력된 숫자: %d, %d\n",num1,num2);
            System.out.printf("덧셈: %d\n",calculatorExpr.getAddition());
            System.out.printf("뺼셈: %d\n",calculatorExpr.getSubtraction());
            System.out.printf("곱셈: %d\n",calculatorExpr.getMultiplication());
            System.out.printf("나눗셈: %f\n",calculatorExpr.getDivision());
            System.out.print("계속 진행하시겠습니까? : (네, 아니오)");
            String next = scanner.next();
            if (Objects.equals(next, "네")){
                continue;
            }else{
                break;
            }
        }

    }
}
