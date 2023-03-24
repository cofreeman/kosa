package week3.day5.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import static week3.day5.practice.DBInfo.*;

public class InsertBookLab {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int storedBookCount = 0;
        while (true) {
            System.out.print("도서명을 입력하세요 : ");
            String bookName = scanner.nextLine();
            System.out.print("가격을 입력하세요 : ");
            Integer bookPrice = Integer.parseInt(scanner.nextLine());
            printBookKind();
            Integer bookKindNo = Integer.parseInt(scanner.nextLine());
            if (insertNewBook(bookName, bookPrice, bookKindNo)) {
                storedBookCount++;
            }
            System.out.print("계속 입력하시겠습니까?(y/n)");
            if (scanner.nextLine().equals("y")) continue;
            System.out.printf("%d 개의 데이터 입력 완료!", storedBookCount);
            break;
        }
    }
    private static void printBookKind() {
        System.out.println("도서분류에 대한 넘버를 입력하세요 : ");
        System.out.println("\t1. 프로그래밍 언어");
        System.out.println("\t2. 웹 프로그래밍");
        System.out.println("\t3. 빅데이터");
        System.out.println("\t4. 데이터베이스");
        System.out.println("\t5. 인프라");
        System.out.print("\t선택(1~5) : ");
    }
    private static boolean insertNewBook(String bookName, Integer bookPrice, Integer bookKindNo) {
        String sql = "insert into book(title,price,kind) values (?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(URL, USER, PW);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, bookName);
            preparedStatement.setInt(2, bookPrice);
            preparedStatement.setString(3, "b0" + bookKindNo);
            if (preparedStatement.executeUpdate() == 1) {
                System.out.println("정보가 입력되었습니다.");
            }
            return true;
        } catch (SQLException e) {
            System.out.println("오류발생");
        }
        return false;
    }
}
