package week3.day3;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import week2.day1.practice.Student;

public class SerialTest3 {
   public static void main(String[] args) throws Exception{
      FileOutputStream fos =
    		  new FileOutputStream("/Users/choijungwoo/kosa/src/week3/day3/w3d3file.txt");
      ObjectOutputStream oos =
    		  new ObjectOutputStream(fos);
      oos.writeObject(new Date());
      Thread.sleep(3000);
      oos.writeObject(new Date());
      Student st = new Student("duke", 27, "Java프로그래밍");
      oos.writeObject(st);
      oos.close();
      fos.close();
      System.out.println("직렬화 출력 완료");
   }
}



