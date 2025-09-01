package AlexaValidator;

import java.util.List;

final class ValidationResult {
    private final boolean valid;
    private final List<Violation> violations;

    public ValidationResult(List<Violation> violations) {
        this.violations = List.copyOf(violations);
        this.valid = violations.isEmpty();
    }

    public boolean isValid() { return valid; }
    public List<Violation> getViolations() { return violations; }

    @Override
    public String toString() {
        return valid ? "VALID ✅" : "INVALID ❌ Violations=" + violations;
    }
}
