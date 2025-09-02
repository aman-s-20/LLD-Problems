package AlexaValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Rule Engine
 */
class RuleEngine {
    private final List<ValidationRule> rules;

    public RuleEngine(List<ValidationRule> rules) {
        this.rules = List.copyOf(rules);
    }

    public ValidationResult validate(String command) {
        List<String> tokens = Arrays.asList(command.trim().split("\\s+"));
        List<Violation> violations = new ArrayList<>();

        for (ValidationRule rule : rules) {
            if(rule.validate(tokens).isPresent()) {
                violations.add(rule.validate(tokens).get());
            }
        }
        return new ValidationResult(violations);
    }
}