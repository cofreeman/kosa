package week3.day5.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static week3.day5.practice.DBInfo.*;

public class CreateBookLab {
    public static void main(String[] args) {
        String sql = "create table book (id int primary key auto_increment, title varchar(90), price int, kind char(3))";

        try (Connection connection = DriverManager.getConnection(URL, USER, PW);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
            System.out.println("book 테이블 생성 완료!");
        } catch (SQLException e) {
            System.out.println("오류발생");
        }
    }
}
