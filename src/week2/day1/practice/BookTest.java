package week2.day1.practice;
class Book{
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
        return title + " " + author + " " + price;
    }
}
public class BookTest {
    public static void main(String[] args) {
        Book book1 = new Book("책1","저자1",10000);
        Book book2 = new Book("책2","저자2",10000);
        Book book3 = new Book("책3","저자3",10000);
        Book book4 = new Book("책4","저자4",10000);
        Book book5 = new Book();
        Book[] books = {book1,book2,book3,book4,book5};
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getBookInfo());
        }
    }
}
