package AlexaValidator;

import java.util.List;
import java.util.Optional;

public interface ValidationRule {
    Optional<Violation> validate(List<String> tokens);
    String id();
    String description();
}