package splitwise.expense;

import splitwise.User;
import splitwise.split.Split;

import java.util.List;

public class PercentExpense extends Expense{

    public PercentExpense(String label, double amount, User paidBy, List<Split> splits) {
        super(label, amount, paidBy, splits);
    }


}
