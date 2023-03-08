package day2.실습;

public class SwitchLab2 {
    public static void main(String[] args) {
        int var = (int) (Math.random() * 5) + 1;
        int e1 = 300;
        int e2 = 50;
        int result = 0;
        switch(var){
            case 1:result = e1 + e2;break;
            case 2:result = e1 - e2;break;
            case 3:result = e1 * e2;break;
            case 4:result = e1 / e2;break;
            case 5:result = e1 % e2;break;
        }
        System.out.println("결과값 : " + result);
    }
}
