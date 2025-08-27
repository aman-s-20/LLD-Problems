package splitwise;

// package splitwise;

import java.util.HashMap;
import java.util.Map;

public class BalanceSheetManager {
    // A owes B -> balanceSheet.get(A).put(B, amount)
    private final Map<User, Map<User, Double>> balanceSheet;

    public BalanceSheetManager() {
        this.balanceSheet = new HashMap<>();
    }

    /**
     * Updates the balance sheet based on a new expense.
     */
    public void updateBalances(Expense expense) {
        User paidBy = expense.getPaidBy();
        Map<User, Double> splits = expense.getSplits();

        for (Map.Entry<User, Double> entry : splits.entrySet()) {
            User personWhoOwes = entry.getKey();
            double amountOwed = entry.getValue();

            // Ensure maps are initialized for both users
            balanceSheet.computeIfAbsent(personWhoOwes, k -> new HashMap<>());
            balanceSheet.computeIfAbsent(paidBy, k -> new HashMap<>());

            // Add the debt: personWhoOwes -> owes -> paidBy
            // We use merge to handle existing debts and simplify them.
            // For example, if A owes B $10, and now A owes B another $5, the new total is $15.
            balanceSheet.get(personWhoOwes).merge(paidBy, amountOwed, Double::sum);

            // Now, handle the opposite direction to simplify debts.
            // If B owes A $20 and A owes B $30, the net is A owes B $10.
            double paidByOwesDebtor = balanceSheet.get(paidBy).getOrDefault(personWhoOwes, 0.0);

            if (paidByOwesDebtor > 0) {
                if (paidByOwesDebtor >= amountOwed) {
                    balanceSheet.get(paidBy).put(personWhoOwes, paidByOwesDebtor - amountOwed);
                    balanceSheet.get(personWhoOwes).remove(paidBy);
                } else {
                    balanceSheet.get(paidBy).remove(personWhoOwes);
                    balanceSheet.get(personWhoOwes).put(paidBy, amountOwed - paidByOwesDebtor);
                }
            }
        }
    }

    /**
     * Prints the current balance sheet for all users.
     */
    public void showBalances() {
        System.out.println("--- Current Balances ---");
        if (balanceSheet.isEmpty()) {
            System.out.println("All settled up!");
            return;
        }

        boolean allSettled = true;
        for (Map.Entry<User, Map<User, Double>> entry : balanceSheet.entrySet()) {
            User userA = entry.getKey();
            for (Map.Entry<User, Double> debt : entry.getValue().entrySet()) {
                User userB = debt.getKey();
                double amount = debt.getValue();
                if (amount > 0) {
                    allSettled = false;
                    System.out.printf("%s owes %s: $%.2f%n", userA.getName(), userB.getName(), amount);
                }
            }
        }

        if (allSettled) {
            System.out.println("All settled up!");
        }
        System.out.println("------------------------");
    }
}