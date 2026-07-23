public class SpeedRule implements Rule {
    private final String carType;
    private final int maxSpeed;

    public SpeedRule(String carType, int maxSpeed) {
        this.carType = carType;
        this.maxSpeed = maxSpeed;
    }
    @Override
    public Violation check(Observation observation) {
        if (observation.carType.equalsIgnoreCase(carType)
                && observation.speed > maxSpeed) {

            return new Violation(
                    "speed of " + observation.speed
                            + " exceeded max allowed " + maxSpeed,
                    300
            );
        }
        return null;
    }

    @Override
    public String getName() {
        return carType + " speed rule";
    }
}