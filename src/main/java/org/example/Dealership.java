package org.example;

import java.util.ArrayList;
import java.util.List;

public class Dealership {

    //dealership has a vehicle and vehicle is a color
    //dealership class HAS the objects / vehicle class describes the object
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    //add a vehicle to the inventory list
    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }

    //remove a vehicle from the inventory list
    public void removeVehicle(Vehicle vehicle) {
        inventory.remove(vehicle);
    }

    //get all the vehicles from the inventory
    public List<Vehicle> getAllVehicles() {
        return inventory;
    }

    //method to find specific make and model of vehicle
    public void getVehicleMakeModel(String make, String model) {

        for (Vehicle car : inventory) {
            if (car.getMake().equalsIgnoreCase(make) && car.getModel().equalsIgnoreCase(model)){
                car.toString();
            }
        }
    }

    //method to find vehicle by car price range
    public List<Vehicle> getVehicleByPrice(double min, double max) {
        List<Vehicle> carPriceRange = new ArrayList<>();
        for (Vehicle carPrice : inventory) {
            if (carPrice.getPrice() >= min && carPrice.getPrice() <= max) {
                carPriceRange.add(carPrice);
            }
        }
        return carPriceRange;
    }

    //method to find vehicle by year range
    public void getVehicleByYear(double min, double max) {

        for (Vehicle carRange : inventory) {
            if (carRange.getYear() >= min && carRange.getYear() <= max) {
                carRange.toString();
            }
        }
    }

    //method to find specific color of vehicle
    public List<Vehicle> getVehicleColor(String color) {
        List<Vehicle> carColor = new ArrayList<>();
        for (Vehicle car : inventory) {
            if (car.getColor().equalsIgnoreCase(color)) ;
            carColor.add(car);
        }
        return carColor;
    }

    //method to find vehicle by Odometer Range
    public List<Vehicle> getVehicleByOdometer(double min, double max) {
        List<Vehicle> carOdometer = new ArrayList<>();
        for (Vehicle carRange : inventory) {
            if (carRange.getOdometer() >= min && carRange.getOdometer() <= max) {
                carOdometer.add(carRange);
            }
        }
        return carOdometer;
    }

    //method to find vehicle type
    public List<Vehicle> getVehicleType(String vehicleType) {
        List<Vehicle> carType = new ArrayList<>();
        for (Vehicle car : inventory) {
            if (car.getVehicleType().equalsIgnoreCase(vehicleType)) ;
            carType.add(car);
        }
        return carType;
    }
}
