package ResManApp;

/**
 * maintains information about the orders of customers' bookings.
 */
public class Order {
    private String details;
    private String description;

    /**
     * default constructor for order
     */
    public Order() {
        this.details = "";
        this.details = "";
    }

    /**
     * a constructor for order with variables
     * @param details order details
     * @param description order description
     */
    public Order(String details, String description) {
        this.details = details;
        this.description = description;
    }

    /**
     * getter for order Details
     * @return details
     */
    public String getDetails() {
        return details;
    }

    /**
     * setter for order Details
     * @param details order details
     */
    public void setDetails(String details) {
        this.details = details;
    }

    /**
     * getter for order Description
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * setter for order Description
     * @param description order description
     */
    public void setDescription(String description) {
        this.description = description;
    }


}
