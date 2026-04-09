import java.util.ArrayList;
import java.util.List;

/**
 * ================================================================
 * MAIN CLASS - UseCase2TrainConsistMgmt
 * ================================================================
 *
 * Use Case 2: Add Passenger Bogies to Train
 *
 * Description:
 * This class demonstrates how passenger bogies can be
 * managed dynamically using ArrayList operations.
 *
 * At this stage, the application:
 * - Adds new bogies to the train
 * - Removes existing bogies
 * - Checks for bogie availability
 * - Displays the final consist
 *
 * This maps CRUD operations using ArrayList.
 *
 * @author Developer
 * @version 2.0
 */
public class UseCase2TrainConsistMgmt {

    public static void main(String[] args) {

        // Display welcome banner
        System.out.println("=======================================");
        System.out.println(" UC2 - Add Passenger Bogies to Train ");
        System.out.println("=======================================\n");

        // Create an ArrayList to hold passenger bogies
        List<String> passengerBogies = new ArrayList<>();

        // ---- CREATE (add bogies) ----
        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");

        System.out.println("After Adding Bogies:");
        System.out.println("Passenger Bogies : " + passengerBogies + "\n");

        // ===== DELETE (Remove bogie) =====
        passengerBogies.remove("AC Chair");

        System.out.println("After Removing 'AC Chair':");
        System.out.println("Passenger Bogies : " + passengerBogies + "\n");

        // ===== READ (Check availability) =====
        System.out.println("Checking if 'Sleeper' exists:");
        boolean exists = passengerBogies.contains("Sleeper");
        System.out.println("Contains Sleeper? : " + exists + "\n");

        // ===== FINAL OUTPUT =====
        System.out.println("Final Train Passenger Consist:");
        System.out.println(passengerBogies);

        System.out.println("\nUC2 operations completed successfully...");
    }
}