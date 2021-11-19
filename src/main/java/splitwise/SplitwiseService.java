package splitwise;

import splitwise.expense.EqualExpense;
import splitwise.expense.ExactExpense;
import splitwise.expense.Expense;
import splitwise.expense.PercentExpense;
import splitwise.split.PercentSplit;
import splitwise.split.Split;

import java.util.List;

public class SplitwiseService {

    public static Expense createExpense(ExpenseType expenseType, User paidBy, double amount, List<Split> splits, String label){
        switch (expenseType){
            case EQUAL:
                double amountShare = amount/splits.size();
                for (Split split: splits){
                    split.setAmount(amountShare);
                }
                splits.get(0).setAmount(amount-amountShare*splits.size()-1);
                return new EqualExpense(label, amount, paidBy, splits);

            case PERCENT:
                for (Split split: splits){
                    PercentSplit percentSplit = (PercentSplit) split;
                    split.setAmount(percentSplit.getPercent()*amount/100);
                }
                return new PercentExpense(label, amount, paidBy, splits);

            case EXACT:
                return new ExactExpense(label, amount, paidBy, splits);
            default:
                System.out.println("Invalid ExpenseType: "+ expenseType);
                return null;
        }
    }
}
