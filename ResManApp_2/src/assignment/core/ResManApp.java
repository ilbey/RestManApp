package assignment.core;

import assignment.support.Order;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * maintains information about the customers, staff working at the restaurant, customers' bookings, and their orders.
 *
 * @author Ilbey Evcil 2079242
 * @version 2.0.0
 * @since 25/11/2020
 */
public class ResManApp {
    public static ArrayList<Staff> staffs;
    public static ArrayList<Customer> customers;

    /**
     * default constructor for ResManApp, it creates staff and customers arrayLists
     */
    public ResManApp(){
        staffs = new ArrayList<Staff>();
        customers = new ArrayList<Customer>();
    }

    /**
     * this method prints the menu ingredients
     */
    public static void menu(){
        System.out.println("Welcome to the ResManApp!\n1. Add Staff\n2. Delete Staff\n3. List staff details");
        System.out.println("4. Add a Customer\n5. Delete a Customer\n6. Add a Booking\n7. Add an Order");
        System.out.println("8. List Customer Details\n9. Display Customer Last Booking\n10. List Customer Orders");
        System.out.print("11. List All Staff\n12. List All Customer\n13. List All Staff Salaries\n14. List Orders\n15. Add Order of Booking\n16. Exit!\nChoose the operation: ");
    }

    /**
     * this method taking new staff details, creating and adding them into the new staff with Senior or Junior class types.
     * @throws ParseException is for parsing dateOfBirth
     */
    public static void addStaff() throws ParseException {  //1
        SimpleDateFormat prs = new SimpleDateFormat("dd/MM/yyyy");
        int found = 1;
        char gender;
        int ssn = 0;
        char staffType;
        Scanner input = new Scanner(System.in);
        //try {
            do {
                System.out.print("Enter Staff Type(Senior(S) or Junior(J)): ");
                staffType = input.next().charAt(0);
            } while (staffType != 'S' && staffType != 's' && staffType != 'J' && staffType != 'j');

            while (found > 0) {
                found = 0;
                System.out.print("Enter the new Staff SSN: ");
                ssn = input.nextInt();

                for (Staff staff : staffs) {
                    if (staff.getID() == ssn)
                        found++;
                }
                if (found != 0)
                    System.out.println("Please enter another SSN Number!");
            }


            System.out.print("Enter the his/her Name: ");
            String name = input.next();

            do {
                System.out.print("Enter the his/her Gender (M/F): ");
                gender = input.next().charAt(0);
            } while (gender != 'M' && gender != 'F' && gender != 'm' && gender != 'f');

            System.out.print("Enter his/her Date of birth (dd/mm/yyyy): ");
            String dob = input.next();
            Date dateOfBirth = prs.parse(dob);

            System.out.print("Enter his/her Start Date (dd/mm/yyyy): ");
            String sd = input.next();
            Date startDate = prs.parse(sd);


            if (staffType == 'S' || staffType == 's') {
                if (found == 0) {
                    System.out.print("Enter the new Senior Salary Yearly: ");
                    int grossSalaryYearly = input.nextInt();

                    Senior snr = new Senior(ssn, name, gender, dateOfBirth, startDate, grossSalaryYearly);
                    staffs.add(snr);
                }
            }

            if (staffType == 'J' || staffType == 'j') {
                if (found == 0) {
                    System.out.print("Enter the new Junior Salary Yearly: ");
                    int monthlySalary = input.nextInt();

                    System.out.print("Enter his/her Junior Expected End Date (dd/mm/yyyy): ");
                    String eed = input.next();
                    Date expectedEndDate = prs.parse(eed);

                    System.out.print("Enter Senior ID who is responsible from him/her: ");
                    int seniorID = input.nextInt();

                    for(Staff staff : staffs){
                        if(staff instanceof Senior){
                            if(staff.getID() == seniorID){
                                Junior jnr = new Junior(ssn, name, gender, dateOfBirth, startDate, monthlySalary, expectedEndDate);
                                ((Senior) staff).addResponsibleFrom(jnr);
                                found++;
                            }
                        }
                    }
                    if(found > 0){
                        Junior jnr = new Junior(ssn, name, gender, dateOfBirth, startDate, monthlySalary, expectedEndDate);
                        staffs.add(jnr);
                    }
                }
            }
        /*} catch (IllegalArgumentException e) {
            System.out.print("Ooops, there is a type error for your inputs!\n");
            addStaff();
        }*/

    }

