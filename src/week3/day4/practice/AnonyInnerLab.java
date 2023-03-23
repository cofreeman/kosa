package week3.day4.practice;

import week2.day1.practice.Book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class AnonyInnerLab {
    public static void main(String[] args) {
        Book book1 = new Book("자바의 정석","남궁성",27000);
        Book book2 = new Book("챗GPT","반병현",11700);
        Book book3 = new Book("스타트 스프링 부트","남가람",27000);
        Book book4 = new Book("Doit!자바프로그래밍","박은중",22500);
        Book book5 = new Book("이것이 자바다","신용권,임경균",36000);

        ArrayList<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);

        printBookInfo(books);

        Collections.sort(books, new Comparator<>() {
            @Override
            public int compare(Book o1, Book o2) {
                return o1.getPrice() - o2.getPrice();
            }
        });
        System.out.println("[소팅 후]");
        printBookInfo(books);

    }

    private static void printBookInfo(ArrayList<Book> books) {
        for (Book book: books) {
            System.out.println(book.getBookInfo());
        }
    }
}
