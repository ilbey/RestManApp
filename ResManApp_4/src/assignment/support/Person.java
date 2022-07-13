package assignment.support;
import java.io.Serializable;
import java.util.Date;

/**
 * This is the abstract class, and parent class of staff and customer classes.
 */
public abstract class Person implements Serializable {
    protected int ID;
    protected String name;
    protected char gender;
    protected Date dateOfBirth;

    /**
     * setter for person SSN
     * @param ID ssn keeps person ssn, takes from user, uses as primary key for staffs and customers list
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * getter for person SSN
     * @return ssn
     */
    public int getID() {
        return ID;
    }

    /**
     * setter for person Name
     * @param name keeps person name, takes from user
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getter for person Name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * setter for person Gender
     * @param gender keeps person gender, takes from user
     */
    public void setGender(char gender) {
        this.gender = gender;
    }

    /**
     * getter for person Gender
     * @return gender
     */
    public char getGender() {
        return gender;
    }

    /**
     * setter for person birth date
     * @param dateOfBirth keeps birth date, takes from user
     */
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * getter for person birth date
     * @return dateOfBirth
     */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }
}
