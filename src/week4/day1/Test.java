package week4.day1;

public class Test {
    public <T, F extends Student> int Box(T t, F f) {
        int i =0;
        T tType  = t;
        System.out.println(f.toString());
        return tType.toString().length();
    }
}
