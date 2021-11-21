package social;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class User {
    int id;
    String name;
    Set<User> followers;
    Set<User> following;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
        followers = new HashSet<>();
        following = new HashSet<>();
    }

    @Override
    public String toString() {
        return name;
    }
}
