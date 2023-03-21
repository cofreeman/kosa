package week3.day2.collection;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;

public class ProductTest2 {
    public static void main(String[] args) {
        LinkedList<Product2> linkedList = new LinkedList<>();

        Product2 product1 = new Product2("p100", "TV", "20000");
        Product2 product2 = new Product2("p200", "Computer", "10000");
        Product2 product3 = new Product2("p100", "MP3", "700");
        Product2 product4 = new Product2("p300", "Audio", "1000");

        linkedList.add(product1);
        linkedList.add(product2);
        linkedList.add(product3);
        linkedList.add(product4);

        Collections.sort(linkedList);

        System.out.printf("%10s%10s%10s\n","제품 ID","제품명","가격");
        System.out.println("-".repeat(30));
        for (Product2 p : linkedList) {
            System.out.println(p.toString());
        }

    }
}
