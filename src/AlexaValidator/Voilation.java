package AlexaValidator;

import java.util.List;

final class Violation {
    private final String ruleId;
    private final String message;
    private final List<String> involvedWords;

    public Violation(String ruleId, String message, List<String> involvedWords) {
        this.ruleId = ruleId;
        this.message = message;
        this.involvedWords = involvedWords == null ? List.of() : List.copyOf(involvedWords);
    }

    public String getRuleId() { return ruleId; }
    public String getMessage() { return message; }
    public List<String> getInvolvedWords() { return involvedWords; }

    @Override
    public String toString() {
        return "Violation[" + ruleId + "]: " + message + " words=" + involvedWords;
    }
}
