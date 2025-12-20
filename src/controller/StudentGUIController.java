package controller;

import model.Student;
import view.*;

import javax.swing.table.DefaultTableModel;
import javax.swing.*;

public class StudentGUIController {

    private StudentGUI view;

    public StudentGUIController(StudentGUI view) {
        this.view = view;
        init();
    }

    private void init() {
        view.getViewButton().addActionListener(e -> viewStudents());
        view.getAddButton().addActionListener(e -> addStudent());
        view.getDeleteButton().addActionListener(e -> deleteStudent());
    }

    private void viewStudents() {
        StringBuilder sb = new StringBuilder();
        for (Student s : Student.getAllStudents()) {
            sb.append(s).append("\n");
        }
        JOptionPane.showMessageDialog(view,
                sb.length() == 0 ? "No students." : sb.toString());
    }

    private void addStudent() {
        AddStudentDialog dialog = new AddStudentDialog(view);

        dialog.getSubmitButton().addActionListener(e -> {
            try {
                String name = dialog.getNameField().getText().trim();
                int age = Integer.parseInt(dialog.getAgeField().getText().trim());

                String[] parts = dialog.getGpaField().getText().split(",");
                double[] gpas = new double[parts.length];
                for (int i = 0; i < parts.length; i++) {
                    gpas[i] = Double.parseDouble(parts[i].trim());
                }

                new Student(name, age, gpas).storeStudent();
                JOptionPane.showMessageDialog(dialog, "Student added successfully!");
                dialog.dispose();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(dialog, "Invalid input.");
            }
        });

        dialog.setVisible(true);
    }

    private void deleteStudent() {
        DeleteStudentDialog dialog = new DeleteStudentDialog(view);

        dialog.getDeleteButton().addActionListener(e -> {
            DefaultTableModel model = dialog.getModel();

            for (int i = model.getRowCount() - 1; i >= 0; i--) {
                Boolean selected = (Boolean) model.getValueAt(i, 0);
                if (selected != null && selected) {
                    int id = (Integer) model.getValueAt(i, 1);
                    Student s = Student.getStudent(id);
                    if (s != null) {
                        Student.removeStudent(s);
                        model.removeRow(i);
                    }
                }
            }

            JOptionPane.showMessageDialog(dialog, "Selected students deleted.");
            dialog.dispose();
        });

        dialog.setVisible(true);
    }
}
