package splitwise;

// package splitwise;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EqualSplitStrategy implements SplitStrategy {

    @Override
    public Map<User, Double> calculateSplits(User paidBy, double amount, List<User> members) {
        Map<User, Double> splits = new HashMap<>();
        if (members.isEmpty()) {
            return splits;
        }

        int totalMembers = members.size();
        double amountPerPerson = amount / totalMembers;

        for (User member : members) {
            // Everyone owes an equal share, except the person who paid.
            if (!member.equals(paidBy)) {
                splits.put(member, amountPerPerson);
            }
        }
        return splits;
    }
}