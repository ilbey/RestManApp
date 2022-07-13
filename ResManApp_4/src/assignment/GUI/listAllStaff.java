package assignment.GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class listAllStaff extends JFrame{
    private JPanel listAllStaffPanel;
    private JTable staffTable;

    public void setData(int id, char type, String name, char gender, String dob, String sd, int salary, String eed) {

        DefaultTableModel model = (DefaultTableModel) staffTable.getModel();
        model.addRow(new Object[]{id, type, name, gender, dob, salary, sd, eed});
    }

    public listAllStaff(){
        setContentPane(listAllStaffPanel);
        this.setContentPane(this.listAllStaffPanel);
        this.setSize(400,200);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();

        staffTable.setModel(new DefaultTableModel(null, new String[]{"ID","Type","Name", "Gender", "Birth Date","Staff Salary","Start Date","Expected End Date"}));

    }
}
