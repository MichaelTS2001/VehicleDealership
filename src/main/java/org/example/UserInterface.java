package org.example;

import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private Dealership dealership;
    private Scanner scanner;


    //constructor

    //Reads the private methods first
    public UserInterface(){
        fileManager();
    }

    private void fileManager(){
       //Officially create the list here
        //File manager does NOT do its job until you call it
        DealershipFileManager fileManager = new DealershipFileManager();

        //Now that
        this.dealership = fileManager.getDealership();
    }

    public void display(){
        fileManager();

        while(true){
            System.out.println("----- Welcome to Midnight Imports! ------");

            System.out.println("What services can we help you with today?");
            System.out.println("\t1. Find Vehicles");
            System.out.println("\t2. List all vehicles");
            System.out.println("\t3. Add vehicle");
            System.out.println("\t4. Remove vehicle");
            System.out.println("\t5. Exit");

            System.out.print("\nSelect one of the listed options: ");

            int option = scanner.nextInt();

            switch (option){
                case 1:
                    filterMenu();
            }
        }
    }

    public void filterMenu(){
        System.out.println("\nSelect a filter option to find a vehicle\n");
        System.out.println("\t1. Find vehicle by year");
        System.out.println("\t2. Find vehicle by make");
        System.out.println("\t3. Find vehicle by make and model");
        System.out.println("\t4. Find vehicle by vehicle type");
        System.out.println("\t5. Find vehicle by color");
        System.out.println("\t6. Find vehicle by odometer (mileage) range");
        System.out.println("\t7. Find vehicle by price range");

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
