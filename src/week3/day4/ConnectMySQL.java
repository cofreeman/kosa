package week3.day4;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectMySQL {
	public static void main(String[] args) {
		try {
			//jdbc 드라이버를 로딩하는 부분
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException cnfe) {
			System.out.println("해당 클래스를 찾을 수 없습니다." + cnfe.getMessage());
			return;
		}
		//jdbc URL
		String url = "jdbc:mysql://localhost:3306/edudb?characterEncoding=UTF-8&serverTimezone=UTC";
		String user = "root";
		String passwd = "1234";
		try (Connection conn = DriverManager.getConnection(url, user, passwd);){
			DatabaseMetaData md = conn.getMetaData();
			System.out.println("DBMS 서버 명 : "+md.getDatabaseProductName());
			System.out.println("DBMS 서버 버전 : "+md.getDatabaseProductVersion());
			System.out.println("사용자명 : "+md.getUserName()); 						
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}
	}
}
