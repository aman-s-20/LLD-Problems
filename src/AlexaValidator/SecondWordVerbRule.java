package AlexaValidator;

import java.util.List;
import java.util.Optional;
import java.util.Set;

// Rule 2: Second word must be a verb (very naive check for now)
class SecondWordVerbRule implements ValidationRule {
    private static final Set<String> VERBS = Set.of("play", "start", "stop", "open", "close", "run");

    @Override public String id() { return "R_SECOND_VERB"; }
    @Override public String description() { return "Second word must be a verb"; }

    @Override
    public Optional<Violation> validate(List<String> tokens) {
        if (tokens.size() < 2) {
            return Optional.of(new Violation(id(),
                    "Command too short, second word missing",
                    tokens));
        }
        String second = tokens.get(1).toLowerCase();
        if (!VERBS.contains(second)) {
            return Optional.of(new Violation(id(),
                    "Second word must be a verb",
                    List.of(tokens.get(1))));
        }
        return Optional.empty();
    }
}