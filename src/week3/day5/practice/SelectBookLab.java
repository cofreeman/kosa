package week3.day5.practice;

import java.sql.*;
import java.util.Scanner;

import static week3.day5.practice.DBInfo.*;

public class SelectBookLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            printMenu();
            selectMenu(scanner.nextInt());
            System.out.print("\n계속 입력하시겠습니까?(y/n)");
            if (scanner.next().equals("y")) continue;
            break;
        }
    }

    private static void printMenu() {
        System.out.println("1. 모두 출력하기");
        System.out.println("2. 가격이 높은 순으로 출력하기");
        System.out.println("3. 20000 이상의 도서들만 출력하");
        System.out.println("4. 웹 프로그래밍 도서들만 출력하기");
        System.out.println("5. 데이터베이스와 인프라 도서들만 출력하");
        System.out.println("6. 도서명에 '자바'를 포함하는 도서들만 출력하");
        System.out.println("7. 분류별 도서 가격의 평균을 출력하기");
        System.out.print("\n원하는 메뉴의 번호를 선택: ");
    }

    private static void selectMenu(int menuNo) {
        String sql = "";
        if (menuNo == 1) sql = "select id,title,price,kind from book";
        else if (menuNo == 2) sql = "select id,title,price,kind from book order by price desc";
        else if (menuNo == 3) sql = "select title,price from book where price >= 20000";
        else if (menuNo == 4) sql = "select title,price from book where kind = 'b02'";
        else if (menuNo == 5) sql = "select title,price from book where kind = 'b04' or 'b05'";
        else if (menuNo == 6) sql = "select title,price from book where title like '%자바%'";
        else if (menuNo == 7) sql = "select round(avg(price)) as avgprice, kind from book GROUP BY kind";
        else throw new IllegalArgumentException();

        try (Connection connection = DriverManager.getConnection(URL, USER, PW);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            String id;
            String title;
            String price;
            String bookKind;
            String avgPrice;
            if (menuNo == 1 || menuNo == 2) {
                System.out.printf("%4s%30s%10s%10s\n", "아이디", "제목", "가격", "종류");
                while (resultSet.next()) {
                    id = resultSet.getString("id");
                    title = resultSet.getString("title");
                    price = resultSet.getString("price");
                    bookKind = resultSet.getString("kind");
                    System.out.printf("%4s%30s%,10d원%10s\n", id, title, Integer.parseInt(price), bookKind);
                }
            } else if (menuNo == 3 || menuNo == 4 || menuNo == 5 || menuNo == 6) {
                System.out.printf("%30s%10s\n", "제목", "가격");
                while (resultSet.next()) {
                    title = resultSet.getString("title");
                    price = resultSet.getString("price");
                    System.out.printf("%30s%,10d원\n", title, Integer.parseInt(price));
                }
            } else if (menuNo == 7) {
                while (resultSet.next()) {
                    avgPrice = resultSet.getString("avgprice");
                    String kind = resultSet.getString("kind");
                    System.out.printf("%s 도서들의 가격 평균은 %d원입니다.\n", BookKindNo.valueOf(kind).returnName(), Integer.parseInt(avgPrice));
                }
            }
        } catch (SQLException e) {
            System.out.println("오류발생");
        }
    }
}
