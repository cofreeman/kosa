package week3.day3;
import week2.day1.practice.Student;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Date;

public class SerialTest4 {
   public static void main(String[] args) throws Exception{
      FileInputStream fis =
    		  new FileInputStream("/Users/choijungwoo/kosa/src/week3/day3/w3d3file.txt");
      ObjectInputStream ois = new ObjectInputStream(fis);
      Date value1 = (Date)ois.readObject();
      Date value2 = (Date)ois.readObject();
      Student st = (Student)ois.readObject();
      System.out.println("Date객체 데이터 : " + value1);
      System.out.println("Date객체 데이터 : " + value2);
      System.out.println("Student객체 데이터 : ");
      st.printStudentInfo();
      ois.close();
      fis.close();
   }
}



