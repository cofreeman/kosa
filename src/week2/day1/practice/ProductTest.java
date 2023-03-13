package week2.day1.practice;

class Product{
    String name;
    int balance;
    int price;

    public Product() {
        this.name = "듀크인형";
        this.balance = 5;
        this.price = 10000;
    }

    public Product(String name, int balance, int price) {
        this.name = name;
        this.balance = balance;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public int getPrice() {
        return price;
    }
}
public class ProductTest {
    public static void main(String[] args) {
        Product[] products = new Product[5];
        Product p1 = new Product("상품1",3,3);
        Product p2 = new Product("상품1",3,3);
        Product p3 = new Product("상품1",3,3);
        Product p4 = new Product("상품1",3,3);
        Product p5 = new Product();
        products[0] = p1;
        products[1] = p2;
        products[2] = p3;
        products[3] = p4;
        products[4] = p5;
        for (Product p: products) {
            System.out.printf("%s %d %,d원\n",p.getName(),p.getBalance(),p.getPrice());
        }
    }
}
