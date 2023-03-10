package week1.day5.practice2;

public class MethodLab9 {
    public static void main(String[] args) {
        System.out.println(isRightTriangle(3,4,5));
        System.out.println(isRightTriangle(1,2,3));
    }
    static boolean isRightTriangle(int width, int height, int hypo){
        return (width * width + height * height) == (hypo * hypo);
    }
}
