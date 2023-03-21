package week3.day2.io;

import java.io.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Date;
import java.util.Locale;

public class FileOutLab {
    public static void main(String[] args) {
        File dir = new File("/Users/choijungwoo/kosa/src/week3/day2/io");
        File file = null;

        LocalDate myld = LocalDate.of(2023, 5, 5);
        LocalDate myld2 = LocalDate.of(2023, 6, 6);
        DayOfWeek myday = myld.getDayOfWeek();
        DayOfWeek myday2 = myld2.getDayOfWeek();
        String mykorday1 = myday.getDisplayName(TextStyle.FULL, Locale.KOREAN);
        String mykorday2 = myday2.getDisplayName(TextStyle.FULL, Locale.KOREAN);

        if (dir.exists() && dir.isDirectory()) {
            file = new File(dir, "event.txt");
        }
        try (FileWriter writer = new FileWriter(file);
             PrintWriter out = new PrintWriter(writer);) {
            out.printf(" 2023년 5월 5일은 %s입니다.\r\n",mykorday1);
            out.printf(" 2023년 6월 6일은 %s입니다.\r\n",mykorday2);
            System.out.println("저장 완료되었습니다.");
        } catch (FileNotFoundException e) {
            System.out.println("event.txt 파일을 찾을 수 없습니다.");
        } catch (IOException ex){
            System.out.println("파일에 저장하는 동안 오류가 발생했습니다.");
        }
    }
}
