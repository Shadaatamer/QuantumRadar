import java.util.List;

public class Fine {
    String plateNumber;
    List<Violation> violations;

    public Fine(String plateNumber, List<Violation> violations) {
        this.plateNumber = plateNumber;
        this.violations = violations;
    }
    public int getTotalAmount() {
        int total = 0;
        for (Violation violation : violations) {
            total += violation.fee;
        }
        return total;
    }
    public void print() {
        System.out.println("Traffic fine for car " + plateNumber);
        System.out.println("Total amount: " + getTotalAmount() + " EGP");
        System.out.println("Violations:");
        for (Violation violation : violations) {
            System.out.println( " - " + violation.description + " : " + violation.fee + " EGP");
        }
        System.out.println();
    }
}