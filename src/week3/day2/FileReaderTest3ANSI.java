package week3.day2;

import java.io.*;

public class FileReaderTest3ANSI {
	public static void main(String args[]) {
		try (FileInputStream fileInputStream = new FileInputStream("/Users/choijungwoo/kosa/src/week3/day2");
			 InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream,"EUC-KR")) {
			int data;
			System.out.println(inputStreamReader.getEncoding());
			while (true) {
				data = inputStreamReader.read();
				if (data == -1)
					break;
				System.out.print((char) data);
			}
		} catch (FileNotFoundException fnfe) {
			System.out.println("파일이 존재하지 않습니다.");
		} catch (IOException ioe) {
			System.out.println("파일을 읽을 수 없습니다.");
		}
	}
}
