package view.course;




import model.Course;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CourseListPanel extends JPanel {
    JTable table;
    public CourseListPanel(){
        table = new JTable();

        JTable table = new JTable();
        table.setModel(Course.model);
        JScrollPane scroll = new JScrollPane(table);
        add(scroll);

        CoursePopupMenu coursePopupMenu = new CoursePopupMenu(table);

        table.setComponentPopupMenu(coursePopupMenu);

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(e.getButton() == 3) coursePopupMenu.show(table, e.getX(),e.getY());
            }
        });
    }
}