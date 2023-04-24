package week3.day2.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class CountLab {
    public static void main(String[] args) {
        File f = new File("/Users/choijungwoo/kosa/src/week3/day2/yesterday.txt");
        String word = "yesterday";
        int result = 0;
        try (Scanner scan = new Scanner(f)) {
            while (scan.hasNext()) {
                String next = scan.next();
                if (next.toLowerCase().contains(word)) {
                    result++;
                }
            }
            ;
        } catch (FileNotFoundException e) {
            System.out.println("파일이 존재하지 않네요...ㅜ");
        } catch (IOException ioException) {
            System.out.println("입출력 오류발생");
        }

        System.out.printf("%s라는 단어는 %d 개 있습니다.", word, result);
    }
}
