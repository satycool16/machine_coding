package splitwise.expense;

import splitwise.User;
import splitwise.split.Split;

import java.util.List;

public class EqualExpense extends Expense{
    public EqualExpense(String label, double amount, User paidBy, List<Split> splits) {
        super(label, amount, paidBy, splits);
    }
}
