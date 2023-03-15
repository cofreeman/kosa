package week2.day3;

public class PolyTest {
    public static void main(String[] args) {
        printObjectInfo(new Object());
        printObjectInfo("가나다");
        printObjectInfo("ABC");
        printObjectInfo(new java.util.Date());
        printObjectInfo(new java.io.File("/Users/choijungwoo/kosa/src/week2/day3/AbstractTest1.java"));
        printObjectInfo(new int[10]);
        printObjectInfo(new double[5]);
        printObjectInfo(100);
    }

    static void printObjectInfo(Object o) {
        if (o instanceof String){
            System.out.println("문자열 객체가 전달됨: " + o);
            return;
        }
        System.out.printf("전달된 객체의 클래스명: %s\n",o.getClass().getName());
    }
}
abstract class GrandParent{
    abstract void abstractMethod();
}

abstract class Parent extends GrandParent{

}

class Child extends Parent{
    void abstractMethod(){

    }
}

