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

        while(true){
            System.out.println("----- Welcome to Midnight Imports! ------");

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
            }
        }
    }

    public void filterMenu(){
        System.out.println("\nSelect a filter option to find a vehicle\n"
            + "\t1. Find vehicle by year\n"
            + "\t2. Find vehicle by make\n"
            + "\t3. Find vehicle by make and model\n"
            + "\t4. Find vehicle by vehicle type\n"
            + "\t5. Find vehicle by color\n"
            + "\t6. Find vehicle by odometer (mileage) range\n"
            + "\t7. Find vehicle by price range\n");

        System.out.print(" Select one of the filter options above: ");

        int filter = scanner.nextInt();

        getYear();
    }

    public void getYear(){
        System.out.print("\nEnter oldest year for vehicle: ");

        int oldest = scanner.nextInt();

        System.out.print("\nEnter newest year for vehicle: ");

        int newest = scanner.nextInt();

        dealership.getVehicleByYear(oldest, newest);

        System.out.println();

    }
}