    /**
     * this method is taking a staff SSN number deleting the specific Staff, which has this SSN, from the staffs list.
     */
    public static void deleteStaff() {    //2
        Scanner input = new Scanner(System.in);
        int count = 0;
        System.out.print("Enter a Staff SSN Num: ");
        int ssn = input.nextInt();
        try {
            for (Staff staff : staffs) {
                if (staff.getID() == ssn) {
                    staffs.remove(count);
                }
                count++;
            }
        }catch (Exception e){
            System.out.println("The Staff Object NOT found!");
            deleteStaff();
        }
    }

    /**
     * this method is taking a staff SSN number, it is getting staff details according to this SSN number
     */
    public static void listStaffDetails() {    //3
        Scanner input = new Scanner(System.in);
        String check;
        System.out.print("Enter a Staff SSN Num: ");
        int ssn = input.nextInt();
        try {
            for (Staff staff : staffs) {
                if (staff.getID() == ssn) {
                    if(staff instanceof Senior)
                        check = "Senior";
                    else
                        check = "Junior";

                    System.out.println("Staff Type: "+ check);
                    System.out.printf("%s Staff ID: %d\n", check, staff.getID());
                    System.out.printf("%s Staff Name: %s\n", check, staff.getName());
                    System.out.printf("%s Staff Gender: %c\n", check, staff.getGender());
                    System.out.printf("%s %td/%<tm/%<tY", "Date of Birth:", staff.getDateOfBirth());

                    if(check.equals("Senior")){
                        System.out.printf("%s %td/%<tm/%<tY", "\nStart Date: ", staff.getStartDate());
                        System.out.println("\nGross Salary Yearly: "+ staff.getSalary());
                    }
                    else{
                        System.out.printf("%s %td/%<tm/%<tY", "\nExpected End Date: ", ((Junior) staff).getExpectedEndDate());
                        System.out.println("\nGross Salary Yearly: "+ staff.getSalary());
                    }
                    System.out.println("");
                }
            }
        }catch (Exception e){
            System.out.println("The Staff Object NOT found!");
            listStaffDetails();
        }
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
                if (customer.getID() == ssn)
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

        System.out.print("Enter the his/her Credit Card Details: ");
        String creditCardDetails = input.next();

        if(found == 0){
            Customer cst = new Customer(ssn, name, gender, dateOfBirth, registrationDate, creditCardDetails);
            customers.add(cst);
        }

    }

    /**
     * this method is taking a customer SSN number deleting the specific customer, which has this SSN, from the customers list.
     */
    public static void deleteCustomer() {    //5
        Scanner input = new Scanner(System.in);
        int count = 0;
        System.out.print("Enter a Customer SSN Num: ");
        int ssn = input.nextInt();

        try {
            for (Customer customer : customers) {
                if (customer.getID() == ssn) {
                    customers.remove(count);
                }
                count++;
            }
        }catch(Exception e){
            System.out.println("The Customer Object NOT found!");
            deleteCustomer();
        }
    }


