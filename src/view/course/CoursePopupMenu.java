package view.course;



import model.Course;
import view.student.ChoiceStudent;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CoursePopupMenu extends JPopupMenu{
    static MenuItemListener menuItemListener = new MenuItemListener();
    public static JTable table;
    public CoursePopupMenu(JTable table) {
        this.table = table;
        add(createItem("Редактировать", "edit"));
        add(createItem("Сохранить", "save"));
        add(createItem("Добавить студента", "addStudent"));
        add(createItem("Удалить", "delete"));

    }
    JMenuItem createItem(String title, String command){
        JMenuItem item = new JMenuItem(title);
        item.setActionCommand(command);
        item.addActionListener(menuItemListener);
        return item;
    }
    public static class MenuItemListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            int index = table.getSelectedRow();
            int id = Integer.parseInt(table.getValueAt(index, 0).toString());
            String title = table.getValueAt(index,1).toString();
            String description = table.getValueAt(index,2).toString();

            switch(e.getActionCommand()) {
                case "save":
                    Course.update(id, index,title,description);
                    break;
                case "delete":
                    Course.delete(id,index);
                    break;
                case "addStudent":
                    new ChoiceStudent(Course.getCourseById(id));

            }

        }
    }

}