package org.example;

import java.sql.*;
import java.util.ArrayList;

public class CollegeDB {
    private static Connection getConnection() throws SQLException {
        String dbUrl = "jdbc:sqlite:college.db";
        Connection connection = DriverManager.getConnection(dbUrl);
        return connection;
    }

    public static ArrayList<Student> getStudents(){
        ArrayList<Student> students = new ArrayList<Student>();

        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet studentsQuery = statement.executeQuery(
                    "SELECT * FROM Student");

            while (studentsQuery.next()) {
                int id = studentsQuery.getInt("ID");
                String firstName = studentsQuery.getString("FirstName");
                String lastName = studentsQuery.getString("LastName");
                String major = studentsQuery.getString("Major");
                double gpa = studentsQuery.getDouble("GPA");

                students.add(new Student(id, firstName, lastName, major, gpa));
            }
            studentsQuery.close();

            connection.close();
        } catch ( SQLException e){
            System.out.println("SQLException: " + e.getMessage());
        }

        return students;
    }

    public static void addStudent(Student student){
        try {
            Connection connection = getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT into Student ( FirstName, LastName, Major, GPA ) values ( ?, ?, ?, ? )");

            // first value is index 1, it's ok to cry
            preparedStatement.setString(1, student.getFirstName());
            preparedStatement.setString(2, student.getLastName());
            preparedStatement.setString(3, student.getMajor());
            preparedStatement.setDouble(4, student.getGpa());

            preparedStatement.execute();

            connection.close();
        } catch ( SQLException e){
            System.out.println("SQLException: " + e.getMessage());
        }
    }
}
