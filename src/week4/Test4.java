package week4;

@FunctionalInterface
interface NewInterface{
    int method4(int a, int b);
}
public class Test4 {

    public static void method44(){
        System.out.println(3);
    }

    public static void main(String[] args) {
        NewInterface newInterface= Test4::sumsum;
        int i = newInterface.method4(1, 2);
    }

    private static int sumsum(int x,int y) {
        return x + y;
    }

}
