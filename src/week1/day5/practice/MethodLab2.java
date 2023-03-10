package week1.day5.practice;

public class MethodLab2 {
    public static void main(String[] args) {
        printRightTriangle('@',3);
        printRightTriangle('%',4);
        printRightTriangle('A',5);
    }
    static void printRightTriangle(char c,int floor){
        for (int i = 0; i < floor; i++) {
            for (int j = i; j < floor - 1; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i + 1; j++) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
