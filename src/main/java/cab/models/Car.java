package cab.models;

import cab.enums.VehicleType;

public class Car extends Vehicle{
    int id;
    Location location;

    public Car(int id, Location location,String vehicleNumber, String vehicleName) {
        this.id = id;
        this.location = location;
        this.vehicleName = vehicleName;
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = VehicleType.CAR;
    }

    public int getId() {
        return id;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }


}
