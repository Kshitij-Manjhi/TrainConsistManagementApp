import java.util.LinkedList;
import java.util.List;

/*
 * ============================================================
 * MAIN CLASS - UseCase4TrainConsistMgmt
 * ============================================================
 *
 * Use Case 4: Maintain Ordered Bogie Consist
 *
 * Description:
 * This class models the physical chaining of train bogies
 * using LinkedList for ordered operations.
 *
 * At this stage, the application:
 * - Adds bogies in sequence
 * - Inserts bogies at specific positions
 * - Removes bogies from front and rear
 * - Displays updated train structure
 *
 * This maps positional operations using LinkedList.
 *
 * @author Developer
 * @version 4.0
 */

public class UseCase4TrainConsistMgmt {

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println(" UC4 - Maintain Ordered Bogie Consist ");
        System.out.println("========================================\n");

        // Create a LinkedList to maintain order
        // LinkedList allows fast insertion/removal
        List<String> trainConsist = new LinkedList<>();

        // ===== ADD (Initial sequence) =====
        trainConsist.add("Engine");
        trainConsist.add("Sleeper");
        trainConsist.add("AC");
        trainConsist.add("Cargo");
        trainConsist.add("Guard");

        System.out.println("Initial Train Consist:");
        System.out.println(trainConsist + "\n");

        // ===== INSERT at specific position =====
        trainConsist.add(2, "Pantry Car");

        System.out.println("After Inserting 'Pantry Car' at position 2:");
        System.out.println(trainConsist + "\n");

        // ===== REMOVE from front and rear =====
        trainConsist.remove(0); // remove first (Engine)
        trainConsist.remove(trainConsist.size() - 1); // remove last (Guard)

        System.out.println("After Removing First and Last Bogie:");
        System.out.println(trainConsist + "\n");

        System.out.println("UC4 ordered consist operations completed...");
    }
}