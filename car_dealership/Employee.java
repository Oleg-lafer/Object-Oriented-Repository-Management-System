package carDealership;
// Assignment: 5
// Author: Oleg Muraviov, ID: 321163446
import java.io.IOException;

public class Employee implements Comparable {

    protected String firstname;
    protected int id;
    protected int numOfSells;
    /**
     * Creates a new instance of the Employee class.
     *
     * @param firstname   the first name of the employee
     * @param id          the ID of the employee
     * @param numOfSells  the number of car sales made by the employee
     * @throws IllegalArgumentException if any of the provided values are invalid
     */
    public Employee(String firstname, int id, int numOfSells) throws IllegalArgumentException {
        //check if first name made only from letters.
        if (firstname.matches("[a-zA-Z]+"))
            this.firstname = firstname;
        else
            throw new IllegalArgumentException("Invalid value provided(need to be only characters): " + firstname);
        //converting id to string and check its length.
        String numId = Integer.toString(id);
        if (numId.length() == 9)
            this.id = id;
        else
            throw new IllegalArgumentException("Invalid value provided(need to be 9 numbers): " + id);
        //check if num of sells is positive.
        if (numOfSells < 0)
            throw new IllegalArgumentException("Invalid value provided(cant be negative): " + numOfSells);
        else
            this.numOfSells = numOfSells;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumOfSells() {
        return numOfSells;
    }

    public void setNumOfSells(int numOfSells) {
        this.numOfSells = numOfSells;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstname='" + firstname + '\'' +
                ", id=" + id +
                ", numOfSells=" + numOfSells +
                ", salary =" + calcSalery() +
                '}';
    }

    public void carSell(Car myCar) throws IOException {
        numOfSells++;
        myCar.sellCar(myCar);
    }


    public double calcSalery(){
        return 6000+100*numOfSells;
    }

    @Override
    public int compareTo(Object obj){
        Employee other = (Employee) obj;

        if(other.numOfSells==numOfSells)
            return 1;
        if(other.numOfSells<numOfSells)
            return 0;

        return -1;
    }

}