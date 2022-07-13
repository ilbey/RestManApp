package assignment.support;
import java.util.Date;

/**
 * is the abstract class, and maintains information about the orders of customers' orders and their types.
 */
public abstract class Order implements Payment{
    protected int orderID;
    protected Date orderDate;
    protected String orderDetails;
    protected String extraNotes;

    /**
     * setter for order ID
     * @param orderID is specific order ID, takes from user.
     */
    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    /**
     * getter for order ID
     * @return orderID
     */
    public int getOrderID() {
        return orderID;
    }

    /**
     * setter for order date, takes from user.
     * @param orderDate ordering date
     */
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    /**
     * getter for order date
     * @return orderDate
     */
    public Date getOrderDate() {
        return orderDate;
    }

    /**
     * setter for order details, takes from user
     * @param orderDetails specific order details
     */
    public void setOrderDetails(String orderDetails) {
        this.orderDetails = orderDetails;
    }

    /**
     * getter for order details
     * @return orderDetails
     */
    public String getOrderDetails() {
        return orderDetails;
    }

    /**
     * setter for extra notes, takes from user
     * @param extraNotes specific order's extra notes
     */
    public void setExtraNotes(String extraNotes) {
        this.extraNotes = extraNotes;
    }

    /**
     * getter for extra notes for orders
     * @return extraNotes
     */
    public String getExtraNotes() {
        return extraNotes;
    }

    public void processPayment(){
        System.out.println("\nThis is Process Payment");
    }
    /*
    public abstract void setOrderID();
    public abstract int getOrderId();

    public abstract void setOrderDate();
    public abstract Date getOrderDate();

    public abstract void setOrderDetails();
    public abstract String extraNotes();

     */
}
