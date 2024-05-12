package carDealership;
// Assignment: 5
// Author: Oleg Muraviov, ID: 321163446
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class CarDealership {

    protected static <T extends Comparable<T>> void sort(ArrayList<T> array) {
        for (int i = 0; i < array.size(); i++) {
            for (int j = 0; j < array.size() - 1 - i; j++) {
                if (array.get(j).compareTo(array.get(j + 1)) == -1) {
                    T tmp = array.get(j);
                    array.set(j, array.get(j + 1));
                    array.set(j + 1, tmp);
                }
            }
        }
    }

    private static void printMenu() {
        System.out.println("Menu:");
        System.out.println("1. Display Employees");
        System.out.println("2. Display Available Cars");
        System.out.println("3. Sell Car");
        System.out.println("4. Add Car");
        System.out.println("5. End Program");
        System.out.print("Enter your choice: ");

        System.out.println("\n"+"---------------------------------------------------------------------"+"\n");



    }



    private static void printEmployees(ArrayList<Employee> employees) {
        for (Employee emp : employees) {
            System.out.println(emp.getFirstname() + " " + emp.getId());
        }
    }


    private static void printCars() throws FileNotFoundException {
        File file= new File("CarDealership.txt");
        Scanner input3= new Scanner(file);
        while(input3.hasNext()) {
            String str= input3.nextLine();
            System.out.println(str);
        }

        System.out.println("\n"+"---------------------------------------------------------------------"+"\n");
    }




    private static Employee pickEmployee(ArrayList<Employee> employees) {
        Scanner scan = new Scanner(System.in);  // Create a Scanner object
        while (true) {
            System.out.println("Pick employee ID: "+"\n");
            int ID = scan.nextInt();
            System.out.println(ID);
            for (Employee emp : employees) {
                if (emp.getId()==ID) {
                    return emp;
                }
            }
            System.out.println("Employee ID wasn't found.\nPlease enter an employee ID: ");
        }
    }
    private static Car pickCar(ArrayList<Car> cars, String carNum) {
        Scanner scan = new Scanner(System.in);  // Create a Scanner object
        while (true) {

            for (Car car : cars) {
                if (car.getCarId().equals(carNum)) {
                    return car;
                }
            }
            System.out.println("Car number wasn't found.\nPlease enter a car number: ");
        }
    }


    private static void deleteCar(ArrayList<Car> arrayCars, String carId) {
        for (int i = 0; i < arrayCars.size(); i++) {
            Car car = arrayCars.get(i);
            if (car.getCarId().equals(carId)) {
                arrayCars.remove(i);
                break; // Once the car is removed, exit the loop
            }
        }
    }

    private static ArrayList<Object> getCarDetails(Scanner scan) {
        ArrayList<Object> carDetails = new ArrayList<>();

        System.out.println("Enter car maker: ");
        String carMaker = scan.next();

        System.out.println("Enter km: ");
        int km = scan.nextInt();

        System.out.println("Enter price: ");
        double price = scan.nextDouble();

        System.out.println("Enter car year made: ");
        int yearMade = scan.nextInt();

        System.out.println("Enter car licensePlate: ");
        String licensePlate = scan.next();

        carDetails.add(carMaker);
        carDetails.add(km);
        carDetails.add(price);
        carDetails.add(yearMade);
        carDetails.add(licensePlate);

        return carDetails;
    }








    public static void main(String[] args) throws IllegalArgumentException, IOException {
        Scanner scan = new Scanner(System.in);  // Create a Scanner object


        Path path = Path.of("carDealership/Sold.txt");




        ArrayList <Car> arrayCars = new ArrayList<>();
        File file = new File("CarDealership.txt");
        Scanner input = new Scanner(file);
        while (input.hasNext()) {
            String carId = input.next();
            int yearManufacture = input.nextInt();
            String nameManufacture = input.next();
            int kilometers = input.nextInt();
            double price = input.nextDouble();

            Car car = new Car(nameManufacture, kilometers, price, yearManufacture, carId);
            arrayCars.add(car);
        }


        ArrayList <Employee> arrayEmployees = new ArrayList<>();
        File file2 = new File("Employee.txt");
        Scanner input2 = new Scanner(file2);
        while (input2.hasNext()) {
            String firstname = input2.next();
            int id = input2.nextInt();
            int numOfSells = input2.nextInt();
            Employee employee = new Employee(firstname, id, numOfSells);
            arrayEmployees.add(employee);
        }


        menu choice = null;
        while (choice != menu.END_PROGRAM) {
            printMenu();

            int userInput = scan.nextInt();
            switch (userInput) {
                case 1:
                    choice = menu.DISPLAY_EMPLOYEES;
                    sort(arrayEmployees);
                    for (Employee emp : arrayEmployees) {
                        System.out.println(emp.toString()); // Print the employee details
                    }
                    System.out.println("\n"+"---------------------------------------------------------------------"+"\n");
                    break;



                case 2:
                    choice = menu.DISPLAY_AVAILABLE_CARS;
                    printCars();
                    break;

                case 3:
                    choice = menu.SELL_CARS;

                    System.out.println("Employees of the dealership:");
                    printEmployees(arrayEmployees);
                    System.out.println("\n"+"---------------------------------------------------------------------"+"\n");
                    Employee emp= pickEmployee(arrayEmployees);

                    System.out.println("Cars of the dealership:");
                    printCars();

                    //get the car
                    System.out.println("Pick car number: ");
                    String carNum = scan.next();
                    Car car= pickCar(arrayCars,carNum);

                    deleteCar(arrayCars, carNum);

                    emp.carSell(car);
                    break;


                case 4:
                    choice = menu.ADD_CAR;
                    ArrayList<Object> newCardet = getCarDetails(scan);
                    try {
                        Car newCar = new Car((String) newCardet.get(0), (int) newCardet.get(1), (double) newCardet.get(2), (int) newCardet.get(3), (String) newCardet.get(4));
                        arrayCars.add(newCar);
                    } catch (Exception e) {
                        System.out.println("Warning Invalid data, failed to add car to the dealership");
                    }
                    break;

                case 5:
                    // end of the program.
                    choice = menu.END_PROGRAM;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }






        }




}
}
