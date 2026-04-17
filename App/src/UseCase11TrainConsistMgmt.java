import java.util.Scanner;
import java.util.regex.Pattern;

/*
 * ============================================================
 * MAIN CLASS - UseCase11TrainConsistMgmt
 * ============================================================
 *
 * Use Case 11: Validate Train ID and Cargo Code
 *
 * Description:
 * This class validates input formats using Regular Expressions.
 *
 * This maps format validation logic using Pattern matching.
 *
 * @author Developer
 * @version 11.0
 */

public class UseCase11TrainConsistMgmt {

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println(" UC11 - Validate Train ID and Cargo Code ");
        System.out.println("========================================\n");

        Scanner scanner = new Scanner(System.in);

        // ===== INPUT =====
        System.out.print("Enter Train ID (Format: TRN-1234): ");
        String trainId = scanner.nextLine();

        System.out.print("Enter Cargo Code (Format: PET-AB): ");
        String cargoCode = scanner.nextLine();

        // ===== REGEX RULES =====
        String trainPattern = "TRN-\\d{4}";
        String cargoPattern = "[A-Z]{3}-[A-Z]{2}";

        // ===== VALIDATION =====
        boolean isTrainValid = Pattern.matches(trainPattern, trainId);
        boolean isCargoValid = Pattern.matches(cargoPattern, cargoCode);

        // ===== OUTPUT =====
        System.out.println("\nValidation Results:");
        System.out.println("Train ID Valid: " + isTrainValid);
        System.out.println("Cargo Code Valid: " + isCargoValid);

        System.out.println("\nUC11 validation completed...");

        scanner.close();
    }
}