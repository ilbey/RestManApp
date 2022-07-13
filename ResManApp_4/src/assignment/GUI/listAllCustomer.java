package assignment.GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class listAllCustomer extends JFrame{
    private JPanel listAllCustomerPanel;
    private JTable customerTable;

    public void setData(int id, String name, char gender, String dob) {

        DefaultTableModel model = (DefaultTableModel) customerTable.getModel();
        model.addRow(new Object[]{id, name, gender, dob});
    }

    public listAllCustomer(){
        setContentPane(listAllCustomerPanel);
        this.setContentPane(this.listAllCustomerPanel);
        this.setSize(400,200);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        Object[][] data = {
                {},
        };
        customerTable.setModel(new DefaultTableModel(data, new String[]{"ID","Name", "Gender", "Birth Date"}));

    }
}
