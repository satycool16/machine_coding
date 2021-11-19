package splitwise.expense;

import splitwise.User;
import splitwise.split.Split;

import java.util.List;

public abstract class Expense {

    int id;
    String label;
    double amount;
    User paidBy;

    public List<Split> getSplits() {
        return splits;
    }

    List<Split> splits;

    public Expense(String label, double amount, User paidBy, List<Split> splits) {
        this.label = label;
        this.amount = amount;
        this.paidBy = paidBy;
        this.splits = splits;
    }

//    public abstract boolean validate();
}
