package week3.day4.practice2;

import java.sql.*;
import java.util.Objects;
import java.util.Scanner;

public class CheckEmpLab {

    private static final String url = "jdbc:mysql://localhost:3306/edudb?characterEncoding=UTF-8&serverTimezone=UTC";
    private static final String user = "root";
    private static final String passwd = "1234";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("근무중인지 확인하려는 직원 이름을 입력하세요: ");
            String ename = scanner.next();

            if (!checkEmployeeStatus(ename)){
                System.out.printf("%s 직원은 근무중이 아닙니다.");
            }

            System.out.println("계속 검토하시겠습니까? (예/아니오)");
            if (!Objects.equals(scanner.next(), "예")){
                break;
            }
        }
    }

    private static boolean checkEmployeeStatus(String ename) {
        String sql = "SELECT ename, DATE_FORMAT(hiredate, '%Y년 %m월')as hd, deptno FROM emp where ename = ?";


        try (Connection connection = DriverManager.getConnection(url, user, passwd);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            preparedStatement.setString(1,ename);
            try(ResultSet resultSet = preparedStatement.executeQuery();){

                if (resultSet.next()) return false;
                do{
                    System.out.printf("%s직원은 근무중입니다.\n", ename);
                    System.out.printf("%s에 입사했고 현재 %s 번 부서에서 근무하고 있습니다.\n", resultSet.getString("hd"), resultSet.getString("deptno"));
                } while(!resultSet.next());
            }
        } catch (SQLException e) {
            System.out.println("오류발생");
        }
        return true;
    }
}
