package splitwise;

// package splitwise;

import java.util.List;
import java.util.Map;

public interface SplitStrategy {
    /**
     * Calculates how the expense should be split among users.
     * @param paidBy The user who paid the total amount.
     * @param amount The total amount paid.
     * @param members The list of users involved in the expense.
     * @return A map where the key is the user who owes money and the value is the amount they owe.
     */
    Map<User, Double> calculateSplits(User paidBy, double amount, List<User> members);
}