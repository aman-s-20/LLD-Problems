package AlexaValidator;

import java.util.List;
import java.util.Optional;

// Rule 3: No consecutive duplicates
class NoConsecutiveDuplicateRule implements ValidationRule {
    @Override public String id() { return "R_NO_CONSECUTIVE_DUP"; }
    @Override public String description() { return "No word repeated consecutively"; }

    @Override
    public Optional<Violation> validate(List<String> tokens) {
        for (int i = 1; i < tokens.size(); i++) {
            if (tokens.get(i).equalsIgnoreCase(tokens.get(i-1))) {
                return Optional.of(new Violation(id(),
                        "Word repeated consecutively",
                        List.of(tokens.get(i-1), tokens.get(i))));
            }
        }
        return Optional.empty();
    }
}
