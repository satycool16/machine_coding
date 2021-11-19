package splitwise;
import splitwise.split.EqualSplit;
import splitwise.split.ExactSplit;
import splitwise.split.PercentSplit;
import splitwise.split.Split;

import java.util.ArrayList;
import java.util.List;

public class Splitwise {

    public static void main(String[] args) {
        ExpenseManager expenseManager = new ExpenseManager();

        User sagar = new User(1, "Sagar", "abcd@gmail.com", "100");
        User deepesh = new User(2, "Deepesh", "defg@gmail.com", "101");
        User bhavik = new User(3, "Bhavik", "hijk@gmail.com", "102");
        expenseManager.addUser(sagar);
        expenseManager.addUser(deepesh);
        expenseManager.addUser(bhavik);

        List<Split> splits = new ArrayList<>();

        splits.add(new EqualSplit(sagar));
        splits.add(new EqualSplit(bhavik));
        splits.add(new EqualSplit(deepesh));

        expenseManager.addExpense(
                ExpenseType.EQUAL,
                300,
                sagar.getId(),
                splits,
                "food"
                );

        List<Split> splits1 = new ArrayList<>();

        splits1.add(new ExactSplit(sagar, 100));
        splits1.add(new ExactSplit(bhavik, 50));
        splits1.add(new ExactSplit(deepesh, 150));

        expenseManager.addExpense(
                ExpenseType.EXACT,
                300,
                sagar.getId(),
                splits1,
                "movie"
        );

        List<Split> splits2 = new ArrayList<>();

        splits2.add(new PercentSplit(sagar, 0));
        splits2.add(new PercentSplit(bhavik, 20));
        splits2.add(new PercentSplit(deepesh, 80));

        expenseManager.addExpense(
                ExpenseType.PERCENT,
                1000,
                sagar.getId(),
                splits2,
                "cake"
        );
        expenseManager.showBalanceForUser(sagar.getId());
    }
}
