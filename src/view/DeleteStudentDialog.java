package view;

import model.Student;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class DeleteStudentDialog extends JDialog {

    private JTable table;
    private DefaultTableModel model;
    private JButton deleteButton = new JButton("Delete Selected");

    public DeleteStudentDialog(JFrame parent) {
        super(parent, "Delete Student", true);

        setSize(520, 420);
        setLayout(new BorderLayout());
        setLocationRelativeTo(parent);

        String[] columns = {"Select", "ID", "Name"};
        model = new DefaultTableModel(null, columns) {
            @Override
            public Class<?> getColumnClass(int col) {
                return col == 0 ? Boolean.class :
                        col == 1 ? Integer.class : String.class;
            }
            @Override
            public boolean isCellEditable(int row, int col) {
                return col == 0;
            }
        };

        for (Student s : Student.getAllStudents()) {
            model.addRow(new Object[]{false, s.getStudentID(), s.getName()});
        }

        table = new JTable(model);
        table.setRowHeight(28);
        table.getTableHeader().setReorderingAllowed(false);

        deleteButton.setBackground(new Color(220, 53, 69));
        deleteButton.setForeground(Color.WHITE);
        deleteButton.setFocusPainted(false);

        add(new JScrollPane(table), BorderLayout.CENTER);
        add(deleteButton, BorderLayout.SOUTH);
    }

    public DefaultTableModel getModel() { return model; }
    public JButton getDeleteButton() { return deleteButton; }
}
