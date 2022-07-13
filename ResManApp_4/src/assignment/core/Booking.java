package assignment.core;
import java.io.Serializable;
import java.util.Date;

/**
 * maintains information about the customers' bookings.
 */
public class Booking implements Serializable {
    Date bookingDate;
    int bookingID;

    /**
     * default constructor for bookings
     */
    public Booking(){
        this.bookingID = 0;
    }

    /**
     * constructor for bookings
     * @param bookingID is taking from user, is like specific ID for bookings, uses primary key for the bookings.
     * @param bookingDate is taking from user, is in Date format.
     */
    public Booking(int bookingID, Date bookingDate){
        this.bookingID = bookingID;
        this.bookingDate = bookingDate;
    }

    /**
     * getter for booking ID
     * @return bookingID
     */
    public int getBookingID() {
        return bookingID;
    }

    /**
     * setter for booking ID
     * @param bookingID is taking from user, is specific ID no for bookings.
     */
    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
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
     * @param bookingDate is taking from user, is in Date format.
     */
    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }
}
