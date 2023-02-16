package view.course;
import model.Course;
import repository.CourseRepository;
import view.MainFrame;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class AddCoursePanel extends JPanel{
    public AddCoursePanel() {
        JTextField title = new JTextField(10);
        JTextField description = new JTextField(10);
        JButton addCourse = new JButton("Добавить");

        addCourse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!title.getText().concat(description.getText()).isEmpty()) {
                    new Course(title.getText(), description.getText());
                    CourseRepository.insert(title.getText(),description.getText());
                    title.setText("");
                    description.setText("");
                    MainFrame.addCourseFrame.setVisible(false);
                }
            }
        });
        add(title);
        add(description);
        add(addCourse);

        setVisible(true);
    }
}