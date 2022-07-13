package assignment.core;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * It creates example objects, for testing.
 */
public class populateData {

    /**
     * creates 3 Senior Staff, 3 Junior Staff objects, 3 Customer, 3  Booking, 3 Online Order, 3 In Restaurant Order objects.
     * @throws ParseException uses for parsing dates
     */
    public static void fillDB() throws ParseException {
        SimpleDateFormat prs = new SimpleDateFormat("dd/MM/yyyy");


        //JUNIOR STAFFS
        int ssn = 128;
        String name = "elif";
        char gender = 'F';
        String dob = "10/10/2000";
        Date dateOfBirth = prs.parse(dob);
        String sd = "11/11/2018";
        Date startDate = prs.parse(sd);
        int monthlySalary = 12000;
        String eed = "11/11/2025";
        Date expectedEndDate = prs.parse(eed);

        Junior jnr1 = new Junior(ssn, name, gender, dateOfBirth, startDate, monthlySalary, expectedEndDate);
        ResManApp.staffs.add(jnr1);


        ssn = 129;
        name = "John";
        gender = 'M';
        dob = "02/12/2001";
        dateOfBirth = prs.parse(dob);
        sd = "13/04/2012";
        startDate = prs.parse(sd);
        monthlySalary = 10000;
        eed = "11/11/2021";
        expectedEndDate = prs.parse(eed);

        Junior jnr2 = new Junior(ssn, name, gender, dateOfBirth, startDate, monthlySalary, expectedEndDate);
        ResManApp.staffs.add(jnr2);


        ssn = 130;
        name = "Angelina";
        gender = 'F';
        dob = "29/09/2003";
        dateOfBirth = prs.parse(dob);
        sd = "23/12/2019";
        startDate = prs.parse(sd);
        monthlySalary = 9000;
        eed = "11/11/2023";
        expectedEndDate = prs.parse(eed);

        Junior jnr3 = new Junior(ssn, name, gender, dateOfBirth, startDate, monthlySalary, expectedEndDate);
        ResManApp.staffs.add(jnr3);


        //SENIOR STAFFS
        ssn = 125;
        name = "ilbey";
        gender = 'M';
        dob = "17/01/1996";
        dateOfBirth = prs.parse(dob);
        sd = "01/01/2014";
        startDate = prs.parse(sd);
        int grossSalaryYearly = 12000;

        Senior snr = new Senior(ssn, name, gender, dateOfBirth, startDate, grossSalaryYearly);
        ResManApp.staffs.add(snr);



        ssn = 126;
        name = "veli";
        gender = 'M';
        dob = "12/02/1997";
        dateOfBirth = prs.parse(dob);
        sd = "01/01/2010";
        startDate = prs.parse(sd);
        grossSalaryYearly = 18000;

        snr = new Senior(ssn, name, gender, dateOfBirth, startDate, grossSalaryYearly);
        ResManApp.staffs.add(snr);



        ssn = 127;
        name = "asli";
        gender = 'F';
        dob = "11/04/1998";
        dateOfBirth = prs.parse(dob);
        sd = "01/01/2015";
        startDate = prs.parse(sd);
        grossSalaryYearly = 15000;

        snr = new Senior(ssn, name, gender, dateOfBirth, startDate, grossSalaryYearly);
        ResManApp.staffs.add(snr);


        // CUSTOMERS
        ssn = 131;
        name = "zeynep";
        gender = 'F';
        dob = "09/11/1999";
        dateOfBirth = prs.parse(dob);
        String rd = "11/11/2018";
        Date registrationDate = prs.parse(rd);
        String creditCardDetails = "IBAN: 1236547896325";

        Customer cmr1 = new Customer(ssn, name, gender, dateOfBirth, registrationDate, creditCardDetails);
        ResManApp.customers.add(cmr1);


        ssn = 132;
        name = "sam";
        gender = 'M';
        dob = "09/07/2003";
        dateOfBirth = prs.parse(dob);
        rd = "01/12/2020";
        registrationDate = prs.parse(rd);
        creditCardDetails = "IBAN: 13165123543233";

        Customer cmr2 = new Customer(ssn, name, gender, dateOfBirth, registrationDate, creditCardDetails);
        ResManApp.customers.add(cmr2);


        ssn = 133;
        name = "Fredy";
        gender = 'M';
        dob = "06/06/1995";
        dateOfBirth = prs.parse(dob);
        rd = "01/10/2019";
        registrationDate = prs.parse(rd);
        creditCardDetails = "IBAN: 1635432120323";

        Customer cmr3 = new Customer(ssn, name, gender, dateOfBirth, registrationDate, creditCardDetails);
        ResManApp.customers.add(cmr3);


        //BOOKINGS
        int bookingTable = 1;
        String bd = "29/12/2020";
        Date bookingDate = prs.parse(bd);
        Booking booking1 = new Booking(bookingTable, bookingDate);
        cmr1.getBookings().add(booking1);


        bookingTable = 2;
        bd = "21/11/2021";
        bookingDate = prs.parse(bd);
        Booking booking2 = new Booking(bookingTable, bookingDate);
        cmr2.getBookings().add(booking2);


        bookingTable = 3;
        bd = "15/11/2022";
        bookingDate = prs.parse(bd);
        Booking booking3 = new Booking(bookingTable, bookingDate);
        cmr3.getBookings().add(booking3);



        //ONLINE ORDERS
        int orderID = 1;
        String od = "15/11/2020";
        Date orderDate = prs.parse(od);
        String orderDetails = "Pepperoni Pizza - 8.99 Euro";
        String extraNotes = "A personal 12 inch pepperoni pizza. Comes with peppers and olives.";
        char paymentType = 'C';
        OnlineOrder OOrder1 = new OnlineOrder(orderID, orderDate, orderDetails, extraNotes, paymentType, jnr1);
        cmr1.getOrders().add(OOrder1);


        orderID = 2;
        od = "01/12/2020";
        orderDate = prs.parse(od);
        orderDetails = "Spaghetti and Meatballs - 13.99 Euro";
        extraNotes = "Delicious homemade Spaghetti and Meatballs, serve with garlic bread on the side.";
        paymentType = 'B';
        OnlineOrder OOrder2 = new OnlineOrder(orderID, orderDate, orderDetails, extraNotes, paymentType, jnr2);
        cmr1.getOrders().add(OOrder2);


        orderID = 3;
        od = "02/09/2020";
        orderDate = prs.parse(od);
        orderDetails = "Four-cheese Pizza - 12.99 Euro";
        extraNotes = "This pizza made with 4 or 5 different cheeses.";
        paymentType = 'C';
        OnlineOrder OOrder3 = new OnlineOrder(orderID, orderDate, orderDetails, extraNotes, paymentType, jnr3);
        cmr2.getOrders().add(OOrder3);


        //IN RESTAURANT ORDERS
        orderID = 4;
        od = "22/11/2020";
        orderDate = prs.parse(od);
        orderDetails = "Double-cheese Pizza - 10.99 Euro";
        extraNotes = "This pizza made with just 2 different cheeses.";
        int tableNumber = 1;
        boolean bookingOrder = false;
        InRestrOrder ROrder1 = new InRestrOrder(orderID, orderDate, orderDetails, extraNotes, tableNumber, bookingOrder);
        cmr1.getOrders().add(ROrder1);


        orderID = 5;
        od = "19/10/2020";
        orderDate = prs.parse(od);
        orderDetails = "King Pizza - 20.99 Euro";
        extraNotes = "This pizza is specially made by professional cookers.";
        tableNumber = 1;
        bookingOrder = false;
        InRestrOrder ROrder2 = new InRestrOrder(orderID, orderDate, orderDetails, extraNotes, tableNumber, bookingOrder);
        cmr2.getOrders().add(ROrder2);


        orderID = 6;
        od = "20/09/2020";
        orderDate = prs.parse(od);
        orderDetails = "Full Sauce Pizza - 18.99 Euro";
        extraNotes = "This pizza made with 25 different special homemade sauces.";
        tableNumber = 1;
        bookingOrder = false;
        InRestrOrder ROrder3 = new InRestrOrder(orderID, orderDate, orderDetails, extraNotes, tableNumber, bookingOrder);
        cmr2.getOrders().add(ROrder3);

    }

}
