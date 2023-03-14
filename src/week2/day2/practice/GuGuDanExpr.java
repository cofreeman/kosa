package week2.day2.practice;

public class GuGuDanExpr extends Multiplication{
    GuGuDanExpr(){

    }
    GuGuDanExpr(int dan){
        super(dan);
    }

    GuGuDanExpr(int dan, int number){
        super(dan,number);
    }

    public void printAll(){
        for (int dan = 1; dan < 10; dan++) {
            for (int number = 1; number < 10; number++) {
                System.out.printf("%d * %d = %d  ",dan,number,dan * number);
            }
            System.out.println();
        }
    }

}
