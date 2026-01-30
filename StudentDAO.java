package dao;

import db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class StudentDAO {

    public void addStudent(String name, String studentClass) {
        try {
            Connection con = DBConnection.getConnection();
            String query = "INSERT INTO student(name, class) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, studentClass);
            ps.executeUpdate();
            System.out.println("Student added successfully");
        } catch (Exception e) {
            System.out.println("Error adding student");
        }
    }
}
