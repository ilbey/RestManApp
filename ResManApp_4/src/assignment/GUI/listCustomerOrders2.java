package assignment.GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Date;


public class listCustomerOrders2 extends JFrame {

    private JTable orderTable;
    private JPanel listCSTOrderPage;

    public void setData(int cstID, String cstName, String orderType, int orderID, Date orderDate, String orderDetails, String extraNotes, String paymentType, int deliveredBy) {

        DefaultTableModel model = (DefaultTableModel) orderTable.getModel();
        model.addRow(new Object[]{cstID, cstName, orderType, orderID, orderDate, orderDetails, extraNotes, paymentType, deliveredBy});
    }

    public void setData2(int id, String name, String check, int orderID, Date orderDate, String orderDetails, String extraNotes, String paymentType, int tableNumber, boolean bookingOrder) {
        DefaultTableModel model = (DefaultTableModel) orderTable.getModel();
        model.addRow(new Object[]{id, name, check, orderID, orderDate, orderDetails, extraNotes, paymentType, null, tableNumber, bookingOrder});
    }

    public listCustomerOrders2(){
        setContentPane(listCSTOrderPage);
        this.setContentPane(this.listCSTOrderPage);
        this.setSize(400,200);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();
        Object[][] data = {
                {},
        };
        orderTable.setModel(new DefaultTableModel(data, new String[]{"Customer ID", "Customer Name", "Order Type", "Order ID", "Order Date", "Order Details", "Extra Notes", "Payment Type", "Delivered By", "Table Number", "Booking Order"}));

    }


}

