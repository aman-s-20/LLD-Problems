package splitwise;

// package splitwise;

import java.util.List;

public class Group {
    private int groupId;
    private String name;
    private final List<User> members;

    public Group(String name, List<User> users) {
        this.name = name;
        this.members = users;
    }

    public List<User> getMembers() {
        return members;
    }
}