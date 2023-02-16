package view.student;

import model.Student;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StudentListPanel extends JPanel {
    JTable table;

    public StudentListPanel(){
        table = new JTable();

        JTable table = new JTable();
        table.setModel(Student.model);
        JScrollPane scroll = new JScrollPane(table);
        add(scroll);

        StudentPopupMenu studentPopupMenu = new StudentPopupMenu(table);

        table.setComponentPopupMenu(studentPopupMenu);

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int currentRow = table.rowAtPoint(e.getPoint());
                table.setRowSelectionInterval(currentRow,currentRow);
            }
        });
    }

}
