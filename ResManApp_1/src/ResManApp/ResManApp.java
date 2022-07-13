package ResManApp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * maintains information about the customers, staff working at the restaurant, customers' bookings, and their orders.
 *
 * @author Ilbey Evcil 2079242
 * @version 1.0.0
 * @since 09/11/2020
 */
public class ResManApp {
    public static ArrayList<Staff> staffs;
    public static ArrayList<Customer> customers;

    /**
     * default constructor for ResManApp, it creates staff and customers arrayLists
     */
    public ResManApp() {
        staffs = new ArrayList<Staff>();
        customers = new ArrayList<Customer>();
    }

    /**
     * this method prints the menu ingredients
     */
    public static void menu() {
        System.out.println("Welcome to the ResManApp!\n1. Add Staff\n2. Delete Staff\n3. Get specific staff details");
        System.out.println("4. Add a Customer\n5. Delete a Customer\n6. Receive a Booking\n7. Receive Order");
        System.out.println("8. Get a specific Customer Details\n9. Get a Customer Booking\n10. Get Customer Orders");
        System.out.print("11. List All Staff\n12. List All Customer\n13. Exit!\nChoose the operation: ");
    }

    /**
     * this method taking new staff details, creating and adding them into the new staff.
     * @throws ParseException is for parsing dateOfBirth
     */
    public static void addStaff() throws ParseException {  //1
        SimpleDateFormat prs = new SimpleDateFormat("dd/MM/yyyy");
        int found = 1;
        char gender;
        int ssn = 0;
        Scanner input = new Scanner(System.in);
        
        while(found > 0){
            found = 0;
            System.out.print("Enter the new Staff SSN: ");
            ssn = input.nextInt();

            for (Staff staff : staffs) {
                if (staff.getSsn() == ssn)
                    found++;
            }
            if (found != 0)
                System.out.println("Please enter another SSN Number!");
        }
        
        
        System.out.print("Enter the his/her Name: ");
        String name = input.next();

        do{
            System.out.print("Enter the his/her Gender (M/F): ");
            gender = input.next().charAt(0);
        }while(gender != 'M' && gender != 'F' && gender != 'm' && gender != 'f');

        System.out.print("Enter his/her Date of birth (dd/mm/yyyy): ");
        String dob = input.next();
        Date dateOfBirth = prs.parse(dob);
        
        if(found == 0){
            Staff stf = new Staff(ssn, name, gender, dateOfBirth);
            staffs.add(stf);
        }
    }


    /**
     * this method is taking a staff SSN number deleting the specific Staff, which has this SSN, from the staffs list.
     * @param ssn is for checking temporary staff ssn
     */
    public static void deleteStaff(int ssn) {    //2
        int count = 0;
        int found = 0;

        for (Staff staff : staffs) {
            if (staff.getSsn() == ssn) {
                staffs.remove(count);
                found++;
            }
            count++;
        }
        if (found == 0)
            System.out.println("The Staff Object NOT found!");

    }

    /**
     * this method is taking a staff SSN number, it is getting staff details according to this SSN number
     * @param ssn is for checking temporary staff ssn
     */
    public static void getStaffDetails(int ssn) {    //3
        int found = 0;

        for (Staff staff : staffs) {
            if (staff.getSsn() == ssn) {
                staff.staffDetails();
                System.out.printf("%s %td/%<tm/%<tY", "Date of Birth:", staff.getDateOfBirth());
                found++;
            }
        }
        if (found == 0)
            System.out.println("The Staff Object NOT found!");
    }

    /**
     * this method taking new customer details, creating and adding them into the new customer.
     * @throws ParseException is for parsing dateOfBirth and registrationDate
     */
    public static void addCustomer() throws ParseException {   //4
        SimpleDateFormat prs = new SimpleDateFormat("dd/MM/yyyy");
        int found = 1;
        char gender;
        int ssn = 0;
        Scanner input = new Scanner(System.in);

        while(found > 0){
            found = 0;
            System.out.print("Enter the new customer SSN: ");
            ssn = input.nextInt();

            for (Customer customer : customers) {
                if (customer.getSsn() == ssn)
                    found++;
            }
            if (found != 0)
                System.out.println("Please enter another SSN Number!");
        }

        System.out.print("Enter the his/her Name: ");
        String name = input.next();

        do{
        System.out.print("Enter the his/her Gender (M/F): ");
        gender = input.next().charAt(0);
        }while(gender != 'M' && gender != 'F' && gender != 'm' && gender != 'f');

        System.out.print("Enter his/her Date of birth (dd/mm/yyyy): ");
        String dob = input.next();
        Date dateOfBirth = prs.parse(dob);

        System.out.print("Enter Registration Date (dd/mm/yyyy): ");
        String rd = input.next();
        Date registrationDate = prs.parse(rd);

        if(found == 0){
            Customer cst = new Customer(ssn, name, gender, dateOfBirth, registrationDate);
            customers.add(cst);
        }

    }

