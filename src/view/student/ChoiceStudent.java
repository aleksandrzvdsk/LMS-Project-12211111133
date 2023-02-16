package view.student;

import model.Course;
import model.Student;
import view.course.CourseListPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChoiceStudent extends JFrame {
    StudentListPanel panel;

    public ChoiceStudent(Course course){
        setLocation(450,450);
        setSize(550,300);
        setTitle("Выбор курса");
        setLayout(new FlowLayout());
        panel = new StudentListPanel();
        add(panel);


        JButton button = new JButton("Добавить студента");
        add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = panel.table.getSelectedRow();
                int studentId =
                        Integer.parseInt(panel.table.getValueAt(index, 0).toString());
                course.addStudent(Student.getStudentById(studentId));

            }
        });
setVisible(true);
    }
}
