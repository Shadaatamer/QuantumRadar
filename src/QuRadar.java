import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuRadar {
    private final List<Rule> rules = new ArrayList<>();
    private final List<Fine> fines = new ArrayList<>();
    private final Map<String, Integer> violationCounts = new HashMap<>();

    public void addRule(Rule rule) {
        rules.add(rule);
        violationCounts.put(rule.getName(), 0);
    }

    public void observe(Observation observation) {
        List<Violation> violations = new ArrayList<>();

        for (Rule rule : rules) {
            Violation violation = rule.check(observation);

            if (violation != null) {
                violations.add(violation);

                violationCounts.put(
                        rule.getName(),
                        violationCounts.get(rule.getName()) + 1
                );
            }
        }

        if (!violations.isEmpty()) {
            Fine fine = new Fine(
                    observation.plateNumber,
                    violations
            );

            fines.add(fine);
            fine.print();
        }
    }

    public void getAllPossibleFines() {
        for (Fine fine : fines) {
            System.out.println(
                    fine.plateNumber
                            + " - "
                            + fine.getTotalAmount()
                            + " EGP"
            );
        }
    }

    public void getAllViolatedRules() {
        for (Map.Entry<String, Integer> entry
                : violationCounts.entrySet()) {

            System.out.println(
                    entry.getKey()
                            + ": "
                            + entry.getValue()
            );
        }
    }
}