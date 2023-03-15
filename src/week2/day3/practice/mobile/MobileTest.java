package week2.day3.practice.mobile;

public class MobileTest {
    public static void main(String[] args) {
        Mobile lTab = new Ltab("Ltab", 500, "ABC-01");
        Mobile oTab = new Otab("Otab", 1000, "XYZ-01");

        printTitle();
        printMobile(lTab);
        printMobile(oTab);
        System.out.println();

        lTab.charge(10);
        oTab.charge(10);

        printTitle();
        printMobile(lTab);
        printMobile(oTab);
        System.out.println();

        lTab.operate(5);
        oTab.operate(5);

        printTitle();
        printMobile(lTab);
        printMobile(oTab);

    }

    public static void printMobile(Mobile mobile){
        System.out.println(mobile.getMobileName() + "    " + mobile.getBatterySize() + "     " + mobile.getOsType());
    }
    public static void printTitle(){
        System.out.println("Mobile  Battery  OS");
        System.out.println("------------------");
    }

}
