package assignment.core;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static assignment.core.ResManApp.customers;

public class DataStorage {

    /**
     * Connects DataBase, doing confgurations and returning statement which we needs executeQuery().
     * @return statement
     */
    public static Statement connectDB() {
        Statement statement = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hms", "cng443user", "1234");
            statement = connection.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return statement;
    }


    /**
     * Adds customer or booking objects to DataBase.
     * @param object takes from ResManApp.addBooking() or ResManApp.addCustomer() functions
     */
    public static void toDB(Object object) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Statement statement = null;
        try {
            statement = connectDB();
            String str = "";
            if (object instanceof Customer){
                int id = ((Customer)object).getID();
                String name = ((Customer)object).getName();

                String dob = dateFormat.format(((Customer)object).getDateOfBirth());
                char gender = ((Customer)object).getGender();
                String rd = dateFormat.format(((Customer)object).getRegistrationDate());
                String ccd = ((Customer)object).getCreditCardDetails();
                str = "INSERT INTO customer VALUES ("+id+",'"+name+"','"+dob+"','"+gender+"','"+rd+"','"+ccd+"')";
            }
            if (object instanceof Booking){
                int cstID = 0;
                int bookingID = ((Booking)object).getBookingID();
                String bd = dateFormat.format(((Booking)object).getBookingDate());
                for(Customer customer : customers){
                    for(Booking booking : customer.bookings){
                        if (bookingID == booking.getBookingID()) {
                            cstID = customer.getID();
                        }
                    }
                }
                str = "INSERT INTO booking VALUES ("+bookingID+",'"+bd+"',"+cstID+")";
            }
            statement.executeUpdate(str);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * Removing specific customer element from DataBase.
     * @param customerID takes from ResManApp.deleteCustomer()
     */
    public static void removeFromDB(int customerID) {
        Statement statement = null;
        try {
            statement = connectDB();

            String str = "DELETE FROM customer WHERE id="+customerID;
            statement.executeUpdate(str);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * This fuction gets customers and bookings data from DataBase. And also, it adds to
     * customers and bookings lists.
     */
    public static void fromDB() {
        SimpleDateFormat prs = new SimpleDateFormat("dd/MM/yyyy");
        Statement statement = null;
        try {
            statement = connectDB();
            ResultSet rs = statement.executeQuery("SELECT * FROM customer");
            while (rs.next()) {
                Customer customer = new Customer(rs.getInt(1), rs.getString(2), (rs.getString(4)).charAt(0), prs.parse(rs.getString(3)), prs.parse(rs.getString(5)), rs.getString(6));
                customers.add(customer);
            }

            ResultSet bk = statement.executeQuery("SELECT * FROM booking");
            while (bk.next()) {
                int bookingID = bk.getInt(1);
                Booking bkng = new Booking(bookingID, prs.parse(bk.getString(2)));
                for (Customer customer : customers) {
                    for (Booking booking : customer.bookings) {
                        if (bookingID == booking.getBookingID()) {
                            customer.addBooking(bkng);
                        }
                    }
                }
            }
        } catch (SQLException | ParseException throwables) {
            throwables.printStackTrace();
        }
    }
}
