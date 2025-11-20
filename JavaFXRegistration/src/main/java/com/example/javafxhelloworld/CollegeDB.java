package com.example.javafxhelloworld;

import java.sql.*;
import java.util.ArrayList;

public class CollegeDB {
    private static Connection getConnection() throws SQLException {
        String dbUrl = "jdbc:sqlite:college.db";
        Connection connection = DriverManager.getConnection(dbUrl);
        return connection;
    }

    public static void addEnrollmentInfo(Student student){
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "select enrollment.id as EnrollmentID, \n" +
                            "StudentID, \n" +
                            "SectionID,\n" +
                            "grade,\n" +
                            "CourseID,\n" +
                            "facultyid,\n" +
                            "semester,\n" +
                            "day,\n" +
                            "StartTime,\n" +
                            "EndTime,\n" +
                            "Modality,\n" +
                            "course.Department as courseDepartment,\n" +
                            "Number,\n" +
                            "Title,\n" +
                            "Credits,\n" +
                            "FirstName, \n" +
                            "LastName,\n" +
                            "Faculty.Department as FacultyDepartment\n" +
                            "\t\n" +
                            "from Enrollment\n" +
                            "join section on section.ID = Enrollment.SectionID\n" +
                            "join course on Section.CourseID = Course.ID\n" +
                            "join Faculty on section.FacultyID = Faculty.ID\n" +
                            "where StudentID = ?");

            preparedStatement.setInt(1, student.getID());

            ResultSet studentsQuery = preparedStatement.executeQuery();
            ArrayList<Enrollment> enrollments = new ArrayList<>();
            while (studentsQuery.next()) {
                int facultyID = studentsQuery.getInt("facultyid");
                String firstName = studentsQuery.getString("FirstName");
                String lastName = studentsQuery.getString("LastName");
                String facultyDepartment = studentsQuery.getString("facultydepartment");
                Faculty faculty = new Faculty(facultyID, firstName, lastName, facultyDepartment);



                int courseID = studentsQuery.getInt("courseID");
                String courseDepartment =  studentsQuery.getString("courseDepartment");
                int courseNumber = studentsQuery.getInt("number");
                String courseTitle = studentsQuery.getString("Title");
                int credits = studentsQuery.getInt("credits");

                Course course = new Course(courseID, courseDepartment, courseNumber, courseTitle, credits);

                int sectionID = studentsQuery.getInt("sectionid");
                String semester = studentsQuery.getString("semester");
                String day = studentsQuery.getString("day");
                String startTime = studentsQuery.getString("StartTime");
                String endTime = studentsQuery.getString("EndTime");
                String modality = studentsQuery.getString("Modality");

                Section section = new Section(sectionID, course, faculty, semester, day, startTime, endTime, modality);

                int enrollmentid =  studentsQuery.getInt("EnrollmentID");
                String grade = studentsQuery.getString("grade");

                Enrollment enrollment = new Enrollment(enrollmentid, student, section, grade);

                enrollments.add(enrollment);


            }
            studentsQuery.close();

            connection.close();

            student.setEnrollments(enrollments);

        } catch ( SQLException e){
            System.out.println("SQLException: " + e.getMessage());
        }
    }

    public static void updateStudent(Student student){
        try {
            Connection connection = getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(
                    "update student set FirstName = ?, LastName = ?, Major = ?, GPA = ? where ID = ?");

            // first value is index 1, it's ok to cry
            preparedStatement.setString(1, student.getFirstName());
            preparedStatement.setString(2, student.getLastName());
            preparedStatement.setString(3, student.getMajor());
            preparedStatement.setDouble(4, student.getGpa());
            preparedStatement.setInt(5, student.getID());

            preparedStatement.execute();

            connection.close();
        } catch ( SQLException e){
            System.out.println("SQLException: " + e.getMessage());
        }
    }

    public static ArrayList<Student> getStudent(int id){
        ArrayList<Student> students = new ArrayList<Student>();

        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM Student where id = ?");

            preparedStatement.setInt(1, id);

            ResultSet studentsQuery = preparedStatement.executeQuery();

            while (studentsQuery.next()) {
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
