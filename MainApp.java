package main;

import dao.StudentDAO;
import dao.MarksDAO;

public class MainApp {
    public static void main(String[] args) {

        StudentDAO studentDAO = new StudentDAO();
        MarksDAO marksDAO = new MarksDAO();

        studentDAO.addStudent("Jayesh", "Final Year");
        marksDAO.addMarks(1, 1, 85);
        marksDAO.addMarks(1, 2, 90);

        System.out.println("Grade Report:");
        marksDAO.generateGradeReport();
    }
}
