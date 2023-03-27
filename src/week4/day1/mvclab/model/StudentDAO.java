package week4.day1.mvclab.model;

import week4.day1.MySQLConnect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    Connection conn = MySQLConnect.connect();


    public boolean insertStudent(StudentDTO dto) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("insert into student values(?,?)");
        ps.setString(1, dto.getName());
        ps.setInt(2, dto.getScore());
        return (ps.executeUpdate() == 1);

    }
    public List<StudentDTO> getAllStudent() throws SQLException {
        ArrayList<StudentDTO> dtos = new ArrayList<StudentDTO>();
        PreparedStatement ps = conn.prepareStatement("select name, score from student");
        ResultSet resultSet = ps.executeQuery(); 
        while(resultSet.next()){
            dtos.add(new StudentDTO(resultSet.getString("name"),resultSet.getInt("score")));
        }
        return dtos;
    }

    public int getScore(StudentDTO dto) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("select score from student where name = ?");
        ps.setString(1,dto.getName());
        ResultSet resultSet = ps.executeQuery();
        if (resultSet.next()) return resultSet.getInt("score");
        else return -1;
    }

    public boolean updateStudent(StudentDTO dto) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("update student set score = ? where name = ?");
        ps.setInt(1,dto.getScore());
        ps.setString(2,dto.getName());
        return ps.executeUpdate() == 1;
    }

    public boolean deleteStudent(StudentDTO dto) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("delete from student where name = ?");
        ps.setString(1,dto.getName());
        return ps.executeUpdate() == 1;
    }
}
