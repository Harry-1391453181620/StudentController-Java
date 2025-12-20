package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class AddStudentDialog extends JDialog {

    private JTextField nameField = new JTextField(15);
    private JTextField ageField = new JTextField(15);
    private JTextField gpaField = new JTextField(15);
    private JButton submitButton = new JButton("Add Student");

    public AddStudentDialog(JFrame parent) {
        super(parent, "Add Student", true);

        setSize(420, 320);
        setLocationRelativeTo(parent);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(new EmptyBorder(20, 30, 20, 30));
        panel.setBackground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        addRow(panel, gbc, 0, "Name:", nameField);
        addRow(panel, gbc, 1, "Age:", ageField);
        addRow(panel, gbc, 2, "GPA (comma):", gpaField);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        submitButton.setFocusPainted(false);
        panel.add(submitButton, gbc);

        add(panel);
    }

    private void addRow(JPanel panel, GridBagConstraints gbc,
                        int row, String label, JTextField field) {
        gbc.gridx = 0;
        gbc.gridy = row;
        panel.add(new JLabel(label), gbc);
        gbc.gridx = 1;
        panel.add(field, gbc);
    }

    public JTextField getNameField() { return nameField; }
    public JTextField getAgeField() { return ageField; }
    public JTextField getGpaField() { return gpaField; }
    public JButton getSubmitButton() { return submitButton; }
}
