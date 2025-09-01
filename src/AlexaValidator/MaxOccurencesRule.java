package AlexaValidator;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

// Rule 4: No word appears more than twice
class MaxOccurrencesRule implements ValidationRule {
    private final int max;

    public MaxOccurrencesRule(int max) { this.max = max; }

    @Override public String id() { return "R_MAX_OCCURRENCE"; }
    @Override public String description() { return "No word appears more than " + max + " times"; }

    @Override
    public Optional<Violation> validate(List<String> tokens) {
        Map<String, Long> freq = tokens.stream()
                .collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()));

        for (var e : freq.entrySet()) {
            if (e.getValue() > max) {
                return Optional.of(new Violation(id(),
                        "Word '" + e.getKey() + "' appears more than " + max + " times",
                        List.of(e.getKey())));
            }
        }
        return Optional.empty();
    }
}
