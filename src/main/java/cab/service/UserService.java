package cab.service;

import cab.models.Driver;
import cab.models.Rider;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    static UserService userService = null;

    private List<Rider> riders;
    private List<Driver> drivers;

    private UserService(){
        riders = new ArrayList<>();
        drivers = new ArrayList<>();

    }

    public static UserService getInstance(){
        if (userService == null)
            userService = new UserService();
        return userService;
    }

    public void registerRider(Rider rider){
        riders.add(rider);
    }

    public void registerDriver(Driver driver){
        drivers.add(driver);
    }

    public void toggleAvailability(Driver driver){
        driver.setAvailable(!driver.isAvailable());
    }


    public List<Rider> getRiders() {
        return riders;
    }

    public List<Driver> getDrivers() {
        return drivers;
    }
}
