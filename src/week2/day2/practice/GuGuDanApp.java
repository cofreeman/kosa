package week2.day2.practice;

public class GuGuDanApp {
    public static void main(String[] args) {
        int dan = (int) (Math.random() * 20) + 1;
        int number = (int) (Math.random() * 20) + 1;

        if (dan >= 1 && dan <= 9 && number >= 1 && number <= 9){
            GuGuDanExpr guGuDanExpr = new GuGuDanExpr(dan, number);
            guGuDanExpr.printPart();
        }
        if (dan >=1 && dan <= 9 && number >= 10){
            GuGuDanExpr guGuDanExpr = new GuGuDanExpr(dan);
            guGuDanExpr.printPart();
        }
        if (dan >= 10){
            GuGuDanExpr guGuDanExpr = new GuGuDanExpr();
            guGuDanExpr.printAll();
        }
    }
}
