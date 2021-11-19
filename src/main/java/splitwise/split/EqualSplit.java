package splitwise.split;

import splitwise.User;

public class EqualSplit extends Split{
    public EqualSplit(User user) {
        super(user);
    }

    public EqualSplit(User user, double amount) {
        super(user, amount);
    }


}
