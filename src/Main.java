import controller.StudentGUIController;
import model.Student;
import view.StudentGUI;

import javax.swing.*;
import java.awt.*;


void main() {

    UIManager.put("Button.font", new Font("Segoe UI", Font.BOLD, 16));
    UIManager.put("Label.font", new Font("Segoe UI", Font.PLAIN, 14));
    UIManager.put("TextField.font", new Font("Segoe UI", Font.PLAIN, 14));
    UIManager.put("Table.font", new Font("Segoe UI", Font.PLAIN, 14));
    UIManager.put("TableHeader.font", new Font("Segoe UI", Font.BOLD, 14));

    new Student("Alice", 20, new double[]{3.5}).storeStudent();
    new Student("Bob", 22, new double[]{3.0}).storeStudent();
    new Student("Charlie", 21, new double[]{3.8}).storeStudent();

    StudentGUI gui = new StudentGUI();
    new StudentGUIController(gui);
}

