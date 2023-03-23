package week2.day1.practice;

public class Book{
    String title;
    String author;
    int price;

    public Book() {
        this.title = "이것이 자바다";
        this.author = "신용권";
        this.price = 36000;

    }

    public Book(String title, String author, int price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public String getBookInfo(){
        return "제목 : " + title + " 저자 : " + author + " 가격 : " + price;
    }

    public int getPrice() {
        return price;
    }
}
