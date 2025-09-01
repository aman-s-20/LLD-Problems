package AlexaValidator;

import java.util.List;
import java.util.Optional;

// Rule 1: First word must be "Alexa"
class WakeWordRule implements ValidationRule {

    @Override public String id() { return "R_WAKE_WORD"; }
    @Override public String description() { return "First word must be Alexa"; }

    @Override
    public Optional<Violation> validate(List<String> tokens) {
        if (tokens.isEmpty() || !"alexa".equalsIgnoreCase(tokens.get(0))) {
            return Optional.of(new Violation(id(),
                    "First word must be 'Alexa'",
                    tokens.isEmpty() ? List.of() : List.of(tokens.get(0))));
        }
        return Optional.empty();
    }
}