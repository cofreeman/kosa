package week3.day2.collection;

import java.util.Objects;

public class Product2 implements Comparable<Product2>{
    private String productID;
    private String productName;
    private String productPrice;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product2 product = (Product2) o;
        return Objects.equals(productID, product.productID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productID);
    }

    public Product2(String productID, String productName, String productPrice) {
        this.productID = productID;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    @Override
    public int compareTo(Product2 o) {
        return Integer.parseInt(o.productPrice) - Integer.parseInt(productPrice);
    }

    @Override
    public String toString() {
        return String.format("%10s%10s%,10d원",getProductID(),getProductName(),Integer.parseInt(getProductPrice()));
    }

    public String getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductPrice() {
        return productPrice;
    }
}
