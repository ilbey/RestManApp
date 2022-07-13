package assignment.GUI;

import assignment.core.InRestrOrder;
import assignment.core.OnlineOrder;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Date;

public class listAllOrder extends JFrame {

    private JTable orderTable;
    private JPanel listAllOrderPage;

    public void setData(int cstID, String cstName, String orderType, int orderID, Date orderDate, String orderDetails, String extraNotes, String paymentType, int deliveredBy) {
        DefaultTableModel model = (DefaultTableModel) orderTable.getModel();
        model.addRow(new Object[]{cstID, cstName, orderType, orderID, orderDate, orderDetails, extraNotes, paymentType, deliveredBy, null, null});
    }

    public void setData2(int cstID, String cstName, String orderType, int orderID, Date orderDate, String orderDetails, String extraNotes, String paymentType, int tableNumber, boolean bookingOrder) {

        DefaultTableModel model = (DefaultTableModel) orderTable.getModel();
        model.addRow(new Object[]{cstID, cstName, orderType, orderID, orderDate, orderDetails, extraNotes, paymentType, null, tableNumber, bookingOrder});
    }
    //customer.getID(), customer.getName(), check, order.getOrderID(), order.getOrderDate(), order.getOrderDetails(), order.getExtraNotes(), paymentType, ((OnlineOrder) order).stringDeliveredBy(), 0, false
    //customer.getID(), customer.getName(), check, order.getOrderID(), order.getOrderDate(), order.getOrderDetails(), order.getExtraNotes(), paymentType, ((OnlineOrder) order).stringDeliveredBy(), ((InRestrOrder) order).getTableNumber(), ((InRestrOrder) order).isBookingOrder()

    public listAllOrder(){
        this.setContentPane(this.listAllOrderPage);
        this.setSize(400,200);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.pack();

        orderTable.setModel(new DefaultTableModel(null, new String[]{"Customer ID", "Customer Name", "Order Type", "Order ID", "Order Date", "Order Details", "Extra Notes", "Payment Type", "Delivered By", "Table Number", "Booking Order"}));

    }
}
