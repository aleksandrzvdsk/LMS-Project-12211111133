package view.student;

import model.Student;
import repository.StudentRepository;
import view.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddStudentPanel extends JPanel {
    public AddStudentPanel() {

        JTextField name = new JTextField(10);
        JTextField surname = new JTextField(10);

        JButton addStudentButton = new JButton("Добавить");

        addStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!name.getText().isEmpty() && !surname.getText().isEmpty()) {
                    new Student(name.getText(), surname.getText());
                    StudentRepository.insert(name.getText(),surname.getText());
                    name.setText("");
                    surname.setText("");
                    MainFrame.addStudentFrame.setVisible(false);

                }
            }
        });

        add(name);
        add(surname);
        add(addStudentButton);
        setVisible(true);
    }
}
