public class SeatbeltRule implements Rule {
    @Override
    public Violation check(Observation observation) {
        if (!observation.seatbeltFastened) {
            return new Violation(
                    "Seatbelt not fastened",
                    100
            );
        }
        return null;
    }
    @Override
    public String getName() {
        return "Seatbelt rule";
    }
}