package cab.service;

import cab.exception.NoDriverAvailableException;
import cab.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RideService {

    static RideService rideService = null;
    UserService userService = UserService.getInstance();
    final int NEARBY_THRESHOLD = 100;

    private RideService(){
    }

    public static RideService getInstance(){
        if (rideService == null)
            rideService = new RideService();
        return rideService;
    }


    public List<Driver> getAvailableDriversNearby(Location location){

        return userService.getDrivers()
                .stream()
                .filter(Driver::isAvailable)
                .filter(driver ->
            Location.distance(driver.getCar().getLocation(), location) < NEARBY_THRESHOLD)
                .collect(Collectors.toList());

    }

    public Ride confirmBooking(Rider rider, Location fromLocation, Location toLocation) throws NoDriverAvailableException{
        List<Driver> drivers = getAvailableDriversNearby(fromLocation);

        if (drivers.isEmpty())
            throw new NoDriverAvailableException();

        Driver driver = drivers.get(0);
        Ride ride = new Ride(driver, rider, fromLocation, toLocation);
        driver.setAvailable(false);
        rider.addRide(ride);
        return ride;
    }
}
