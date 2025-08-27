package splitwise;

// package splitwise;

import java.util.Objects;

public class User {
    private static int counter = 0;
    private final int userId;
    private final String name;
    private final String email;
    private final String phone;

    public User(String name, String email, String phone) {
        this.userId = ++counter; // Auto-increment ID
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    // --- Getters ---
    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId);
    }

    @Override
    public String toString() {
        return name; // For easy printing
    }
}
