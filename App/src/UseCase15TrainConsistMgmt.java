import java.util.ArrayList;
import java.util.List;

/*
 * ============================================================
 * MAIN CLASS - UseCase15TrainConsistMgmt
 * ============================================================
 *
 * Use Case 15: Safe Cargo Assignment Using try-catch-finally
 *
 * Description:
 * This class safely assigns cargo to goods bogies while
 * handling unsafe combinations using structured exception handling.
 *
 * This maps runtime safety handling using try-catch-finally.
 *
 * @author Developer
 * @version 15.0
 */

public class UseCase15TrainConsistMgmt {

    // ===== CUSTOM RUNTIME EXCEPTION =====
    static class CargoSafetyException extends RuntimeException {
        public CargoSafetyException(String message) {
            super(message);
        }
    }

    // ===== Goods Bogie Model =====
    static class GoodsBogie {
        String shape;
        String cargo;

        GoodsBogie(String shape) {
            this.shape = shape;
        }

        // Assign cargo with validation
        void assignCargo(String cargo) {
            try {
                // RULE: Rectangular bogie cannot carry Petroleum
                if (shape.equals("Rectangular") && cargo.equals("Petroleum")) {
                    throw new CargoSafetyException("Unsafe cargo assignment!");
                }

                this.cargo = cargo;
                System.out.println("Cargo assigned successfully -> " + cargo);

            } catch (CargoSafetyException e) {
                System.out.println("Error: " + e.getMessage());

            } finally {
                System.out.println("Cargo validation completed for " + shape + " bogie");
            }
        }
    }

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println(" UC15 - Safe Cargo Assignment ");
        System.out.println("========================================\n");

        List<GoodsBogie> bogies = new ArrayList<>();

        GoodsBogie b1 = new GoodsBogie("Cylindrical");
        GoodsBogie b2 = new GoodsBogie("Rectangular");

        bogies.add(b1);
        bogies.add(b2);

        // Safe assignment
        b1.assignCargo("Petroleum");

        // Unsafe assignment (will trigger exception)
        b2.assignCargo("Petroleum");

        System.out.println("\nUC15 runtime handling completed...");
    }
}