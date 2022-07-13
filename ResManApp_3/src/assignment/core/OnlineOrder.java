package assignment.core;

import assignment.support.Order;

import java.io.Serializable;
import java.util.Date;

/**
 * maintains orders information which is specifically online.
 */
public class OnlineOrder extends Order implements Serializable {
    protected char paymentType;
    protected int deliveredBy;

    /**
     * default constructor for OnlineOrder class
     */
    public OnlineOrder(){
        this.orderID = 0;
        this.orderDetails = "";
        this.extraNotes = "";
        this.paymentType = 'B';     //Bank Card (B), Cash Money (C)
    }

    /**
     * constructor with variables for OnlineOrder class
     * @param orderID keeps OnlineOrder ID, takes from user.
     * @param orderDate keeps OnlineOrder date, takes from user.
     * @param orderDetails keeps OnlineOrder details, takes from user.
     * @param extraNotes keeps OnlineOrder extra notes, takes from user.
     * @param paymentType keeps OnlineOrder payment type, takes from user.
     * @param deliveredBy keeps OnlineOrder deliveredBy as junior staff, takes from user.
     */
    public OnlineOrder(int orderID, Date orderDate, String orderDetails, String extraNotes, char paymentType, int deliveredBy){
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.orderDetails = orderDetails;
        this.extraNotes = extraNotes;
        this.paymentType = paymentType;
        this.deliveredBy = deliveredBy;
    }

    /**
     * getter for Online Order payment type
     * @return paymentType
     */
    public char getPaymentType() {
        return paymentType;
    }

    /**
     * setter for Online Order payment type
     * @param paymentType keeps char types
     */
    public void setPaymentType(char paymentType) {
        this.paymentType = paymentType;
    }

    /**
     * gets which junior is responsible from this order as a string format.
     * @return
     */
    public int DeliveredBy() {
        return deliveredBy;
    }

    /**
     * sets which junior is responsible from this order.
     * @param deliveredBy keeps juniors
     */
    public void setDeliveredBy(int deliveredBy) {
        this.deliveredBy = deliveredBy;
    }

}
