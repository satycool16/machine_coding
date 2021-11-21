package social;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserManager {

    private static UserManager userManager = null;
    Map<String, User> users;

    public User getLoggedInUser() {
        return loggedInUser;
    }

    User loggedInUser;
    int userCount;

    private UserManager() {
        users = new HashMap<>();
        loggedInUser = null;
        userCount = 0;
    }

    public static UserManager getInstance(){
        if (userManager == null)
            userManager = new UserManager();
        return userManager;
    }

    public User signup(String name) throws UserAlreadyExistWithSameNameException{
        if (users.containsKey(name))
            throw new UserAlreadyExistWithSameNameException();
        User newUser = new User(++userCount, name);
        users.put(name, newUser);
        return users.get(name);
    }

    public User login(String name) throws UserDoesNotExitException{
        if (!users.containsKey(name))
            throw new UserDoesNotExitException();
        loggedInUser = users.get(name);
        return loggedInUser;
    }

    public User logout() throws NoLoggedInUserException{
        User loggedOutUser = whoAmI();
        loggedInUser = null;
        return loggedOutUser;
    }

    public User whoAmI() throws NoLoggedInUserException{
        if (loggedInUser == null)
            throw new NoLoggedInUserException();
        return loggedInUser;
    }

    private User getUser(String userName) throws UserDoesNotExitException{
        if (!users.containsKey(userName))
            throw new UserDoesNotExitException();
        return users.get(userName);
    }

    public boolean follow(String userName) throws UserDoesNotExitException{
        User followTo = getUser(userName);
        return followTo.followers.add(loggedInUser) &&
                loggedInUser.following.add(followTo);
    }

    public boolean unfollow(String userName) throws UserDoesNotExitException{
        User unFollowTo = getUser(userName);
        return unFollowTo.followers.remove(loggedInUser) &&
        loggedInUser.following.remove(unFollowTo);
    }

}
