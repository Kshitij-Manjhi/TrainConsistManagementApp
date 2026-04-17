import java.util.Arrays;

/*
 * ============================================================
 * MAIN CLASS - UseCase19TrainConsistMgmt
 * ============================================================
 *
 * Use Case 19: Binary Search for Bogie ID
 *
 * Description:
 * This class demonstrates searching for a specific bogie ID
 * using the Binary Search algorithm on sorted data.
 *
 * This maps optimized searching logic using divide-and-conquer.
 *
 * @author Developer
 * @version 19.0
 */

public class UseCase19TrainConsistMgmt {

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println(" UC19 - Binary Search for Bogie ID ");
        System.out.println("========================================\n");

        // Create sorted array of bogie IDs
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        // Ensure array is sorted (important for binary search)
        Arrays.sort(bogieIds);

        // Search key
        String key = "BG309";

        // Display bogies
        System.out.println("Sorted Bogie IDs:");
        for (String id : bogieIds) {
            System.out.println(id);
        }

        // ===== BINARY SEARCH =====
        int left = 0;
        int right = bogieIds.length - 1;
        boolean found = false;

        while (left <= right) {
            int mid = (left + right) / 2;

            int comparison = bogieIds[mid].compareTo(key);

            if (comparison == 0) {
                found = true;
                break;
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // Display result
        if (found) {
            System.out.println("\nBogie " + key + " found using Binary Search.");
        } else {
            System.out.println("\nBogie " + key + " NOT found.");
        }

        System.out.println("\nUC19 search completed...");
    }
}