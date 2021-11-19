package cab;

import cab.models.*;
import cab.service.RideService;
import cab.service.UserService;

public class MainClass {

    static UserService userService = UserService.getInstance();
    static RideService rideService = RideService.getInstance();

    public static void main(String[] args) throws Exception{
        Rider sagarRider = new Rider(1, "Sagar", "Jain", "abcd@gmail.com", "Meerut");
        Car carA = new Car(1, new Location(1,1), "UP15ABCD", "Dzire");
        Car carB = new Car(2, new Location(10,10), "DL1234", "Dzire");

        Driver driverA = new Driver(1, "A", "Jain", "a@gmail.com","Meerut", carA);
        Driver driverB = new Driver(2, "B", "Jain", "b@gmail.com","Meerut", carB);

        userService.registerRider(sagarRider);
        userService.registerDriver(driverA);
        userService.registerDriver(driverB);

        Location myLocation = new Location(1,1);
        System.out.println(rideService.getAvailableDriversNearby(myLocation));

        System.out.println("Booking ride.");
        rideService.confirmBooking(sagarRider, myLocation, new Location(20,20));

        System.out.println(rideService.getAvailableDriversNearby(myLocation));
        rideService.confirmBooking(sagarRider, myLocation, new Location(20,20));

        System.out.println(sagarRider.getRides());
    }
}