    /**
     * this method is taking a customer SSN number deleting the specific customer, which has this SSN, from the customers list.
     * @param ssn is for checking temporary customer ssn
     */
    public static void deleteCustomer(int ssn) { //5
        int count = 0;
        int found = 0;

        for (Customer customer : customers) {
            if (customer.getSsn() == ssn) {
                customers.remove(count);
                found++;
            }
            count++;
        }
        if (found == 0)
            System.out.println("The Customer Object NOT found!");
    }

    /**
     * this method takes customer SSN number, creating and adding them into the new booking according to customer SSN number.
     * @param ssn is for checking temporary customer ssn
     * @throws ParseException is for parsing the inside makeBooking() method
     */
    public static void receiveBooking(int ssn) throws ParseException {     //6
        int found = 0;
        for (Customer customer : customers) {
            if (customer.getSsn() == ssn) {
                customer.makeBooking();
                found++;
            }
        }
        if (found == 0)
            System.out.println("The Customer Object NOT found!");
    }

    /**
     * this method takes order details, creating and adding them into the new order according to customer SSN number, according to customer SSN number, and his/her specific booking date.
     * @param ssn is for checking temporary customer ssn
     * @param bookingDate is taking from user, is in Date format, uses temporary booking date of a customer for checking booking date.
     */
    public static void receiveOrder(int ssn, Date bookingDate) {     //7
        Scanner input = new Scanner(System.in);
        int found1 = 0;
        int found2 = 0;

        for (Customer customer : customers) {
            if (customer.getSsn() == ssn) {
                for (Booking booking : customer.getBookings()) {
                    if (bookingDate.compareTo(booking.getBookingDate()) == 0) {
                        System.out.print("Enter the an order details: ");
                        String details = input.next();

                        System.out.print("Enter the an order description: ");
                        String description = input.next();

                        booking.makeOrder(details, description);

                        found2++;
                    }
                }
                found1++;
            }
        }
        if (found1 == 0)
            System.out.println("The Customer Object NOT found!");
        if (found2 == 0)
            System.out.println("The Booking Object of this specific time NOT found!");
    }

    /**
     * According to customer SSN number, it prints all customer's details, bookings and their orders.
     * @param ssn is for checking temporary customer ssn
     */
    public static void getCustomerDetails(int ssn) {     //8
        int found = 0;

        for (Customer customer : customers) {
            if (customer.getSsn() == ssn) {
                customer.customerDetails();
                System.out.printf("%s %td/%<tm/%<tY", "Date of Birth:", customer.getDateOfBirth());
                System.out.printf("%s %td/%<tm/%<tY", "\nRegistration Date:", customer.getRegistrationDate());
                System.out.println(" ");
                found++;
                int count;

                for (Booking booking : customer.getBookings()) {
                    booking.bookingDetails();
                    count = 0;

                    for (Order order : booking.getOrders()) {
                        System.out.printf("\nOrder %d:\nDescription: ", count);
                        System.out.print(order.getDetails());
                        System.out.print("\tDetails: ");
                        System.out.println(order.getDescription());
                        count++;
                    }
                }
            }
        }
        if (found == 0)
            System.out.println("The Customer Object NOT found!");
    }


    /**
     * According to customer SSN number, it prints all customer's bookings and their orders.
     * @param ssn is for checking temporary customer ssn
     */
    public static void getCustomerBooking(int ssn) {     //9
        int count2 = 0;
        for (Customer customer : customers) {
            if (customer.getSsn() == ssn) {
                customers.get(count2).getBookingDetails();
            }
            count2++;
        }
    }

