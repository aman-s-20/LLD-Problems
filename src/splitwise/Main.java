package splitwise;

// package splitwise;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1. Setup Users
        User user1 = new User("Aman", "aman@example.com", "111");
        User user2 = new User("Rahul", "rahul@example.com", "222");
        User user3 = new User("Priya", "priya@example.com", "333");
        User user4 = new User("Sneha", "sneha@example.com", "444");

        List<User> groupMembers = List.of(user1, user2, user3, user4);

        // 2. Setup Group
        Group tripToGoa = new Group("Trip to Goa", groupMembers);

        // 3. Create a Balance Sheet Manager
        BalanceSheetManager balanceManager = new BalanceSheetManager();

        // 4. Create and process expenses
        System.out.println("Initial State:");
        balanceManager.showBalances(); // Should be empty

        // Expense 1: Aman pays 1000 for dinner for everyone.
        System.out.println("\nAdding Expense 1: Aman paid $1000 for dinner.");
        Expense dinner = new Expense(1000, "Dinner", user1, tripToGoa, new EqualSplitStrategy());
        balanceManager.updateBalances(dinner);
        balanceManager.showBalances();

        // Expense 2: Priya pays 400 for movie tickets for everyone.
        System.out.println("\nAdding Expense 2: Priya paid $400 for tickets.");
        Expense tickets = new Expense(400, "Movie Tickets", user3, tripToGoa, new EqualSplitStrategy());
        balanceManager.updateBalances(tickets);
        balanceManager.showBalances();
    }
}