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
    }

    private void init(){
       //Officially create the list here
        //File manager does NOT do its job until you call it
        DealershipFileManager fileManager = new DealershipFileManager();

        //Now that
        this.dealership = fileManager.getDealership();
    }

    public void display(){

        while(true){
            System.out.println("----- Welcome to Midnight Imports! ------");

            System.out.println("What services can we help you with today?"
            + "\t1. Find Vehicles"
            + "\t2. List all vehicles"
            + "\t3. Add vehicle"
            + "\t4. Remove vehicle"
            + "\t5. Exit");

            System.out.print("\nSelect one of the listed options: ");

            int option = scanner.nextInt();

            switch (option){
                case 1:
                    filterMenu();
            }
        }
    }

    public void filterMenu(){
        System.out.println("\nSelect a filter option to find a vehicle\n"
            + "\t1. Find vehicle by year"
            + "\t2. Find vehicle by make"
            + "\t3. Find vehicle by make and model"
            + "\t4. Find vehicle by vehicle type"
            + "\t5. Find vehicle by color"
            + "\t6. Find vehicle by odometer (mileage) range"
            + "\t7. Find vehicle by price range");

        System.out.print("\n Select one of the filter options above: ");

        int filter = scanner.nextInt();
    }

    public void getYear(){
        System.out.print("\nEnter oldest year for vehicle: ");

        double oldest = scanner.nextDouble();

        System.out.println("\nEnter newest year for vehicle");

        double newest = scanner.nextDouble();

        List<Vehicle> vehicleList = dealership.getVehicleByPrice(oldest, newest);

        for(Vehicle car : vehicleList){
            System.out.println(car.toString());
        }
    }

}
