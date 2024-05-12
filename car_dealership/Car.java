package carDealership;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
// Assignment: 5
// Author: Oleg Muraviov, ID: 321163446
public class Car {
    protected String CarId;
    protected int yearManufacture;
    protected String NameManufacture;
    protected int kilometers;
    protected double price;
    /**
     * Constructs a Car object with the specified attributes.
     *
     * @param nameManufacture  the name of the car manufacturer
     * @param kilometers       the number of kilometers the car has been driven
     * @param price            the price of the car
     * @param yearManufacture  the year the car was manufactured
     * @param carId            the unique identifier of the car
     * @throws IllegalArgumentException if the yearManufacture is before 2017 or if the price is negative
     */
    public Car(String nameManufacture, int kilometers, double price, int yearManufacture, String carId) {
        CarId = carId;

        if (yearManufacture < 2017)
            throw new IllegalArgumentException("Car year must be 2017 or later.");
        else
                this.yearManufacture = yearManufacture;

        NameManufacture = nameManufacture;
        this.kilometers = kilometers;

        if(price>=0)
            this.price = price;
        else
            throw new IllegalArgumentException("Price must be positive.");
    }

    public String getCarId() {
        return CarId;
    }

    public void setCarId(String carId) {
        CarId = carId;
    }

    public int getYearManufacture() {
        return yearManufacture;
    }

    public void setYearManufacture(int yearManufacture) {
        this.yearManufacture = yearManufacture;
    }

    public String getNameManufacture() {
        return NameManufacture;
    }

    public void setNameManufacture(String nameManufacture) {
        NameManufacture = nameManufacture;
    }

    public int getKilometers() {
        return kilometers;
    }

    public void setKilometers(int kilometers) {
        this.kilometers = kilometers;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "CarId='" + CarId +
                ", yearManufacture=" + yearManufacture +
                ", NameManufacture='" + NameManufacture +
                ", kilometers=" + kilometers +
                ", price=" + price +
                '}';
    }

    protected void lowerThePrice(double precentOfdecrease){

        if (precentOfdecrease < 0) {
            throw new IllegalArgumentException("Discount percentage cannot be negative.");
        }

        double Decimial_precentOfdecrease = precentOfdecrease*0.01;
        double priceOfdecrease = Decimial_precentOfdecrease*price;

        if (priceOfdecrease > 5000)
            throw new IllegalArgumentException("Discount amount exceeds limit.");
        else
            this.price = price-priceOfdecrease;
    }





    public static void sellCar(Car myCar) throws IOException {
        // Create a FileWriter and PrintWriter to write to the "sold.txt" file
        FileWriter fileWriter = new FileWriter("sold.txt", true); // true for append mode
        PrintWriter printWriter = new PrintWriter(fileWriter);

        // Format the car details and write them to the file
        String carDetails = String.format("%s %d %.2f %d %s",
                myCar.getNameManufacture(), myCar.getKilometers(), myCar.getPrice(),
                myCar.getYearManufacture(), myCar.getCarId());

        printWriter.println(carDetails);

        // Close the resources
        printWriter.close();
        fileWriter.close();
    }
}
