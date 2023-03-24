package week3.day5;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class SelectImage {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException cnfe) {
			System.out.println("해당 클래스를 찾을 수 없습니다." + cnfe.getMessage());
			return;
		}
		String url = "jdbc:mysql://localhost:3306/edudb?characterEncoding=UTF-8&serverTimezone=UTC";
		String user = "root";
		String passwd = "1234";
		try (Connection conn = DriverManager.getConnection(url, user, passwd);
				Scanner scan = new Scanner(System.in);
				PreparedStatement pstmt = conn.prepareStatement("SELECT filename, imgcontent FROM imgtest WHERE filename = ?");) {
			System.out.print("읽으려는 이미지의 파일명을 입력하세요 : ");
			String name = scan.nextLine();
			pstmt.setString(1, name);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				String imgName[] = rs.getString("filename").split("\\.");	
				File imgFile = new File("/Users/choijungwoo/kosa/src/week3/day5/"+imgName[0]+new Date().getTime()+"."+imgName[1]);
				InputStream is = rs.getBinaryStream("imgcontent");
				FileOutputStream fos = new FileOutputStream(imgFile);
				byte[] b = new byte[2048];
				int n;
				while ((n = is.read(b)) > 0) {
					fos.write(b, 0, n);
				}
				fos.close();
			} else {
				System.out.print(name + "이라는 파일명으로 저장된 이미지가 존재하지 않습니다. ");
			}
			System.out.println("이미지 읽기 성공");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
