package view.student;



import model.Course;
import model.Student;
import repository.EnrollmentRepository;
import view.course.ChoiceCourse;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentPopupMenu extends JPopupMenu {
   static MenuItemListener menuItemListener= new MenuItemListener();
   public static JTable table;
    public StudentPopupMenu(JTable table) {
        this.table = table;
        add(createItem("Сохранить", "save"));
        add(createItem("Копировать", "copy"));
        add(createItem("Зачислить на курс", "enroll"));
        add(createItem("Удалить", "delete"));
    }
    JMenuItem createItem(String title, String command){
        JMenuItem item = new JMenuItem(title);
        item.setActionCommand(command);
        item.addActionListener(menuItemListener);
        return item;
    }

    public static class MenuItemListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int index = table.getSelectedRow();

            int id = Integer.parseInt(table.getValueAt(index, 0).toString());
            String name = table.getValueAt(index,1).toString();
            String surname = table.getValueAt(index,2).toString();


            switch(e.getActionCommand()) {
                case "save":
                    Student.update(id,index,name,surname);
                    break;
                case "delete":
                    Student.delete(id,index);
                    break;
                case "enroll":
                    new ChoiceCourse(Student.getStudentById(id));


            }


        }
    }
}