package ResManApp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * It creates example objects, for testing.
 */
public class populateData {

    /**
     * creates 3 Staff objects, 3 Customer objects, with each Customer having one Booking and for each Booking one Order object.
     * @throws ParseException uses for parsing dates
     */
    public static void fillDB() throws ParseException {
        SimpleDateFormat prs = new SimpleDateFormat("dd/MM/yyyy");
        int ssn = 125;
        String name = "ilbey";
        char gender = 'M';
        String dob = "17/01/1996";
        Date dateOfBirth = prs.parse(dob);

        Staff stf = new Staff(ssn, name, gender, dateOfBirth);
        ResManApp.staffs.add(stf);

        ssn = 126;
        name = "veli";
        gender = 'M';
        dob = "12/02/1997";
        dateOfBirth = prs.parse(dob);

        stf = new Staff(ssn, name, gender, dateOfBirth);
        ResManApp.staffs.add(stf);

        ssn = 127;
        name = "asli";
        gender = 'F';
        dob = "11/04/1998";
        dateOfBirth = prs.parse(dob);

        stf = new Staff(ssn, name, gender, dateOfBirth);
        ResManApp.staffs.add(stf);


        ssn = 128;
        name = "elif";
        gender = 'F';

        dob = "10/10/2000";
        dateOfBirth = prs.parse(dob);

        String rd = "11/11/2011";
        Date registrationDate = prs.parse(rd);

        Customer cst1 = new Customer(ssn, name, gender, dateOfBirth, registrationDate);
        ResManApp.customers.add(cst1);


        ssn = 129;
        name = "John";
        gender = 'M';

        dob = "02/12/2001";
        dateOfBirth = prs.parse(dob);

        rd = "13/04/2012";
        registrationDate = prs.parse(rd);

        Customer cst2 = new Customer(ssn, name, gender, dateOfBirth, registrationDate);
        ResManApp.customers.add(cst2);


        ssn = 130;
        name = "Angelina";
        gender = 'F';

        dob = "29/09/2003";
        dateOfBirth = prs.parse(dob);

        rd = "23/12/2019";
        registrationDate = prs.parse(rd);

        Customer cst3 = new Customer(ssn, name, gender, dateOfBirth, registrationDate);
        ResManApp.customers.add(cst3);


        int bookingTable = 1;
        String bd = "29/12/2020";
        Date bookingDate = prs.parse(bd);

        Booking booking1 = new Booking(bookingTable, bookingDate);
        cst1.getBookings().add(booking1);

        bookingTable = 1;
        bd = "21/11/2021";
        bookingDate = prs.parse(bd);


        Booking booking2 = new Booking(bookingTable, bookingDate);
        cst2.getBookings().add(booking2);

        bookingTable = 1;
        bd = "15/11/2022";
        bookingDate = prs.parse(bd);

        Booking booking3 = new Booking(bookingTable, bookingDate);
        cst3.getBookings().add(booking3);

        String details = "Pepperoni Pizza - 8.99 Euro";
        String description = "A personal 12 inch pepperoni pizza. Comes with peppers and olives.";
        Order order1 = new Order(details, description);
        booking1.getOrders().add(order1);

        details = "Spaghetti and Meatballs - 13.99 Euro";
        description = "Delicious homemade Spaghetti and Meatballs, serve with garlic bread on the side.";
        Order order2 = new Order(details, description);
        booking2.getOrders().add(order2);

        details = "Four-cheese Pizza - 12.99 Euro";
        description = "This pizza made with 4 or 5 different cheeses.";
        Order order3 = new Order(details, description);
        booking3.getOrders().add(order3);


    }

}
