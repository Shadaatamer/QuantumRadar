public class Main {
    public static void main(String[] args) {

        QuRadar radar = new QuRadar();

        radar.addRule(new SeatbeltRule());
        radar.addRule(new SpeedRule("Truck", 60));
        radar.addRule(new SpeedRule("Private", 80));

        Observation firstObservation = new Observation(
                "ABC1234",
                "23-07-2026",
                "Private",
                94,
                false
        );

        Observation secondObservation = new Observation(
                "TRK5678",
                "23-07-2026",
                "Truck",
                70,
                true
        );

        Observation thirdObservation = new Observation(
                "CAR9999",
                "23-07-2026",
                "Private",
                70,
                true
        );

        radar.observe(firstObservation);
        radar.observe(secondObservation);
        radar.observe(thirdObservation);

        System.out.println("\nAll fines:");
        radar.getAllPossibleFines();

        System.out.println("\nViolated rules count:");
        radar.getAllViolatedRules();
    }
}