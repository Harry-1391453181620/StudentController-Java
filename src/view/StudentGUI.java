package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class StudentGUI extends JFrame {

    private JButton viewButton = new JButton("View Students");
    private JButton addButton = new JButton("Add Student");
    private JButton deleteButton = new JButton("Delete Student");

    public StudentGUI() {
        setTitle("Student Management System");
        setSize(400, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(245, 247, 250));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(new EmptyBorder(40, 40, 40, 40));

        JLabel title = new JLabel("Student Management");
        title.setFont(new Font("Segoe UI", Font.BOLD, 22));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        mainPanel.add(title);
        mainPanel.add(Box.createVerticalStrut(40));

        styleButton(viewButton);
        styleButton(addButton);
        styleButton(deleteButton);

        mainPanel.add(viewButton);
        mainPanel.add(Box.createVerticalStrut(20));
        mainPanel.add(addButton);
        mainPanel.add(Box.createVerticalStrut(20));
        mainPanel.add(deleteButton);

        add(mainPanel);
        setVisible(true);
    }

    private void styleButton(JButton btn) {
        btn.setMaximumSize(new Dimension(250, 60));
        btn.setFocusPainted(false);
        btn.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    public JButton getViewButton() { return viewButton; }
    public JButton getAddButton() { return addButton; }
    public JButton getDeleteButton() { return deleteButton; }
}
