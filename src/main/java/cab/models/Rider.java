package cab.models;

import java.util.ArrayList;
import java.util.List;

public class Rider extends User{

    List<Ride> rides;

    public Rider(int id, String firstName, String lastName, String emailId, String address) {
        super(id, firstName, lastName, emailId, address);
        this.rides = new ArrayList<>();
    }

    public boolean addRide(Ride ride){
        return rides.add(ride);
    }
    public List<Ride> getRides() {
        return rides;
    }

}