    /**
     * this method takes customer SSN number, creating and adding them into the new booking according to customer SSN number.
     * @throws ParseException is for parsing the bookingDate
     */
    public static void addBooking() throws ParseException {     //6
        Scanner input = new Scanner(System.in);
        SimpleDateFormat prs = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Enter a Customer SSN Num: ");
        int ssn = input.nextInt();

        try {
            for (Customer customer : customers) {
                if (customer.getID() == ssn) {

                    System.out.print("Enter the an Booking ID: ");
                    int bookingId = input.nextInt();

                    System.out.print("Enter Booking Date (dd/mm/yyyy): ");
                    String bd = input.next();
                    Date bookingDate = prs.parse(bd);

                    Booking book = new Booking(bookingId, bookingDate);
                    customer.addBooking(book);
                }
            }
        }catch(Exception e){
            System.out.println("The Customer Object NOT found!");
            addBooking();
        }
    }


    /**
     * this method takes order details, creating and adding them into the new order according to customer SSN number and order type such as Online and In Restaurant.
     * @throws ParseException is parsing the orderDate
     */
    public static void addOrder() throws ParseException {     //7
        Scanner input = new Scanner(System.in);
        Junior jnr = null;
        SimpleDateFormat prs = new SimpleDateFormat("dd/MM/yyyy");
        System.out.print("Enter a Customer SSN Num: ");
        int ssn = input.nextInt();
        try {
            int found = 0;
            for (Customer customer : customers) {
                if (customer.getID() == ssn) {

                    System.out.print("Enter the Order Type('O' for Online Orders or 'R' for Restaurant Orders: ");
                    char typee = input.next().charAt(0);
                    if (typee == 'O' || typee == 'o' || typee == 'R' || typee == 'r') {
                        System.out.print("Enter the an Order ID: ");
                        int orderId = input.nextInt();

                        System.out.print("Enter Order Date (dd/mm/yyyy): ");
                        String od = input.next();
                        Date orderDate = prs.parse(od);

                        System.out.print("Enter Order Details: ");
                        String orderDetails = input.next();

                        System.out.print("Enter Order Extra Notes: ");
                        String extraNotes = input.next();

                        if (typee == 'O' || typee == 'o') {

                            System.out.print("Enter the Online Order Payment Type: ");
                            char paymentType = input.next().charAt(0);

                            System.out.print("Enter the Junior SSN: ");
                            int jSSN = input.nextInt();

                            for(Staff staff : staffs){
                                if(staff instanceof Junior){
                                    if(staff.getID() == jSSN){
                                        jnr = new Junior(staff.getID(), staff.getName(), staff.getGender(), staff.getDateOfBirth(), staff.getStartDate(), staff.getSalary(), ((Junior) staff).getExpectedEndDate());
                                        found++;
                                    }
                                }
                            }
                            if(found > 0){
                                Order online = new OnlineOrder(orderId, orderDate, orderDetails, extraNotes, paymentType, jnr);
                                customer.addOrder(online);
                            }
                        }

                        if (typee == 'R' || typee == 'r') {

                            System.out.print("Enter the Restaurant Table Number: ");
                            int tableNumber = input.nextInt();

                            Order restaurant = new InRestrOrder(orderId, orderDate, orderDetails, extraNotes, tableNumber, false);
                            customer.addOrder(restaurant);
                        }
                    }
                }
            }
        }catch(Exception e){
            System.out.println("You did NOT valid an entry!");
            addOrder();
        }
    }

