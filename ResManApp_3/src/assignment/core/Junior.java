package assignment.core;
import java.io.Serializable;
import java.util.Date;

/**
 * maintains information about junior staffs working at the restaurant.
 */
public class Junior extends Staff implements Serializable {
    private int monthlySalary;
    private Date expectedEndDate;


    /**
     * default constructor for junior class
     */
    public Junior(){
        super();
        this.monthlySalary = 0;
    }

    /**
     * a constructor for junior with variables
     * @param ID keeps junior ssn, takes from user
     * @param name keeps junior name, takes from user
     * @param gender keeps junior gender, takes from user
     * @param dateOfBirth keeps junior birth date, takes from user
     * @param startDate keeps start working date for junior, takes from the user
     * @param monthlySalary keeps monthly salary for junior, takes from user
     * @param expectedEndDate keeps expected en date for junior, takes from user
     */
    public Junior(int ID, String name, char gender, Date dateOfBirth, Date startDate, int monthlySalary, Date expectedEndDate) {
        super(ID, name, gender, dateOfBirth, startDate);
        this.monthlySalary = monthlySalary;
        this.expectedEndDate = expectedEndDate;
    }

    /**
     * getter for junior's monthly salary
     * @return monthlySalary
     */
    public int getMonthlySalary() {
        return monthlySalary;
    }

    /**
     * setter for junior's monthly salary
     * @param monthlySalary is integer type, takes from user
     */
    public void setMonthlySalary(int monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    /**
     * getter for junior's expected end date
     * @return expectedEndDate
     */
    public Date getExpectedEndDate() {
        return expectedEndDate;
    }

    /**
     * setter for junior's expected end date
     * @param expectedEndDate is Date type, takes from user
     */
    public void setExpectedEndDate(Date expectedEndDate) {
        this.expectedEndDate = expectedEndDate;
    }

    /**
     * overrides from Staff class, for specifically calculates salary for junior
     * @return salary
     */
    @Override
    public int getSalary() {
        int salary = 0;
        salary = this.monthlySalary / 12;

        return salary;
    }
}
