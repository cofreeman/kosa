package week3.day4.practice2;

import java.sql.*;
import java.util.Objects;
import java.util.Scanner;

public class CheckEmpLab {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/edudb?characterEncoding=UTF-8&serverTimezone=UTC";
        String user = "root";
        String passwd = "1234";
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("근무중인지 확인하려는 직원 이름을 입력하세요: ");
            String ename = scanner.next();
            String sql = "SELECT ename, DATE_FORMAT(hiredate, '%Y년 %m월')as hd, deptno FROM emp where ename = " + String.format("'" + ename + "'");
            try(Connection connection = DriverManager.getConnection(url,user,passwd);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql)){
                if (!resultSet.next()){
                    System.out.printf("%s직원은 근무하지 않습니다.\n",ename);
                    System.out.println("계속 검토하시겠습니까? (예/아니오)");
                    if (Objects.equals(scanner.next(), "예")){
                        continue;
                    }
                    break;
                }
                do {
                    System.out.printf("%s직원은 근무중입니다.\n",ename);
                    System.out.printf("%s에 입사했고 현재 %s 번 부서에서 근무하고 있습니다.\n",resultSet.getString("hd"),resultSet.getString("deptno"));
                } while(resultSet.next());
                System.out.println("계속 검토하시겠습니까? (예/아니오)");
                if (Objects.equals(scanner.next(), "예")){
                    continue;
                }
                break;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
