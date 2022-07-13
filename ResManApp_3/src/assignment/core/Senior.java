package assignment.core;

import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

/**
 * maintains information about senior staffs working at the restaurant.
 */
public class Senior extends Staff implements Serializable {
    private int grossSalaryYearly;
    private ArrayList<Junior> responsibleFrom;

    /**
     * default constructor for senior class
     */
    public Senior(){
        super();
        this.grossSalaryYearly = 0;
    }

    /**
     * a constructor for senior with variables
     * @param ID keeps senior ssn, takes from user
     * @param name keeps senior name, takes from user
     * @param gender keeps senior gender, takes from user
     * @param dateOfBirth keeps senior birth date, takes from user
     * @param startDate keeps start working date for senior, takes from the user
     * @param grossSalaryYearly keeps gross salary yearly for senior, takes from user
     */
    public Senior(int ID, String name, char gender, Date dateOfBirth, Date startDate, int grossSalaryYearly){
        super(ID, name, gender, dateOfBirth, startDate);
        this.grossSalaryYearly = grossSalaryYearly;
        this.responsibleFrom = new ArrayList<Junior>();
    }

    /**
     * getter for senior's gross salary yearly
     * @return grossSalaryYearly
     */
    public int getGrossSalaryYearly() {
        return grossSalaryYearly;
    }

    /**
     * setter for senior's gross salary yearly
     * @param grossSalaryYearly is integer type, takes from user
     */
    public void setGrossSalaryYearly(int grossSalaryYearly) {
        this.grossSalaryYearly = grossSalaryYearly;
    }

    /**
     * adds the junior object to senior's responsibleFrom ArrayList
     * @param junior takes from user
     */
    public void addResponsibleFrom(Junior junior){
        this.responsibleFrom.add(junior);
    }

    /**
     * overrides from Staff class, for specifically calculates salary for senior
     * @return temp
     * @throws ParseException is parsing for current Date
     */
    @Override
    public int getSalary() throws ParseException {
        Date date = new Date();

        long diff = date.getTime() - this.startDate.getTime();

        diff = (int) (diff / 31556952);
        diff = (int) (diff / 1000);

        int percen = (int) (diff * 10);
        int salary = this.grossSalaryYearly / 12;
        int temp = (percen * salary) / 100;

        temp = salary + temp;


        return temp;
    }
}
