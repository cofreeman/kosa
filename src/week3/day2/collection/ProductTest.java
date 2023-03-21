package week3.day2.collection;

import java.util.HashSet;

public class ProductTest {
    private static final String SUCCESS = "성공적으로 저장되었습니다.";
    private static final String FAIL = "동일한 ID 의 제품이 이미 저장되어 있습니다.";
    public static void main(String[] args) {
        HashSet<Product> productHashSet = new HashSet<>();

        Product product1 = new Product("p100", "TV", "20000");
        Product product2 = new Product("p200", "Computer", "10000");
        Product product3 = new Product("p100", "MP3", "700");
        Product product4 = new Product("p300", "Audio", "1000");

        System.out.println(productHashSet.add(product1)?SUCCESS:FAIL);
        System.out.println(productHashSet.add(product2)?SUCCESS:FAIL);
        System.out.println(productHashSet.add(product3)?SUCCESS:FAIL);
        System.out.println(productHashSet.add(product4)?SUCCESS:FAIL);

        System.out.printf("%10s%10s%10s\n","제품 ID","제품명","가격");
        System.out.println("-".repeat(30));
        for (Product p : productHashSet) {
            System.out.printf("%10s%10s%10s\n",p.getProductID(),p.getProductName(),p.getProductPrice());
        }

    }
}
