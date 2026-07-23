public class Observation {

    String plateNumber;
    String date;
    String carType;
    int speed;
    boolean seatbeltFastened;

    public Observation(
            String plateNumber,
            String date,
            String carType,
            int speed,
            boolean seatbeltFastened
    ) {
        this.plateNumber = plateNumber;
        this.date = date;
        this.carType = carType;
        this.speed = speed;
        this.seatbeltFastened = seatbeltFastened;
    }
}