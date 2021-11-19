package cab.models;


public class User {

    int id;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getAddress() {
        return address;
    }

    String firstName;
    String lastName;
    String emailId;
    String address;

    public User(int id, String firstName, String lastName, String emailId, String address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.address = address;
    }
}
