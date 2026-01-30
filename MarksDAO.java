package dao;

import db.DBConnection;
import java.sql.*;

public class MarksDAO {

    public void addMarks(int studentId, int subjectId, int marks) {
        try {
            Connection con = DBConnection.getConnection();
            String query = "INSERT INTO marks(student_id, subject_id, marks) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, studentId);
            ps.setInt(2, subjectId);
            ps.setInt(3, marks);
            ps.executeUpdate();
            System.out.println("Marks added successfully");
        } catch (Exception e) {
            System.out.println("Error adding marks");
        }
    }

    public void generateGradeReport() {
        try {
            Connection con = DBConnection.getConnection();
            String query =
                "SELECT s.name, AVG(m.marks) avg_marks " +
                "FROM student s JOIN marks m ON s.student_id = m.student_id " +
                "GROUP BY s.student_id";

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                double avg = rs.getDouble("avg_marks");
                String grade;

                if (avg >= 85) grade = "A";
                else if (avg >= 70) grade = "B";
                else if (avg >= 55) grade = "C";
                else grade = "D";

                System.out.println(rs.getString("name") + " | Avg: " + avg + " | Grade: " + grade);
            }
        } catch (Exception e) {
            System.out.println("Error generating grade report");
        }
    }
}
