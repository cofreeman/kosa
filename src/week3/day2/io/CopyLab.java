package week3.day2.io;

import java.io.*;
import java.time.LocalDate;
import java.util.Scanner;

public class CopyLab {
    public static void main(String[] args) {
        File f = new File("/Users/choijungwoo/kosa/src/week3/day2/sample.txt");
        LocalDate ld = LocalDate.now();
        int yearNum = ld.getYear();
        int monthNum = ld.getMonthValue();
        int dateNum = ld.getDayOfMonth();
        try (FileReader reader = new FileReader(f);
             BufferedReader br = new BufferedReader(reader);
             FileWriter writer = new FileWriter("sample_" + yearNum + "_" + monthNum + "_" + dateNum, true);
             PrintWriter out = new PrintWriter(writer);) {
            String data;
            while (true) {
                data = br.readLine();
                if (data == null)
                    break;
                out.printf(data + "\r\n");
            }
            System.out.println("저장 완료되었습니다.");
        } catch (FileNotFoundException e) {
            System.out.println("sample.txt 파일을 찾을 수 없습니다.");
        } catch (IOException ex){
            System.out.println("입출력을 처리하는 동안 오류가 발생했습니다.");
        }
    }
}
