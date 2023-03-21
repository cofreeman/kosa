package week3.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StandardInput3 {
    public static void main(String[] args) throws IOException {
        //한 문자만 읽는 스트림
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);

        //여러문자를 읽는 스트림
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String s = bufferedReader.readLine();
        System.out.println(s);
    }
}