    /**
     * According to customer SSN number, it prints all customer's details, bookings and his/her orders.
     */
    public static void listCustomerDetails() {     //8
        Scanner input = new Scanner(System.in);
        String check = "";
        System.out.print("Enter a Customer SSN Num: ");
        int ssn = input.nextInt();
        try {
            for (Customer customer : customers) {
                if (customer.getID() == ssn) {
                    System.out.println("Customer ID: "+ customer.getID());
                    System.out.println("Customer Name: "+ customer.getName());
                    System.out.println("Customer Gender: "+ customer.getGender());
                    System.out.printf("%s %td/%<tm/%<tY", "\nDate of Birth:", customer.getDateOfBirth());
                    System.out.printf("%s %td/%<tm/%<tY", "\nRegistration Date:", customer.getRegistrationDate());
                    System.out.println("\nCustomer Credit Card Details: "+ customer.getCreditCardDetails());
                    System.out.println(" ");

                    try {
                        for (Booking booking : customer.bookings) {
                            System.out.println("This customer's booking ID: " + booking.getBookingID());
                            System.out.printf("%s %td/%<tm/%<tY", "This customer's booking Date:", booking.getBookingDate());
                        }
                    }catch(Exception e){
                        System.out.println("Customer do NOT have booking yet.");
                    }

                    try {
                        int count = 0;
                        for (Order order : customer.orders) {
                            if (order instanceof OnlineOrder)
                                check = "Online";
                            else
                                check = "In Restaurant";
                            System.out.printf("\nOrder %d:", count);
                            System.out.printf("\n%s Order ID: %d", check, order.getOrderID());
                            System.out.printf("%s %td/%<tm/%<tY", "\nOrder Date: ", order.getOrderDate());
                            System.out.printf("\n%s Order Details: %s", check, order.getOrderDetails());
                            System.out.printf("\n%s Order Extra Notes: %s\n", check, order.getExtraNotes());
                            if (check.equals("Online")) {
                                if (((OnlineOrder) order).getPaymentType() == 'B' || ((OnlineOrder) order).getPaymentType() == 'b')
                                    System.out.printf("%s Payment Type: Bank Card\n", check);
                                else
                                    System.out.printf("%s Payment Type: Cash\n", check);
                                System.out.println("Delivered By: ");
                                ((OnlineOrder) order).stringDeliveredBy();
                            } else {
                                System.out.printf("%s Table Number: %d\n", check, ((InRestrOrder) order).getTableNumber());
                                System.out.printf("%s Booking Order: %b\n", check, ((InRestrOrder) order).isBookingOrder());
                            }
                            count++;
                        }
                    }catch(Exception e){
                        System.out.println("Customer does NOT have an order yet");
                    }
                }
            }
        }catch (Exception e){
            System.out.println("The Customer Object NOT found!");
            listCustomerDetails();
        }
    }

    /**
     * This method displays specific customer's last time booking according to checking customer ID.
     */
    public static void displayCustomerLastBooking() {     //9
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a Customer SSN Num: ");
        int ssn = input.nextInt();
        try {
            for (Customer customer : customers) {
                if (customer.getID() == ssn) {
                    System.out.println("This customer's last booking ID: " + customer.bookings.get(customer.bookings.size()-1).getBookingID());
                    System.out.printf("%s %td/%<tm/%<tY", "This customer's last booking Date:", customer.bookings.get(customer.bookings.size()-1).getBookingDate());
                }
            }
        }catch(Exception e){
            System.out.println("The Customer Object NOT found!");
            displayCustomerLastBooking();
        }
    }

    /**
     * According to customer SSN number, it prints all types of order details such as Online and In Restaurant.
     */
    public static void listCustomerOrders() {         //10
        Scanner input = new Scanner(System.in);
        int found1 = 0;
        int count = 0;
        int ssn = 0;
        String check;
        try {
        System.out.print("Enter a Customer SSN Num: ");
        ssn = input.nextInt();
        }catch(Exception e){
            System.out.print("Wrong input type! Please enter an Integer. \n");
            listCustomerOrders();
        }
        try {
            for (Customer customer : customers) {
                if (customer.getID() == ssn) {
                    try {
                        for (Order order : customer.getOrders()) {
                            if (order instanceof OnlineOrder)
                                check = "Online";
                            else
                                check = "In Restaurant";
                            System.out.printf("\nOrder %d:", count);
                            System.out.printf("\n%s Order ID: %d", check, order.getOrderID());
                            System.out.printf("%s %td/%<tm/%<tY", "\nOrder Date: ", order.getOrderDate());
                            System.out.printf("\n%s Order Details: %s", check, order.getOrderDetails());
                            System.out.printf("\n%s Order Extra Notes: %s\n", check, order.getExtraNotes());
                            if (check.equals("Online")) {
                                if (((OnlineOrder) order).getPaymentType() == 'B' || ((OnlineOrder) order).getPaymentType() == 'b')
                                    System.out.printf("%s Payment Type: Bank Card\n", check);
                                else
                                    System.out.printf("%s Payment Type: Cash\n", check);
                                System.out.println("Delivered By: ");
                                ((OnlineOrder) order).stringDeliveredBy();
                            } else {
                                System.out.printf("%s Table Number: %d\n", check, ((InRestrOrder) order).getTableNumber());
                                System.out.printf("%s Booking Order: %b\n", check, ((InRestrOrder) order).isBookingOrder());
                            }
                            count++;
                        }
                    } catch (Exception e) {
                        System.out.println("The Customer does NOT have an order!");
                    }
                    found1++;
                }
            }
        }catch (Exception e){
            System.out.println("The Customer NOT found!");
            listCustomerOrders();
        }
    }

