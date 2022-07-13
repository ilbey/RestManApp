package ResManApp;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * maintains information about the customers.
 */
public class Customer {
    private int ssn;
    private String name;
    private char gender;
    private Date dateOfBirth;
    private Date registrationDate;
    private ArrayList<Booking> bookings;

    /**
     * default constructor for customer
     */
    public Customer() {
        bookings = new ArrayList<Booking>();
    }

    /**
     * a constructor for customer with variables
     * @param ssn keeps customer ssn, takes from user, uses as primary key for customers list
     * @param name keeps customer name, takes from user
     * @param gender keeps customer gender, takes from user
     * @param dateOfBirth keeps customer birth date, takes from user
     * @param registrationDate keeps customer registration date, takes from user
     */
    public Customer(int ssn, String name, char gender, Date dateOfBirth, Date registrationDate) {
        this.ssn = ssn;
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.registrationDate = registrationDate;
        bookings = new ArrayList<Booking>();
    }

    /**
     * getter for private booking arrayList
     * @return bookings
     */
    public ArrayList<Booking> getBookings() {
        return bookings;
    }

    /**
     * getter for customer SSN
     * @return ssn
     */
    public int getSsn() {
        return ssn;
    }

    /**
     * setter for customer SSN
     * @param ssn keeps customer ssn, takes from user, uses as primary key for customers list
     */
    public void setSsn(int ssn) {
        this.ssn = ssn;
    }

    /**
     * getter for customer Name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * setter for customer Name
     * @param name keeps customer name, takes from user
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getter for customer gender
     * @return gender
     */
    public char getGender() {
        return gender;
    }

    /**
     * setter for customer gender
     * @param gender keeps customer gender, takes from user
     */
    public void setGender(char gender) {
        this.gender = gender;
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
     * getter for customer Birth Date
     * @return dateOfBirth
     */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * setter for customer Birth Date
     * @param dateOfBirth keeps customer birth date, takes from user
     */
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }


    /**
     * This method for uses while making booking means that adds new booking to booking arrayList on customer class
     * @throws ParseException is for parsing bookingDate
     */
    public void makeBooking() throws ParseException {
        Scanner input = new Scanner(System.in);
        SimpleDateFormat prs = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Enter Booking Date (dd/mm/yyyy): ");
        String bd = input.next();
        Date bookingDate = prs.parse(bd);

        System.out.print("Enter Booking Table: ");
        int bookingTable = input.nextInt();
        Booking bkng = new Booking(bookingTable, bookingDate);
        bookings.add(bkng);
    }

    /**
     * This method is extra for the getting bookingDetails of a specific customer and bookingDate
     */
    public void getBookingDetails() {
        int count = 0;
        int count1 = 0;
        for (Booking booking : bookings) {
            bookings.get(count).bookingDetails();

            if (bookings.get(count).getBookingDate().compareTo(booking.getBookingDate()) == 0) {
                count1 = 0;
                for (Order order : booking.getOrders()) {
                    System.out.printf("\nOrder %d:\nDescription: ", count1);
                    System.out.print(booking.getOrders().get(count1).getDetails());
                    System.out.print("\tDetails: ");
                    System.out.println(booking.getOrders().get(count1).getDescription());
                    count1++;
                }
            }
            count++;
        }
    }

    /**
     * This method is extra for the printing to the screen that are customerDetails
     */
    public void customerDetails() {
        System.out.println("\n\nSSN: " + ssn);
        System.out.println("Name: " + name);
        System.out.println("Gender: " + gender);
    }
}
