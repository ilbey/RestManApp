package assignment.GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class listAllStaffSalary extends JFrame{
    private JTable salaryTable;
    private JPanel listAllSalaryPanel;

    public void setData(int id, String name, int salary) {

        DefaultTableModel model = (DefaultTableModel) salaryTable.getModel();
        model.addRow(new Object[]{id, name, salary});
    }

    public listAllStaffSalary(){
        setContentPane(listAllSalaryPanel);
        this.setContentPane(this.listAllSalaryPanel);
        this.setSize(400,200);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        Object[][] data = {
                {},
        };
        salaryTable.setModel(new DefaultTableModel(data, new String[]{"ID", "Name", "Staff Salary"}));

    }
}
