package week3.day3.iopractice;

import java.io.*;
import java.net.URL;

public class ImageIOLab {
    public static void main(String[] args) {
        // 파일 읽고
        try(FileReader fr = new FileReader("/Users/choijungwoo/kosa/src/week3/day3/list.txt");
            BufferedReader br = new BufferedReader(fr);) {
            String line = null;
            while (true){
                // 한 라인 읽고
                line = br.readLine();
                // 다읽으면 종료
                if (line == null) break;
                // 파일명 추출
                URL url = new URL(line.substring(line.indexOf(",") + 1));
                // URL 추출
                String fileName = "/Users/choijungwoo/kosa/src/week3/day3/myimage/" + line.substring(0,line.indexOf(","))+ ".jpg";
                // 파일 읽고
                try(InputStream is = url.openStream();
                    FileOutputStream fos = new FileOutputStream(fileName);){
                    int input = 0;
                    // 스트림 읽으면서 파일 저장
                    while (true) {
                        input = is.read();
                        if (input == -1)
                            break;
                        fos.write(input);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
