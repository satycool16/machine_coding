package cab.models;

public class Driver extends User{


    boolean isAvailable;
    Car car;

    @Override
    public String toString() {
        return "Driver{" +
                "isAvailable=" + isAvailable +
                ", firstName='" + firstName + '\'' +
                '}';
    }

    public Driver(int id, String firstName, String lastName, String emailId, String address, Car car) {
        super(id, firstName, lastName, emailId, address);
        this.isAvailable = true;
        this.car = car;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }


}
