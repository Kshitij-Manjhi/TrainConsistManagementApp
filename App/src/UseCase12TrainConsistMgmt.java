import java.util.ArrayList;
import java.util.List;

/*
 * ============================================================
 * MAIN CLASS - UseCase12TrainConsistMgmt
 * ============================================================
 *
 * Use Case 12: Safety Compliance Check for Goods Bogies
 *
 * Description:
 * This class enforces domain safety rules on goods bogies
 * using Java Stream API and allMatch().
 *
 * This maps real-world cargo safety validation using Streams.
 *
 * @author Developer
 * @version 12.0
 */

public class UseCase12TrainConsistMgmt {

    // ===== Goods Bogie Model =====
    static class GoodsBogie {
        String type;
        String cargo;

        GoodsBogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }
    }

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println(" UC12 - Safety Compliance Check for Goods Bogies ");
        System.out.println("========================================\n");

        // Create goods bogie list
        List<GoodsBogie> goodsBogies = new ArrayList<>();

        goodsBogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goodsBogies.add(new GoodsBogie("Open", "Coal"));
        goodsBogies.add(new GoodsBogie("Box", "Grain"));
        goodsBogies.add(new GoodsBogie("Cylindrical", "Coal")); // violation

        // ===== DISPLAY =====
        System.out.println("Goods Bogies in Train:");
        for (GoodsBogie g : goodsBogies) {
            System.out.println(g.type + " -> " + g.cargo);
        }

        // ===== SAFETY RULE =====
        // Cylindrical bogies should carry only Petroleum
        boolean isSafe = goodsBogies.stream()
                .allMatch(g ->
                        !g.type.equals("Cylindrical") ||
                        g.cargo.equals("Petroleum")
                );

        // ===== RESULT =====
        System.out.println("\nSafety Compliance Status: " + isSafe);

        if (isSafe) {
            System.out.println("Train formation is SAFE.");
        } else {
            System.out.println("Train formation is NOT SAFE.");
        }

        System.out.println("\nUC12 safety validation completed...");
    }
}