package ResManApp;

import java.util.ArrayList;
import java.util.Date;

/**
 * maintains information about the customers' bookings.
 */
public class Booking {
    private Date bookingDate;
    private int bookingTable;
    private ArrayList<Order> orders;

    /**
     * default constructor for bookings
     */
    public Booking() {
        orders = new ArrayList<Order>();
    }

    /**
     * constructor for bookings
     * @param bookingTable is taking from user, is like booking table number.
     * @param bookingDate is taking from user, is in Date format, uses primary key for the bookings.
     */
    public Booking(int bookingTable, Date bookingDate) {
        this.bookingDate = bookingDate;
        this.bookingTable = bookingTable;
        orders = new ArrayList<Order>();
    }

    /**
     * getter for private order arrayList
     * @return orders
     */
    public ArrayList<Order> getOrders() {
        return orders;
    }

    /**
     * getter for booking date
     * @return bookingDate
     */
    public Date getBookingDate() {
        return bookingDate;
    }

    /**
     * setter for bookingDate
     * @param bookingDate is taking from user, is in Date format, uses primary key for the bookings.
     */
    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    /**
     * getter for bookingTable
     * @return bookingTable
     */
    public int getBookingTable() {
        return bookingTable;
    }

    /**
     * setter for bookingTable
     * @param bookingTable is taking from user, is like booking table number.
     */
    public void setBookingTable(int bookingTable) {
        this.bookingTable = bookingTable;
    }


    /**
     * This method for uses while making order means that adds new order to orders arrayList on booking class
     * @param details order details
     * @param description order description
     */
    public void makeOrder(String details, String description) {
        Order order = new Order(details, description);
        orders.add(order);
    }

    /**
     * This method is extra for the printing to the screen that are bookingDetails
     */
    public void bookingDetails() {
        System.out.print("\nBooking Table:" + bookingTable);
        System.out.printf("%s %td/%<tm/%<tY", "\nBooking Date:", bookingDate);
    }
}
