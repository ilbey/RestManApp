package assignment.core;

import assignment.support.Order;
import java.util.Date;

/**
 * maintains orders information which is specifically inside of Restaurant.
 */
public class InRestrOrder extends Order {
    protected int tableNumber;
    protected boolean bookingOrder;

    /**
     * default constructor for InRestrOrder class
     */
    public InRestrOrder(){
        this.orderID = 0;
        this.orderDetails = "";
        this.extraNotes = "";
        this.tableNumber = 0;
        this.bookingOrder = true;
    }

    /**
     * constructor with variables for InRestrOrder class
     * @param orderID keeps InRestrOrder ID, takes from user.
     * @param orderDate keeps InRestrOrder date, takes from user.
     * @param orderDetails keeps InRestrOrder details, takes from user.
     * @param extraNotes keeps InRestrOrder extra notes, takes from user.
     * @param tableNumber keeps InRestrOrder table number, takes from user.
     * @param bookingOrder keeps InRestrOrder booking order, takes from user.
     */
    public InRestrOrder(int orderID, Date orderDate, String orderDetails, String extraNotes, int tableNumber, boolean bookingOrder){
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.orderDetails = orderDetails;
        this.extraNotes = extraNotes;
        this.tableNumber = tableNumber;
        this.bookingOrder = bookingOrder;
    }

    /**
     * getter for table number of order in Restaurant
     * @return tableNumber
     */
    public int getTableNumber() {
        return tableNumber;
    }

    /**
     * setter for table number of order in Restaurant
     * @param tableNumber is taking from user
     */
    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    /**
     * getter or checkers, this order has booking or not
     * @return bookingOrder
     */
    public boolean isBookingOrder() {
        return bookingOrder;
    }

    /**
     * setter for booking order
     * @param bookingOrder keeps order has booking or not
     */
    public void setBookingOrder(boolean bookingOrder) {
        this.bookingOrder = bookingOrder;
    }
}
