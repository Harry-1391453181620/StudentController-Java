import controller.StudentGUIController;
import view.StudentGUI;

import javax.swing.*;
import java.awt.*;


void main() {

    UIManager.put("Button.font", new Font("Segoe UI", Font.BOLD, 16));
    UIManager.put("Label.font", new Font("Segoe UI", Font.PLAIN, 14));
    UIManager.put("TextField.font", new Font("Segoe UI", Font.PLAIN, 14));
    UIManager.put("Table.font", new Font("Segoe UI", Font.PLAIN, 14));
    UIManager.put("TableHeader.font", new Font("Segoe UI", Font.BOLD, 14));

    StudentGUI gui = new StudentGUI();
    new StudentGUIController(gui);
}

