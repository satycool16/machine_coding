package splitwise.split;

import splitwise.User;

public class PercentSplit extends Split{

    public double getPercent() {
        return percent;
    }

    double percent;

    public PercentSplit(User user, double percent) {
        super(user);
        this.percent = percent;
    }
}
