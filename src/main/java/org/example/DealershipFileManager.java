package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DealershipFileManager {

    //name of the class
    public static List<Vehicle> getVehicles(){

        //create an Array List
        List<Vehicle> vehicleList = new ArrayList<>();

        //use try-catch to validate the file manager / to make sure it's not broken
        try{
           //FileReader is the class that has the code to read a file / fileReader is the variable
            FileReader fileReader = new FileReader("src/main/resources/Vehicles.csv");

            //BufferReader allows the computer to read the file faster
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            //Variable to hold each line of the csv file
            String input;

            bufferedReader.readLine(); // Skips the header in the csv file

            //while a line in the csv file is not empty (has nothing), run the while loop
            while( (input = bufferedReader.readLine()) != null){
                String[] csvRow = input.split("\\|"); //Splits each piece of data from each line by |

                //describe what data type is and in which index number it is in
                int vin = Integer.parseInt(csvRow[0]);
                int year = Integer.parseInt(csvRow[1]);
                String make = (csvRow[2]);
                String model = (csvRow[3]);
                String vehicleType = (csvRow[4]);
                String color = (csvRow[5]);
                int odometer = Integer.parseInt(csvRow[6]);
                int price = Integer.parseInt(csvRow[7]);

                //Create an object for each line of the csv file
                Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);

                //making a copy list (short term list) of the csv file (permanent list)
                vehicleList.add(vehicle);
            }
            bufferedReader.close(); //Cuts the connection (for security) / closes the loop

            //returns the finished vehicle list back to me
            return vehicleList;

        }
        catch(IOException ex){
            System.out.println("There was a error reading the file");
        }

        return new ArrayList<>();
    }

    //fileWriter takes the copy list (short term) and updates the permanent list (csv file) with data
    public static void writeVehicle(Vehicle vehicle){

        try{

            FileWriter fileWriter = new FileWriter("src/main/resources/Vehicles.csv", true);

            //Append - whether the file is open or not



//            if(fileWriter.length() > 0){
//                fileWriter.write(System.lineSeparator());
//            }

            fileWriter.write(String.format("%d|%d|%s|%s|%s|%s|%d|%f\n", vehicle.getVin(), vehicle.getYear(),
                    vehicle.getMake(), vehicle.getModel(), vehicle.getVehicleType(), vehicle.getColor(),
                    vehicle.getOdometer(), vehicle.getPrice()));

            fileWriter.close();
        }
        catch(IOException ex){
            System.out.println("Error writing the file.");
        }
    }
}
