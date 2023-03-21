package week3.day2;

import java.io.IOException;
import java.io.InputStreamReader;

public class StandardInput2 {
    public static void main(String[] args) throws IOException {
        //한 문자만 읽는 스트림
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);

        char munja = (char) inputStreamReader.read();
        System.out.println(munja);
    }
}
