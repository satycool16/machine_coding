package cab.models;

public class Ride {
    Driver driver;
    Rider rider;
    Location fromLocation;
    Location toLocation;

    @Override
    public String toString() {
        return "Ride{" +
                "driver=" + driver.getFirstName() +
                ", rider=" + rider.getFirstName() +
                ", fromLocation=" + fromLocation +
                ", toLocation=" + toLocation +
                '}';
    }

    public Ride(Driver driver, Rider rider, Location fromLocation, Location toLocation) {
        this.driver = driver;
        this.rider = rider;
        this.fromLocation = fromLocation;
        this.toLocation = toLocation;
    }
}
