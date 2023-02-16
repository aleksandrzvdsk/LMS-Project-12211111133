package model;

import  repository.CourseRepository;


import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class Course {

    private int id;
    private String title;
    private String description;

    static ArrayList<Course> list = new ArrayList<>();
    private static int lastID = 0;
    static String headers[] = {"ID", "Title", "Description"};
    public static DefaultTableModel model = new DefaultTableModel(headers, 0);
    public static void update(int id, int index, String title, String description){
        list.get(index).title = title;
        list.get(index).description = description;
        CourseRepository.updateCourse(id, title, description);
    }
    public static void delete(int id, int index) {
        list.remove(index);
        model.removeRow(index);
        CourseRepository.deleteCourse(id);
    }
    public Course(String title, String description) {
        this.id = ++lastID;
        this.setProperties(title,description);
    }
    public Course(int id,String title, String description) {
        this.id = id;
        this.setProperties(title,description);

    }
    public void setProperties(String title, String description){
        this.title = title;
        this.description = description;
        list.add(this);
        addRow(this);
    }


    public static void addRow(Course course){
        model.addRow(
                new Object[] {
                        course.id,
                        course.title,
                        course.description
                });
    }

    public static Course getCourseById(int id) {
        for(Course course: list) {
            if (course.id == id)
                return course;
        }
        return null;
    }
    public CourseEnrollment addStudent(Student student){
        return new CourseEnrollment(id, student,this);

    }

    public String toString() {
        return this.id + " " + this.title + " " + this.description;
    }

    ArrayList<Student> getStudents() {
        return CourseEnrollment.getStudentsByCourse(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static ArrayList<Course> getList() {
        return list;
    }

    public static void setList(ArrayList<Course> list) {
        Course.list = list;
    }
}
