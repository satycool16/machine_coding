package cab.models;

public class Location {
    int x;
    int y;

    @Override
    public String toString() {
        return "("+x+","+y+")";
    }

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public static int distance(Location location1, Location location2){
        return Math.abs(location1.x-location2.x) + Math.abs(location1.y- location2.y);
    }
}
