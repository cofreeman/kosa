package week3.day4.practice2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

public class SelectEmpLab {
    public static void main(String[] args) {
        Random random = new Random();
        String url = "jdbc:mysql://localhost:3306/edudb?characterEncoding=UTF-8&serverTimezone=UTC";
        String user = "root";
        String passwd = "1234";
        String sql = "SELECT ename, sal, DATE_FORMAT(hiredate, '%Y년 %m월 %d일')as hd FROM emp ORDER BY hiredate asc" ;
        try(Connection connection = DriverManager.getConnection(url,user,passwd);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)){
            if (random.nextBoolean()){
                while(resultSet.next()){
                    System.out.printf("%s 직원의 월급은 %,d달러입니다.\n",resultSet.getString("ename"),Integer.parseInt(resultSet.getString("sal")));
                }
                return;
            }
            while(resultSet.next()){
                System.out.printf("%s 직원은 %s에 입사하였습니다.\n",resultSet.getString("ename"),resultSet.getString("hd"));


            }

        }catch (Exception e){
            System.out.println("오류발생");
        }
    }
}
