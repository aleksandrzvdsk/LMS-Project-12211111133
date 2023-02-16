package view.course;

import model.Course;
import model.Student;
import repository.EnrollmentRepository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ChoiceCourse extends JFrame  {
    CourseListPanel panel;
    public ChoiceCourse(Student student){
        setLocation(450,450);
        setSize(550,300);
        setTitle("Выбор курса");
        setLayout(new FlowLayout());
        panel = new CourseListPanel();
        add(panel);


        JButton button = new JButton("Зачислить на курс");
        add(button);


        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = panel.table.getSelectedRow();
                int courseID = Integer.parseInt((String) panel.table.getValueAt(index,0));
                student.addCourse(Course.getCourseById(courseID));



            }
        });
        setVisible(true);
    }
}
