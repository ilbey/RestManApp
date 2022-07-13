package ResManApp;

import java.util.Date;

/**
 * maintains information about  staff working at the restaurant.
 */
public class Staff {
    private int ssn;
    private String name;
    private char gender;
    private Date dateOfBirth;

    /**
     * default constructor for Staff
     */
    public Staff() {
        this.ssn = 0;
        this.name = "";
        this.gender = 'M';
    }

    /**
     * a constructor for staff with variables
     * @param ssn keeps staff ssn, takes from user, uses as primary key for staffs list
     * @param name keeps staff name, takes from user
     * @param gender keeps staff gender, takes from user
     * @param dateOfBirth keeps birth date, takes from user
     */
    public Staff(int ssn, String name, char gender, Date dateOfBirth) {
        this.ssn = ssn;
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * getter for staff SSN
     * @return ssn
     */
    public int getSsn() {
        return ssn;
    }

    /**
     * setter for staff SSN
     * @param ssn keeps staff ssn, takes from user, uses as primary key for staffs list
     */
    public void setSsn(int ssn) {
        this.ssn = ssn;
    }

    /**
     * getter for staff Name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * setter for staff Name
     * @param name keeps staff name, takes from user
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getter for staff Gender
     * @return gender
     */
    public char getGender() {
        return gender;
    }

    /**
     * setter for staff Gender
     * @param gender keeps staff gender, takes from user
     */
    public void setGender(char gender) {
        this.gender = gender;
    }

    /**
     * getter for staff birth date
     * @return dateOfBirth
     */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * setter for staff birth date
     * @param dateOfBirth keeps birth date, takes from user
     */
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * This method is extra for the printing to the screen that are staffDetails
     */
    public void staffDetails() {
        System.out.println("\n\nSSN: " + ssn);
        System.out.println("Name: " + name);
        System.out.println("Gender: " + gender);
    }
}

