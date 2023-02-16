package repository;

import model.Course;
import model.CourseEnrollment;
import model.Student;

import java.sql.*;


public class EnrollmentRepository {
    public static String url = "jdbc:postgresql://localhost:5432/postgres";
    private static String login = "postgres";
    private static String password = "1234" ;


    public static void getAll(){

        String query = "Select * from enrollments";
        try {
            Connection connection = DriverManager.getConnection(url, login, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()) {
                String id = resultSet.getString("id");
                int studentId = resultSet.getInt("studentid");
                int courseId = resultSet.getInt("courseid");
                if (Student.getStudentById(studentId) != null && Course.getCourseById(courseId) != null) {
                    new CourseEnrollment(Integer.parseInt(id), Student.getStudentById(studentId), Course.getCourseById(courseId));
                }
            }
            connection.close();
        }
        catch(Exception e){
            System.out.println("Не удалось подключиться к Базе Данных");
            System.out.println(e.getMessage());
        }
    }
    public static void insertEnrollments( int studentId, int courseId){
        String query = "insert into enrollments(studentid, courseid) values(?, ?)";
        try {
            Connection connection = DriverManager.getConnection(url, login, password);
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, studentId);
            statement.setInt(2, courseId);
            statement.executeUpdate();


            connection.close();
        }
        catch(Exception e){
            System.out.println("Не удалось подключиться к Базе Данных");
            System.out.println(e.getMessage());
        }


    }
}
