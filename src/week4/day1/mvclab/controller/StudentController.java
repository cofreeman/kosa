package week4.day1.mvclab.controller;

import week4.day1.mvclab.model.StudentDAO;
import week4.day1.mvclab.model.StudentDTO;

import java.sql.SQLException;
import java.util.List;

public class StudentController {
    StudentDAO studentDAO = new StudentDAO();

    public void printAll() throws SQLException {
        List<StudentDTO> allStudent = studentDAO.getAllStudent();
        allStudent.forEach(System.out::println);
    }

    public void printScore(String name) throws SQLException {
        int score = studentDAO.getScore(new StudentDTO(name));
        if (score < 0) System.out.printf("%s 학생은 존재하지 않습니다.\n",name);
        System.out.printf("%s 학생의 점수는 %d 입니다.\n",name,score);
    }

    public void insert(String name,int score) throws SQLException {
        boolean isStudentInserted = studentDAO.insertStudent(new StudentDTO(name, score));
        System.out.println(isStudentInserted?"입력 성공":"입력 실패");
    }

    public void update(String name,int score) throws SQLException {
        boolean isStudentUpdated = studentDAO.updateStudent(new StudentDTO(name, score));
        System.out.println(isStudentUpdated?String.format("%s 학생의 점수를 변경했습니다.",name):String.format("%s 학생은 존재하지 않습니다.",name));
    }
    public void delete(String name) throws SQLException {
        boolean isStudentDeleted = studentDAO.deleteStudent(new StudentDTO(name));
        System.out.println(isStudentDeleted?String.format("%s 학생의 데이터를 삭제했습니다.",name):String.format("%s 학생은 존재하지 않습니다.",name));
    }
}