    /**
     * This method prints all staffs which added to this system before.
     */
    public static void listStaff() throws ParseException {        //11
        String check;
        for (Staff staff : staffs) {
            if(staff instanceof Senior)
                check = "Senior";
            else
                check = "Junior";
            System.out.printf("%s Staff ID: %d\n", check, staff.getID());
            System.out.printf("%s Staff Name: %s\n", check, staff.getName());
            System.out.printf("%s Staff Gender: %c\n", check, staff.getGender());
            System.out.printf("%s %td/%<tm/%<tY", "Date of Birth:", staff.getDateOfBirth());

            if(check.equals("Senior")){
                System.out.printf("%s %td/%<tm/%<tY", "\nStart Date: ", staff.getStartDate());
                System.out.println("\nGross Salary Yearly: "+ staff.getSalary());
            }
            else{
                System.out.printf("%s %td/%<tm/%<tY", "\nExpected End Date: ", ((Junior) staff).getExpectedEndDate());
                System.out.println("\nGross Salary Yearly: "+ staff.getSalary());
            }
            System.out.println("");
        }
    }


    /**
     * This method prints all customers which added to this system before.
     */
    public static void listCustomer() {         //12
        for (Customer customer : customers) {
            System.out.println("Staff ID: "+ customer.getID());
            System.out.println("Staff Name: "+ customer.getName());
            System.out.println("Staff Gender: "+ customer.getGender());
            System.out.printf("%s %td/%<tm/%<tY", "Date of Birth:", customer.getDateOfBirth());
            System.out.println("");
        }
    }

    /**
     * This method prints all Staff salaries which added to this system before.
     * @throws ParseException is for currentDate inside of getSalary() method.
     */
    public static void listAllStaffSalary() throws ParseException {        //13
        for (Staff staff : staffs) {
            System.out.println("\nStaff ID: "+ staff.getID());
            System.out.println("Staff Name: "+ staff.getName());
            System.out.println("Staff Salary: "+ staff.getSalary());
            System.out.println("");
        }
    }

    /**
     * This method prints all type of customer orders which added to this system before.
     */
    public static void listAllOrder() {        //14
        String check = "";
        try {
            for (Customer customer : customers) {
                System.out.println("Customer ID: " + customer.getID());
                System.out.println("Customer Name: " + customer.getName());
                try {
                    for (Order order : customer.orders) {
                        if (order instanceof OnlineOrder)
                            check = "Online";
                        else
                            check = "In Restaurant";
                        System.out.printf("\n%s Order ID: %d", check, order.getOrderID());
                        System.out.printf("%s %td/%<tm/%<tY", "\nOrder Date: ", order.getOrderDate());
                        System.out.printf("\n%s Order Details: %s", check, order.getOrderDetails());
                        System.out.printf("\n%s Order Extra Notes: %s\n", check, order.getExtraNotes());
                        if (check.equals("Online")) {
                            if (((OnlineOrder) order).getPaymentType() == 'B' || ((OnlineOrder) order).getPaymentType() == 'b')
                                System.out.printf("%s Payment Type: Bank Card\n", check);
                            else
                                System.out.printf("%s Payment Type: Cash\n", check);
                            System.out.println("Delivered By: ");
                            ((OnlineOrder) order).stringDeliveredBy();
                        } else {
                            System.out.printf("%s Table Number: %d\n", check, ((InRestrOrder) order).getTableNumber());
                            System.out.printf("%s Booking Order: %b\n", check, ((InRestrOrder) order).isBookingOrder());
                        }
                    }
                }catch(Exception e){
                    System.out.println("Customer does NOT have an order!");
                    listAllOrder();
                }
            }
        }catch(Exception e){
            System.out.println("The Customer NOT found!");
            listAllOrder();
        }
    }

