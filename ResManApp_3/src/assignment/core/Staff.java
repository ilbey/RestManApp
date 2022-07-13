package assignment.core;

import assignment.support.Employee;
import assignment.support.Person;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;

/**
 * maintains information about staff working at the restaurant.
 */
public class Staff extends Person implements Employee, Serializable {
    protected Date startDate;

    /**
     * default constructor for Staff
     */
    public Staff(){
        this.ID = 0;
        this.name = "";
        this.gender = 'M';
    }

    /**
     * a constructor for staff with variables
     * @param ID keeps staff ssn, takes from user, uses as primary key for staffs list
     * @param name keeps staff name, takes from user
     * @param gender keeps staff gender, takes from user
     * @param dateOfBirth keeps staff birth date, takes from user
     * @param startDate keeps staff start date on this workplace, takes from user.
     */
    public Staff(int ID, String name, char gender, Date dateOfBirth, Date startDate){
        this.ID = ID;
        this.name = name;
        this.gender = gender;
        this.dateOfBirth =dateOfBirth;
        this.startDate = startDate;
    }

    /**
     * setter for staff start date, takes from user
     * @param startDate is Date type
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * getter for staff start date
     * @return startDate
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * is overriding from Employee interface, and senior and junior overrides this method.
     * @throws ParseException is parsing on Senior getSalary() method
     */
    @Override
    public int getSalary() throws ParseException {
        return 0;
    }


}
