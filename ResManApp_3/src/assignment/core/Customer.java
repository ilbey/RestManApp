package assignment.core;

import assignment.support.Order;
import assignment.support.Person;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * maintains information about the customers.
 */
public class Customer extends Person implements Serializable {
    protected Date registrationDate;
    protected ArrayList<Order> orders;
    protected ArrayList<Booking> bookings;
    protected String creditCardDetails;

    /**
     * default constructor for customer
     */
    public Customer(){
        this.ID = 0;
        this.name = "";
        this.gender = 'M';
        this.creditCardDetails = "";
        bookings = new ArrayList<Booking>();
        orders = new ArrayList<Order>();
    }

    /**
     * a constructor for customer with variables
     * @param ID keeps customer ssn, takes from user, uses as primary key for customers list
     * @param name keeps customer name, takes from user
     * @param gender keeps customer gender, takes from user
     * @param dateOfBirth keeps customer birth date, takes from user
     * @param registrationDate keeps customer registration date, takes from user
     * @param creditCardDetails keeps credit card details, takes from user
     */
    public Customer(int ID, String name, char gender, Date dateOfBirth, Date registrationDate, String creditCardDetails){
        this.ID = ID;
        this.name = name;
        this.gender = gender;
        this.dateOfBirth =dateOfBirth;
        this.registrationDate = registrationDate;
        this.creditCardDetails = creditCardDetails;
        bookings = new ArrayList<Booking>();
        orders = new ArrayList<Order>();


        /*
        super.setID(ID);
        super.setName(name);
        super.setGender(gender);
        super.setDateOfBirth(dateOfBirth);
        this.registrationDate = registrationDate;
        this.creditCardDetails = creditCardDetails;
        */
    }

    /**
     * getter for customer Registration Date
     * @return registrationDate
     */
    public Date getRegistrationDate() {
        return registrationDate;
    }

    /**
     * setter for customer Registration Date
     * @param registrationDate keeps customer registration date, takes from user
     */
    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    /**
     * getter for customer credit card details
     * @return creditCardDetails
     */
    public String getCreditCardDetails() {
        return creditCardDetails;
    }

    /**
     * setter for customer credit card details
     * @param creditCardDetails is taking from user, while registrating
     */
    public void setCreditCardDetails(String creditCardDetails) {
        this.creditCardDetails = creditCardDetails;
    }

    /**
     * getter for private customer's orders ArrayList
     * @return orders
     */
    public ArrayList<Order> getOrders() {
        return orders;
    }

    /**
     * setter for private customer's orders ArrayList
     * @param orders is object which is taking from user.
     */
    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    /**
     * getter for private customer's bookings ArrayList
     * @return bookings
     */
    public ArrayList<Booking> getBookings() {
        return bookings;
    }


    /**
     * setter for private customer's bookings ArrayList
     * @param bookings is object which is taking from user.
     */
    public void setBookings(ArrayList<Booking> bookings) {
        this.bookings = bookings;
    }

    /**
     * This method for uses while adding new orders to orders arrayList on customer class.
     * @param order is object which is adding to orders ArrayList.
     */
    public void addOrder(Order order){
        this.orders.add(order);
    }

    /**
     * This method for uses while making booking means that adds new booking to bookings arrayList on customer class.
     * @param booking is object which is adding to bookings ArrayList.
     */
    public void addBooking(Booking booking){
        this.bookings.add(booking);
    }


    /*
    public void getOrder(){
        int count = 0;
        System.out.printf("\nOrder %d:\nOrder ID: ", this.orders.get(count).getOrderID());
        System.out.printf("%s %td/%<tm/%<tY", "\nOrder Date:",this.orders.get(count).getOrderDate());
        System.out.printf("Order Details: ",this.orders.get(count).getOrderDetails());
        System.out.printf("Extra Notes: ",this.orders.get(count).getExtraNotes());
    }*/

}

/*
public void getBooking(){
        int count = 0;
        System.out.printf("\nBooking %d:\nBooking ID: ", this.bookings.get(count).getBookingID());
        System.out.printf("%s %td/%<tm/%<tY", "\nBooking Date:",this.bookings.get(count).getBookingDate());
    }





@Override
    public int getID() {
        return super.getID();
    }

    @Override
    public void setID(int ID) {
        super.setID(ID);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public char getGender() {
        return super.getGender();
    }

    @Override
    public void setGender(char gender) {
        super.setGender(gender);
    }

    @Override
    public Date getDateOfBirth() {
        return super.getDateOfBirth();
    }

    @Override
    public void setDateOfBirth(Date dateOfBirth) {
        super.setDateOfBirth(dateOfBirth);
    }
 */