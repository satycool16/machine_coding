package splitwise;

import splitwise.expense.Expense;
import splitwise.split.Split;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpenseManager {

    List<Expense> expenses;
    Map<Integer, User> userMap;
    Map<User, Map<User, Double>> balanceSheet;

    public ExpenseManager() {
        this.expenses = new ArrayList<>();
        this.userMap = new HashMap<>();
        this.balanceSheet = new HashMap<>();
    }

    public User addUser(User user){
        userMap.putIfAbsent(user.getId(), user);
        balanceSheet.putIfAbsent(user, new HashMap<>());
        return userMap.get(user.getId());
    }

    public void addExpense(ExpenseType expenseType, double amount, int userId, List<Split> splits, String label){
        User paidBy = userMap.get(userId);
        Expense newExpense = SplitwiseService.createExpense(
                expenseType,
                paidBy,
                amount,
                splits,
                label
        );
        expenses.add(newExpense);

        for (Split split: newExpense.getSplits()){
            User paidTo = split.getUser();
            Map<User, Double> balances = balanceSheet.get(paidBy);
            balances.put(paidTo, balances.getOrDefault(paidTo, 0.0)+ split.getAmount());
            balances = balanceSheet.get(paidTo);
            balances.put(paidBy, balances.getOrDefault(paidBy, 0.0)- split.getAmount());

        }
    }

    public void showBalanceForUser(int userId){
        User user = userMap.get(userId);
        Map<User, Double> balances = balanceSheet.get(user);
        for (Map.Entry<User, Double> entry: balances.entrySet()){
            if (entry.getKey() != user)
                printBalance(user, entry);
        }
    }

    private void printBalance(User user, Map.Entry<User, Double> entry) {
        if (entry.getValue() != 0){
            if (entry.getValue()> 0){
                System.out.println(entry.getKey().getName() + " owes " + entry.getValue() + " to "+ user.getName());
            }
            else {
                System.out.println(user.getName() + " owes " + Math.abs(entry.getValue()) + " to "+ entry.getKey().getName());
            }
        }
    }

}