    /**
     * According to customer SSN number and this customer's booking's date, it prints all orders for this specific bookings.
     * @param ssn is for checking temporary customer ssn
     * @param bookingDate is taking from user, is in Date format, uses temporary booking date of a customer for checking booking date.
     */
    public static void getCustomerOrders(int ssn, Date bookingDate) {    //10
        int found1 = 0;
        int found2 = 0;
        int count = 0;

        for (Customer customer : customers) {
            if (customer.getSsn() == ssn) {
                for (Booking booking : customer.getBookings()) {
                    if (bookingDate.compareTo(booking.getBookingDate()) == 0) {
                        for (Order order : booking.getOrders()) {
                            System.out.printf("Order %d:\nDescription: ", count);
                            System.out.print(order.getDetails());
                            System.out.print("\tDetails: ");
                            System.out.println(order.getDescription());
                            found2++;
                            count++;
                        }
                    }
                }
                found1++;
            }
        }
        if (found1 == 0)
            System.out.println("The Customer Object NOT found!");
        if (found2 == 0)
            System.out.println("The Booking Object of this specific time NOT found!");

    }

    /**
     * This method prints all staffs which added to this system before.
     */
    public static void listStaff() { //11
        for (Staff staff : staffs) {
            staff.staffDetails();
            System.out.printf("%s %td/%<tm/%<tY", "Date of Birth:", staff.getDateOfBirth());
        }
    }

    /**
     * This method prints all customers which added to this system before.
     */
    public static void listCustomer() {  //12
        for (Customer customer : customers) {
            customer.customerDetails();
            System.out.printf("%s %td/%<tm/%<tY\n", "Date of Birth:", customer.getDateOfBirth());
            System.out.printf("%s %td/%<tm/%<tY", "Registration Date:", customer.getRegistrationDate());
        }
    }

    /**
     * This method is for exiting from the program
     */
    public static void exit() {  //13
        System.out.println("See You!");
        System.exit(0);
    }


    /**
     * executes the all other methods and has main definitions and redirects.
     * @param args uses for CLI commands
     * @throws ParseException for parsing dates
     */
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat prs = new SimpleDateFormat("dd/MM/yyyy");
        Scanner input = new Scanner(System.in);
        ResManApp res = new ResManApp();
        populateData.fillDB();

        menu();
        int choice = input.nextInt();
        while (true) {
            switch (choice) {
                case 1:
                    addStaff();
                    break;
                case 2:
                    System.out.print("Enter a Staff SSN Num: ");
                    int ssn = input.nextInt();
                    deleteStaff(ssn);
                    break;
                case 3:
                    System.out.print("Enter a Staff SSN Num: ");
                    ssn = input.nextInt();
                    getStaffDetails(ssn);
                    break;
                case 4:
                    addCustomer();
                    break;
                case 5:
                    System.out.print("Enter a Customer SSN Num: ");
                    ssn = input.nextInt();
                    deleteCustomer(ssn);
                    break;
                case 6:
                    System.out.print("Enter a Customer SSN Num: ");
                    ssn = input.nextInt();
                    receiveBooking(ssn);
                    break;
                case 7:     //*****
                    System.out.print("Enter a Customer SSN Num: ");
                    ssn = input.nextInt();

                    System.out.print("Enter Booking Date (dd/mm/yyyy): ");
                    String bd = input.next();
                    Date bookingDate = prs.parse(bd);

                    receiveOrder(ssn, bookingDate);
                    break;
                case 8:
                    System.out.print("Enter a Customer SSN Num: ");
                    ssn = input.nextInt();
                    getCustomerDetails(ssn);
                    break;
                case 9:
                    System.out.print("Enter a Customer SSN Num: ");
                    ssn = input.nextInt();
                    getCustomerBooking(ssn);
                    break;
                case 10:    //****
                    System.out.print("Enter a Customer SSN Num: ");
                    ssn = input.nextInt();

                    System.out.print("Enter Booking Date (dd/mm/yyyy): ");
                    bd = input.next();
                    bookingDate = prs.parse(bd);

                    getCustomerOrders(ssn, bookingDate);
                    break;
                case 11:
                    listStaff();
                    break;
                case 12:
                    listCustomer();
                    break;
                case 13:
                    exit();
                    break;
                default:
                    System.out.print("Please enter a value from the main menu!");
            }
            System.out.print("\nChoose the operation: ");
            choice = input.nextInt();
        }
    }
}

