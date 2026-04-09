import java.util.HashSet;
import java.util.Set;

/*
 * ============================================================
 * MAIN CLASS - UseCase3TrainConsistMgmnt
 * ============================================================
 *
 * Use Case 3: Track Unique Bogie IDs
 *
 * Description:
 * This class demonstrates how unique bogie identifiers
 * can be maintained using a Set.
 *
 * At this stage, the application:
 * - Adds bogie IDs (including duplicates)
 * - Automatically removes duplicates
 * - Displays only unique bogie IDs
 *
 * This maps uniqueness validation using Set.
 *
 * @author Developer
 * @version 3.0
 */

public class UseCase3UniqueBogieIDs {

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println(" UC3 - Track Unique Bogie IDs ");
        System.out.println("========================================\n");

        // Create a Set to store unique bogie IDs
        // HashSet stores only unique values
        Set<String> bogies = new HashSet<>();

        // ===== ADD IDs (including duplicates) =====
        bogies.add("BG101");
        bogies.add("BG102");
        bogies.add("BG103");
        bogies.add("BG101"); // duplicate
        bogies.add("BG102"); // duplicate

        System.out.println("After Adding Bogie IDs (with duplicates):");
        System.out.println("Bogie IDs : " + bogies + "\n");

        // ===== CHECK uniqueness =====
        System.out.println("Checking if 'BG101' exists:");
        boolean exists = bogies.contains("BG101");
        System.out.println("Contains BG101? : " + exists + "\n");

        // ===== FINAL OUTPUT =====
        System.out.println("Final Unique Bogie IDs:");
        System.out.println(bogies);

        System.out.println("\nUC3 operations completed successfully...");
    }
}