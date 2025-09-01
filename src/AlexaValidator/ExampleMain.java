package AlexaValidator;

import java.util.List;

public class ExampleMain {
    public static void main(String[] args) {
        List<ValidationRule> rules = List.of(
                new WakeWordRule(),
                new SecondWordVerbRule(),
                new NoConsecutiveDuplicateRule(),
                new MaxOccurrencesRule(2)
        );

        RuleEngine engine = new RuleEngine(rules);

        test(engine, "Alexa play music");
        test(engine, "Alexa music play");     // wrong 2nd word
        test(engine, "Hey Alexa play");       // wrong 1st word
        test(engine, "Alexa play play music");// consecutive dup
        test(engine, "Alexa play play play"); // >2 times
    }

    private static void test(RuleEngine engine, String cmd) {
        System.out.println("----");
        System.out.println("Command: " + cmd);
        System.out.println(engine.validate(cmd));
    }
}