    /**
     * This method is just for using on Restaurant Orders which bookings before.
     */
    public static void addOrderOfBooking(){
        Scanner input = new Scanner(System.in);
        int check = 0;
        SimpleDateFormat prs = new SimpleDateFormat("dd/MM/yyyy");
        System.out.print("Enter a Customer ID Num: ");
        int ssn = input.nextInt();
        System.out.print("Enter a Booking ID Num: ");
        int bookID = input.nextInt();
        try {
            int found = 0;
            for (Customer customer : customers) {
                if (customer.getID() == ssn) {
                    for(Booking booking : customer.bookings){
                        if(booking.getBookingID() == bookID){
                            check = check + 1;
                        }
                    }

                    if(check > 0){
                        System.out.println("This uses just adding Restaurant Orders: ");

                        System.out.print("Enter an Restaurant Order ID: ");
                        int orderId = input.nextInt();

                        System.out.print("Enter Restaurant Order Date (dd/mm/yyyy): ");
                        String od = input.next();
                        Date orderDate = prs.parse(od);

                        System.out.print("Enter Restaurant Order Details: ");
                        String orderDetails = input.next();

                        System.out.print("Enter Restaurant Order Extra Notes: ");
                        String extraNotes = input.next();

                        System.out.print("Enter Restaurant Table Number: ");
                        int tableNumber = input.nextInt();

                        Order restaurant = new InRestrOrder(orderId, orderDate, orderDetails, extraNotes, tableNumber, true);
                        customer.addOrder(restaurant);
                    }
                }
            }
        }catch(Exception e){
            System.out.println("The Customer Object NOT found!");
            addOrderOfBooking();
        }
    }


    /**
     * This method is for exiting from the program
     */
    public static void exit() {  //16
        System.out.println("See You!");
        System.exit(0);
    }


    /**
     * executes the all other methods and has main definitions and redirects.
     * @param args uses for CLI commands
     * @throws ParseException is for parsing dates
     */
    public static void main(String[] args) throws ParseException{
        SimpleDateFormat prs = new SimpleDateFormat("dd/MM/yyyy");
        Scanner input = new Scanner(System.in);
        ResManApp res = new ResManApp();
        populateData.fillDB();

        menu();
        int choice = input.nextInt();
        while (true) {
            switch (choice) {
                case 1:    //*********** responsiblefrom ekle
                    addStaff();
                    break;
                case 2:
                    deleteStaff();
                    break;
                case 3:
                    listStaffDetails();
                    break;
                case 4:
                    addCustomer();
                    break;
                case 5:
                    deleteCustomer();
                    break;
                case 6:
                    addBooking();
                    break;
                case 7:
                    addOrder();
                    break;
                case 8:
                    listCustomerDetails();  //************
                    break;
                case 9:
                    displayCustomerLastBooking();
                    break;
                case 10:
                    listCustomerOrders();
                    break;
                case 11:
                    listStaff();
                    break;
                case 12:
                    listCustomer();
                    break;
                case 13:
                    listAllStaffSalary();
                    break;
                case 14:
                    listAllOrder();
                    break;
                case 15:
                    addOrderOfBooking();
                    break;
                case 16:
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
