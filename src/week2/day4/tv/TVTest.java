package week2.day4.tv;

public class TVTest {
    public static void main(String[] args) {
        SaleTV saleTV = new SaleTV(300000, "SALETV-1", 40, 1);
        RentalTV rentalTV = new RentalTV(100000, "RENTALTV-10", 42, 1);

        saleTV.channelUp();
        saleTV.channelUp();

        rentalTV.channelDown();
        rentalTV.channelDown();
        rentalTV.channelDown();

        printAllTV(saleTV);
        printAllTV(rentalTV);

        printRentalTV(rentalTV);

    }
    static void printAllTV(TV tv){
        System.out.print(tv);
        // 얘는 타입이 TV 인데 어떻게 자식의 toString() 메서드를 자동으로 참조하죠?

        if (tv instanceof  RentalTV){
            ((RentalTV) tv).play();
        }else if(tv instanceof SaleTV){
            ((SaleTV) tv).play();
            ((SaleTV) tv).sale();
        }
    }

    static void printRentalTV(Rentable tv){
        tv.rent();
    }
}
