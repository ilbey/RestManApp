package assignment.core;

import assignment.GUI.*;
import assignment.support.Order;

import javax.swing.*;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * maintains information about the customers, staff working at the restaurant, customers' bookings, and their orders.
 *
 * @author Ilbey Evcil 2079242
 * @version 3.0.0
 * @since 01/01/2021
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
     * this method taking new staff details, creating and adding them into the new staff with Senior or Junior class types.
     * @throws ParseException is for parsing dateOfBirth
     */
    public static void addStaff() throws ParseException {  //1
        SimpleDateFormat prs = new SimpleDateFormat("dd/MM/yyyy");
        int found = 1;
        char gender;
        int ssn = 0;
        char staffType;
        Date dateOfBirth = null, startDate = null;

        JDialog staffAddPage = new addStaff();
        staffAddPage.setVisible(true);

        //try {
        if(((addStaff) staffAddPage).isPressedOK()) {
            found = 0;
            try {

                ssn = Integer.parseInt((((addStaff) staffAddPage).getStaffSsnTextField()).getText());
                for (Staff staff : staffs) {
                    if (staff.getID() == ssn)
                        found++;
                }
                if (found != 0)
                    JOptionPane.showMessageDialog(null, "Please, enter another SSN Number!","Warning!", JOptionPane.ERROR_MESSAGE);

                String name = (((addStaff) staffAddPage).getStaffNameTextField()).getText();

                if (((((addStaff) staffAddPage).getMaleRadioButton())).isSelected()) {
                    gender = 'M';
                } else {
                    gender = 'F';
                }

                String dob = (((addStaff) staffAddPage).getDOBformattedTextField()).getText();
                dateOfBirth = prs.parse(dob);

                String sd = (((addStaff) staffAddPage).getSDformattedTextField()).getText();
                startDate = prs.parse(sd);


                if ((((addStaff) staffAddPage).getSeniorRadioButton()).isSelected()) {
                    staffType = 'S';
                } else {
                    staffType = 'J';
                }


                if (staffType == 'S') {
                    int grossSalaryYearly = Integer.parseInt((((addStaff) staffAddPage).getSalaryYearlyTextField()).getText());

                    Senior snr = new Senior(ssn, name, gender, dateOfBirth, startDate, grossSalaryYearly);
                    staffs.add(snr);
                }
                else {
                    int monthlySalary = Integer.parseInt((((addStaff) staffAddPage).getSalaryYearlyTextField()).getText());

                    String eed = ((((addStaff) staffAddPage).getEEDTextField()).getText());
                    Date expectedEndDate = prs.parse(eed);


                    int seniorID = Integer.parseInt((((addStaff) staffAddPage).getResponsibleFromTextField()).getText());

                    for (Staff staff : staffs) {
                        if (staff instanceof Senior) {
                            if (staff.getID() == seniorID) {
                                Junior jnr = new Junior(ssn, name, gender, dateOfBirth, startDate, monthlySalary, expectedEndDate);
                                ((Senior) staff).addResponsibleFrom(jnr);
                                found++;
                            }
                        }
                    }
                    if (found > 0) {
                        Junior jnr = new Junior(ssn, name, gender, dateOfBirth, startDate, monthlySalary, expectedEndDate);
                        staffs.add(jnr);
                    }
                }
            }catch(InputMismatchException e){
                JOptionPane.showMessageDialog(null, "Please, enter an integer value!","Warning!",  JOptionPane.ERROR_MESSAGE);
            }catch(ParseException e){
                JOptionPane.showMessageDialog(null, "Please, enter date format like (DD/MM/YYYY)!","Warning!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * this method is taking a staff SSN number deleting the specific Staff, which has this SSN, from the staffs list.
     */
    public static void deleteStaff() {    //2
        int ssn = 0;
        JDialog deleteStaffPage = new deleteStaff();
        deleteStaffPage.setVisible(true);

        if(((deleteStaff) deleteStaffPage).isPressedOK()) {
            try{
                ssn = Integer.parseInt((((deleteStaff) deleteStaffPage).getDeleteStaffSsnTextField()).getText());
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Please, enter an integer value!","Warning!",  JOptionPane.ERROR_MESSAGE);
            }

            int count = 0;
            int found = 0;

            try {
                for (Staff staff : staffs) {
                    if (staff.getID() == ssn) {
                        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure to delete "+ssn+"?",
                                "Confirmation!", JOptionPane.YES_NO_OPTION);
                        if(confirm == JOptionPane.YES_OPTION){
                            staffs.remove(count);
                        }
                        found++;
                    }
                    count++;
                }
            if (found == 0){
                throw new Exception();
            }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Please, enter an integer value!","Warning!",  JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * this method is taking a staff SSN number, it is getting staff details according to this SSN number
     */
    public static void listStaffDetails() {    //3
        JDialog listStaffPage = new listStaffDetails();
        listStaffPage.setVisible(true);
        int ssn = Integer.parseInt((((listStaffDetails) listStaffPage).getListStaffDetailsTextField()).getText());


        if(((listStaffDetails) listStaffPage).isPressedOK()) {
            String check;
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

            try {
                for (Staff staff : staffs) {
                    if (staff.getID() == ssn) {
                        if (staff instanceof Senior)
                            check = "Senior";
                        else
                            check = "Junior";

                        String DoB = format.format(staff.getDateOfBirth());

                        if (check.equals("Senior")) {
                            String SD = format.format(staff.getStartDate());
                            JOptionPane.showConfirmDialog(null, "Staff Type: " + check + "\nID: " + staff.getID() + "\nName: " + staff.getName() + "\nGender: " + staff.getGender() + "\nDate of Birth: " + DoB + "\nStart Date: " + SD + "\nGross Salary Yearly: " + staff.getSalary(), "Result", JOptionPane.DEFAULT_OPTION);
                        } else {
                            String EED = format.format(((Junior) staff).getExpectedEndDate());
                            JOptionPane.showConfirmDialog(null, "Staff Type: " + check + "\nID: " + staff.getID() + "\nName: " + staff.getName() + "\nGender: " + staff.getGender() + "\nDate of Birth: " + DoB + "\nExpected End Date: " + EED + "\nGross Salary Yearly: " + staff.getSalary(), "Result", JOptionPane.DEFAULT_OPTION);
                        }
                        System.out.println("");
                    }
                }
            } catch (Exception e) {
                System.out.println("The Staff Object NOT found!");
            }
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

        JDialog customerAddPage = new addCustomer();
        customerAddPage.setVisible(true);

        if(((addCustomer) customerAddPage).isPressedOK()) {
            try{
                found = 0;
                ssn = Integer.parseInt((((addCustomer) customerAddPage).getCustomerSsnTextField()).getText());

                for (Customer customer : customers) {
                    if (customer.getID() == ssn)
                        found++;
                }
                if (found != 0)
                    throw new Exception();

                String name = (((addCustomer) customerAddPage).getCustomerNameTextField()).getText();

                if (((((addCustomer) customerAddPage).getMaleRadioButton())).isSelected()) {
                    gender = 'M';
                } else {
                    gender = 'F';
                }

                String dob = (((addCustomer) customerAddPage).getDOBformattedTextField()).getText();
                Date dateOfBirth = prs.parse(dob);

                String rd = (((addCustomer) customerAddPage).getRDformattedTextField()).getText();
                Date registrationDate = prs.parse(rd);

                String creditCardDetails = (((addCustomer) customerAddPage).getCreditCardDetailsTextArea()).getText();


                if (found == 0) {
                    Customer cst = new Customer(ssn, name, gender, dateOfBirth, registrationDate, creditCardDetails);
                    customers.add(cst);
                }
            }catch(InputMismatchException e){
                JOptionPane.showMessageDialog(null, "Please, enter an integer value!","Warning!",  JOptionPane.ERROR_MESSAGE);
            }catch (ParseException e) {
                JOptionPane.showMessageDialog(null, "Please, enter date format like (DD/MM/YYYY)!","Warning!", JOptionPane.ERROR_MESSAGE);
            }catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Please, enter another SSN value!","Warning!",  JOptionPane.ERROR_MESSAGE);
            }
        }
    }


    /**
     * this method is taking a customer SSN number deleting the specific customer, which has this SSN, from the customers list.
     */
    public static void deleteCustomer() {    //5

        JDialog deleteCustomerPage = new deleteCustomer();
        deleteCustomerPage.setVisible(true);

        if(((deleteCustomer) deleteCustomerPage).isPressedOK()) {
        int ssn = Integer.parseInt((((deleteCustomer) deleteCustomerPage).getDeleteCustomerSsnTextField()).getText());
            int count = 0;
            int found = 0;

            try {
                for (Customer customer : customers) {
                    if (customer.getID() == ssn) {
                        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure to delete "+ssn+"?",
                                "Confirmation!", JOptionPane.YES_NO_OPTION);
                        if(confirm == JOptionPane.YES_OPTION){
                            customers.remove(count);
                        }
                        found++;
                    }
                    count++;
                }
                if (found == 0){
                    throw new Exception();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Please, enter an integer value!","Warning!",  JOptionPane.ERROR_MESSAGE);
            }
        }
    }


    /**
     * this method takes customer SSN number, creating and adding them into the new booking according to customer SSN number.
     * @throws ParseException is for parsing the bookingDate
     */
    public static void addBooking() throws ParseException {     //6
        JDialog addBookingPage = new addBooking();
        addBookingPage.setVisible(true);
        SimpleDateFormat prs = new SimpleDateFormat("dd/MM/yyyy");

        if(((addBooking) addBookingPage).isPressedOk()) {
            int found = 0;
            try {
                int ssn = Integer.parseInt((((addBooking) addBookingPage).getCustomerIDTextField()).getText());
                for (Customer customer : customers) {
                    if (customer.getID() == ssn) {
                        int bookingId = Integer.parseInt((((addBooking) addBookingPage).getBookingIDTextField()).getText());

                        String bd = (((addBooking) addBookingPage).getBookingDateTextField()).getText();
                        Date bookingDate = prs.parse(bd);

                        Booking book = new Booking(bookingId, bookingDate);
                        customer.addBooking(book);
                        found++;
                    }
                }
                if (found == 0){
                    throw new Exception();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Please, enter an integer value!","Warning!",  JOptionPane.ERROR_MESSAGE);
            }
        }
    }


    /**
     * this method takes order details, creating and adding them into the new order according to customer SSN number and order type such as Online and In Restaurant.
     * @throws ParseException is parsing the orderDate
     */
    public static void addOrder() throws ParseException, IOException, ClassNotFoundException {     //7
        SimpleDateFormat prs = new SimpleDateFormat("dd/MM/yyyy");
        int jnrID = 0;
        char paymentType;
        JDialog addOrderPage = new addOrder();
        addOrderPage.setVisible(true);

        if(((addOrder) addOrderPage).isPressedOK()) {

            int ssn = Integer.parseInt((((addOrder) addOrderPage).getCustomerSsnTextField()).getText());

                int found = 0;
                for (Customer customer : customers) {
                    if (customer.getID() == ssn) {
                        int orderId = Integer.parseInt((((addOrder) addOrderPage).getOrderIDTextField()).getText());

                        String od = (((addOrder) addOrderPage).getODformattedTextField()).getText();
                        Date orderDate = prs.parse(od);

                        String orderDetails = (((addOrder) addOrderPage).getOrderDetailsTextArea()).getText();

                        String extraNotes = (((addOrder) addOrderPage).getExtraNotesTextArea()).getText();


                        if (((((addOrder) addOrderPage).getOnlineRadioButton())).isSelected()) {

                            if(((((addOrder) addOrderPage).getCashRadioButton())).isSelected()) {
                                paymentType = 'C';
                            }
                            else{
                                paymentType = 'B';
                            }

                            int juniorSSN = Integer.parseInt((((addOrder) addOrderPage).getJuniorSSNTextField()).getText());

                                for(Staff staff : staffs){
                                    if(staff instanceof Junior){
                                        if(staff.getID() == juniorSSN){
                                            jnrID = staff.getID();
                                            found++;
                                        }
                                    }
                                }
                                if(found > 0){

                                    Order online = new OnlineOrder(orderId, orderDate, orderDetails, extraNotes, paymentType, jnrID);
                                    customer.addOrder(online);
                                }
                            }

                            else {
                                int tableNumber = Integer.parseInt((((addOrder) addOrderPage).getTableNumTextField()).getText());

                                Order restaurant = new InRestrOrder(orderId, orderDate, orderDetails, extraNotes, tableNumber, false);
                                customer.addOrder(restaurant);
                            }
                        }
                    }
                }
            }

    /**
     * According to customer SSN number, it prints all customer's details, bookings and his/her orders.
     */
    public static void listCustomerDetails() {     //8
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        JDialog listCustomerPage = new listCustomerDetails();
        listCustomerPage.setVisible(true);
        int ssn = Integer.parseInt((((listCustomerDetails) listCustomerPage)).getListCustomerDetailsTextField().getText());

        if(((listCustomerDetails) listCustomerPage).isPressedOK()) {
            String check = "";
            String bankType = "";

            try {
                for (Customer customer : customers) {
                    if (customer.getID() == ssn) {
                        String DoB = format.format(customer.getDateOfBirth());
                        String RD = format.format(customer.getRegistrationDate());

                        JOptionPane.showConfirmDialog(null, "Customer ID: " + customer.getID() + "\nCustomer Name: " + customer.getName() + "\nCustomer Gender: " + customer.getGender() + "\nDate of Birth: " + DoB + "\nStart Date: " + RD + "\nCredit Card Details: " + customer.getCreditCardDetails(), "Result", JOptionPane.DEFAULT_OPTION);


                        try {
                            for (Booking booking : customer.bookings) {
                                System.out.println("This customer's booking ID: " + booking.getBookingID());
                                System.out.printf("%s %td/%<tm/%<tY", "This customer's booking Date:", booking.getBookingDate());
                            }
                        } catch (Exception e) {
                            System.out.println("Customer do NOT have booking yet.");
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("The Customer Object NOT found!");
                listCustomerDetails();
            }
        }
    }

    /**
     * This method displays specific customer's last time booking according to checking customer ID.
     */
    public static void displayCustomerLastBooking() {     //9
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        int found = 0;
        JDialog cstLastBookingPage = new displayCustomerLastBooking();
        cstLastBookingPage.setVisible(true);

        if(((displayCustomerLastBooking) cstLastBookingPage).isPressedOk()) {
            try {
                int ssn = Integer.parseInt((((displayCustomerLastBooking) cstLastBookingPage)).getCustomerSsnTextField().getText());
                    for (Customer customer : customers) {
                        if (customer.getID() == ssn) {
                            String date = format.format(customer.bookings.get(customer.bookings.size() - 1).getBookingDate());
                            JOptionPane.showConfirmDialog(null, "This Customer Name: " + customer.getName() + "\nLast booking ID: " + customer.bookings.get(customer.bookings.size() - 1).getBookingID() + "\nLast booking Date: " + date, "Customer's Last Booking", JOptionPane.DEFAULT_OPTION);
                            found++;
                        }
                    }
                if (found == 0){
                    throw new Exception();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Please, enter an integer value!","Warning!",  JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * According to customer SSN number, it prints all types of order details such as Online and In Restaurant.
     */
    public static void listCustomerOrders() {         //10
        String check;
        String paymentType = "";
        JDialog listCOPage = new listCustomerOrders();
        listCOPage.setVisible(true);

        if(((listCustomerOrders) listCOPage).isPressedOk()) {
            int ssn = Integer.parseInt((((listCustomerOrders) listCOPage)).getCustomerSsnTextField().getText());

            for (Customer customer : customers) {
                if (customer.getID() == ssn) {
                    listCOPage.dispose();
                    JFrame listCOPage2 = new listCustomerOrders2();
                    listCOPage2.setVisible(true);
                    for (Order order : customer.getOrders()) {
                        if (order instanceof OnlineOrder)
                            check = "Online";
                        else
                            check = "In Restaurant";

                        if (check.equals("Online")) {
                            if (((OnlineOrder) order).getPaymentType() == 'B' || ((OnlineOrder) order).getPaymentType() == 'b')
                                paymentType = "Bank Card";
                            else
                                paymentType = "Cash";

                            ((listCustomerOrders2) listCOPage2).setData(customer.getID(), customer.getName(), check, order.getOrderID(), order.getOrderDate(), order.getOrderDetails(), order.getExtraNotes(), paymentType, ((OnlineOrder) order).DeliveredBy());
                        } else {
                            ((listCustomerOrders2) listCOPage2).setData2(customer.getID(), customer.getName(), check, order.getOrderID(), order.getOrderDate(), order.getOrderDetails(), order.getExtraNotes(), paymentType, ((InRestrOrder) order).getTableNumber(), ((InRestrOrder) order).isBookingOrder());
                        }
                    }
                } else {
                    listCOPage.dispose();
                }
            }
        }
    }

    /**
     * This method prints all staffs which added to this system before.
     */
    public static void listStaff() throws ParseException {        //11
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            JFrame lstStfs = new listAllStaff();
            lstStfs.setVisible(true);

            for (Staff staff : staffs) {
                String DoB = format.format(staff.getDateOfBirth());

                if (staff instanceof Senior) {
                    String SD = format.format(staff.getStartDate());
                    ((listAllStaff) lstStfs).setData(staff.getID(), 'S', staff.getName(), staff.getGender(), DoB, SD, staff.getSalary(), null);
                } else {
                    String EED = format.format(((Junior) staff).getExpectedEndDate());
                    ((listAllStaff) lstStfs).setData(staff.getID(), 'J', staff.getName(), staff.getGender(), DoB, null, staff.getSalary(), EED);
                }
            }
    }


    /**
     * This method prints all customers which added to this system before.
     */
    public static void listCustomer() {         //12
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        JFrame lstCsts = new listAllCustomer();
        lstCsts.setVisible(true);
        for (Customer customer : customers) {
            String DoB = format.format(customer.getDateOfBirth());
            ((listAllCustomer) lstCsts).setData(customer.getID(), customer.getName(), customer.getGender(), DoB);
        }
    }

    /**
     * This method prints all Staff salaries which added to this system before.
     * @throws ParseException is for currentDate inside of getSalary() method.
     */
    public static void listAllStaffSalary() throws ParseException {        //13
        JFrame lstStfs = new listAllStaffSalary();
        lstStfs.setVisible(true);
        for (Staff staff : staffs) {
            ((listAllStaffSalary) lstStfs).setData(staff.getID(), staff.getName(), staff.getSalary());
        }
    }

    /**
     * This method prints all type of customer orders which added to this system before.
     */
    public static void listAllOrder() {        //14
        JFrame listorders = new listAllOrder();
        listorders.setVisible(true);
        String check = "";
        String paymentType = "";
        try {
            for (Customer customer : customers) {
                try {
                    for (Order order : customer.orders) {
                        if (order instanceof OnlineOrder)
                            check = "Online";
                        else
                            check = "In Restaurant";

                        if (check.equals("Online")) {
                            if (((OnlineOrder) order).getPaymentType() == 'B' || ((OnlineOrder) order).getPaymentType() == 'b')
                                paymentType = "Bank Card";
                            else
                                paymentType = "Cash";

                            ((listAllOrder) listorders).setData(customer.getID(), customer.getName(), check, order.getOrderID(), order.getOrderDate(), order.getOrderDetails(), order.getExtraNotes(), paymentType, ((OnlineOrder) order).DeliveredBy());
                        } else {
                            ((listAllOrder) listorders).setData2(customer.getID(), customer.getName(), check, order.getOrderID(), order.getOrderDate(), order.getOrderDetails(), order.getExtraNotes(), paymentType, ((InRestrOrder) order).getTableNumber(), ((InRestrOrder) order).isBookingOrder());
                        }
                    }
                }catch(Exception e){
                    System.out.println("Customer does NOT have an order!");
                }
            }
        }catch(Exception e){
            System.out.println("The Customer NOT found!");
        }
    }

    /**
     * This method is just for using on Restaurant Orders which bookings before.
     */
    public static void addOrderOfBooking(){
        int check = 0;
        SimpleDateFormat prs = new SimpleDateFormat("dd/MM/yyyy");
        JDialog oobPage = new addOrderOfBooking();
        oobPage.setVisible(true);

        if(((addOrderOfBooking) oobPage).isPressedOK()) {
            int ssn = Integer.parseInt((((addOrderOfBooking) oobPage)).getCustomerSsnTextField().getText());
            int bookID = Integer.parseInt((((addOrderOfBooking) oobPage)).getOOBBookingIDTextField().getText());

            try {
                for (Customer customer : customers) {
                    if (customer.getID() == ssn) {
                        for (Booking booking : customer.bookings) {
                            if (booking.getBookingID() == bookID) {
                                check = check + 1;
                            }
                        }

                        if (check > 0) {

                            int orderId = Integer.parseInt((((addOrderOfBooking) oobPage)).getOOBOrderIDTextField().getText());

                            String od = (((addOrderOfBooking) oobPage).getOOBODformattedTextField()).getText();
                            Date orderDate = prs.parse(od);

                            String orderDetails = (((addOrderOfBooking) oobPage).getOOBDetailsTextField()).getText();

                            String extraNotes = (((addOrderOfBooking) oobPage).getExtraNotesTextField()).getText();


                            int tableNumber = Integer.parseInt((((addOrderOfBooking) oobPage)).getTableNumTextField().getText());

                            Order restaurant = new InRestrOrder(orderId, orderDate, orderDetails, extraNotes, tableNumber, true);
                            customer.addOrder(restaurant);
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("The Customer Object NOT found!");
            }
        }
    }

    public static void toBinFile(File file) throws IOException {
        try{
            FileOutputStream outStream = new FileOutputStream(file.getAbsolutePath());
            ObjectOutputStream out = new ObjectOutputStream(outStream);
            out.writeObject(staffs);
            out.writeObject(customers);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void fromBinFile(File file) throws IOException, ClassNotFoundException {
        FileInputStream inputStream = new FileInputStream(file.getAbsolutePath());
        ObjectInputStream in = new ObjectInputStream(inputStream);
        staffs = (ArrayList<Staff>) in.readObject();
        customers = (ArrayList<Customer>) in.readObject();
    }



    public static void main(String[] args){
        ResManApp res = new ResManApp();

        JFrame mainPage = new ResManAppGUI();
        mainPage.setVisible(true);


    }
}
