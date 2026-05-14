package org.example;

import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private Dealership dealership;
    private Scanner scanner;

    //constructor

    //Reads the private methods first
    public UserInterface(){
        init();
        scanner = new Scanner(System.in);
    }

    private void init(){
       //Officially create the list here
        //File manager does NOT do its job until you call it
        DealershipFileManager fileManager = new DealershipFileManager();

        //Now that
        this.dealership = fileManager.getDealership();
    }

    public void display(){

        System.out.println("----- Welcome to Midnight Imports! ------");

        while(true){

            System.out.println();

            System.out.println("What services can we help you with today?\n"
            + "\t1. Find Vehicles\n"
            + "\t2. List all vehicles\n"
            + "\t3. Add vehicle\n"
            + "\t4. Remove vehicle\n"
            + "\t5. Exit\n");

            System.out.print("Select one of the listed options: ");

            int option = scanner.nextInt();

            switch (option){
                case 1:
                    filterMenu();
                    break;
                case 2:
                    displayVehicles();
                    break;
                case 3:
                    addVehicle(scanner);
                    break;
                case 4:
                    removeVehicle(scanner);
                    break;
                case 5:
                    System.out.println("\nThank you for visiting! Have a great day!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("\nInvalid input. Please try again.");
            }
        }
    }

    public void filterMenu(){
        System.out.println("\nSelect a filter option to find a vehicle\n"
            + "\t1. Find vehicle by year\n"
            + "\t2. Find vehicle by make and model\n"
            + "\t3. Find vehicle by vehicle type\n"
            + "\t4. Find vehicle by color\n"
            + "\t5. Find vehicle by odometer (mileage) range\n"
            + "\t6. Find vehicle by price range\n");

        System.out.print(" Select one of the filter options above: ");

        int filter = scanner.nextInt();

        scanner.nextLine();

        switch (filter){
            case 1:
                getYear();
                break;
            case 2:
                getMakeModel();
                break;
            case 3:
                getVehicleType();
                break;
            case 4:
                vehicleColor();
                break;
            case 5:
                vehicleOdometer();

        }

    }

    public void getYear(){
        System.out.print("\nEnter oldest year for vehicle: ");

        String oldest = scanner.nextLine();

        System.out.print("\nEnter newest year for vehicle: ");

        String newest = scanner.nextLine();

        dealership.getVehicleByYear(oldest, newest);
    }

    public void getMakeModel(){
        System.out.print("\nEnter the make of the vehicle: ");

        String make = scanner.nextLine();

        System.out.print("\nEnter the model of the vehicle: ");

        String model = scanner.nextLine();


        dealership.getVehicleMakeModel(make, model);
    }

    public void getVehicleType(){
        System.out.print("Enter the type of vehicle: ");

        String vehicleType = scanner.nextLine();

        dealership.getVehicleType(vehicleType);
    }

    public void vehicleColor(){
        System.out.print("\nEnter color of the vehicle: ");
        String color = scanner.nextLine();

        dealership.getVehicleColor(color);
    }

    public void vehicleOdometer(){


        System.out.print("\nEnter car's minimum odometer: ");

        int minOdometer = Integer.parseInt(scanner.nextLine());

        System.out.print("\nEnter car's maximum odometer: ");

        int maxOdometer = scanner.nextInt();

        dealership.getVehicleByOdometer(minOdometer, maxOdometer);
    }

    public void displayVehicles(){
        for(Vehicle vehicle : dealership.getAllVehicles() ){
            System.out.println(vehicle.toString());
        }
    }

    public void addVehicle(Scanner scanner){

        scanner.nextLine();

        System.out.print("\nEnter the VIN number: ");
        String vin = scanner.nextLine();

        System.out.print("\nEnter the year of the car: ");
        String year = scanner.nextLine();

        System.out.print("\nEnter the make of the vehicle: ");
        String make = scanner.nextLine();

        System.out.print("\nEnter the model of the vehicle: ");
        String model = scanner.nextLine();

        System.out.print("\nEnter the vehicle type: ");
        String vehicleType = scanner.nextLine();

        System.out.print("\nEnter the color of the vehicle: ");
        String color = scanner.nextLine();

        System.out.print("\nEnter the odometer of the vehicle: ");
        int odometer = Integer.parseInt(scanner.nextLine());

        System.out.print("\nEnter the price of the vehicle: ");
        double price = scanner.nextDouble();

        Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color,
                odometer, price);

        DealershipFileManager.writeVehicle(vehicle);

        System.out.println("\nVehicle has been added to the dealership!");
    }

    public void removeVehicle(Scanner scanner){
        System.out.print("\nEnter the VIN number of the vehicle: ");
        String vin = scanner.nextLine();

        dealership.removeVehicle(vin);
    }



}
