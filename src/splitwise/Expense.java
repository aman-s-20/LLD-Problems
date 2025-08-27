package splitwise;// package splitwise;

import splitwise.Group;
import splitwise.SplitStrategy;
import splitwise.User;

import java.util.Map;

public class Expense {
    private final String description;
    private final double amount;
    private final User paidBy;
    private final Group group;
    private final SplitStrategy splitStrategy;

    // This map will store who owes how much for this specific expense
    private Map<User, Double> splits;

    public Expense(double amount, String description, User paidBy, Group group, SplitStrategy splitStrategy) {
        this.amount = amount;
        this.description = description;
        this.paidBy = paidBy;
        this.group = group;
        this.splitStrategy = splitStrategy;
        calculateSplits(); // Calculate splits upon creation
    }

    private void calculateSplits() {
        this.splits = splitStrategy.calculateSplits(paidBy, amount, group.getMembers());
    }

    // --- Getters ---
    public Map<User, Double> getSplits() {
        return splits;
    }

    public User getPaidBy() {
        return paidBy;
    }
}