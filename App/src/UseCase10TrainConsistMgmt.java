import java.util.ArrayList;
import java.util.List;

/*
 * ============================================================
 * MAIN CLASS - UseCase10TrainConsistMgmt
 * ============================================================
 *
 * Use Case 10: Count Total Seats in Train
 *
 * Description:
 * This class aggregates seating capacity of all bogies
 * into a single total using Stream reduce().
 *
 * This maps aggregation logic using reduce().
 *
 * @author Developer
 * @version 10.0
 */

public class UseCase10TrainConsistMgmt {

    // ===== Reusing Bogie model =====
    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
    }

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println(" UC10 - Count Total Seats in Train ");
        System.out.println("========================================\n");

        // Create list of bogies
        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("Sleeper", 70));

        // ===== DISPLAY BOGIES =====
        System.out.println("Bogies in Train:");
        for (Bogie b : bogies) {
            System.out.println(b.name + " -> " + b.capacity);
        }

        // ===== AGGREGATE USING STREAM REDUCE =====
        int totalCapacity = bogies.stream()
                .map(b -> b.capacity)          // extract capacity
                .reduce(0, Integer::sum);     // sum all values

        // ===== DISPLAY RESULT =====
        System.out.println("\nTotal Seating Capacity of Train: " + totalCapacity);

        System.out.println("\nUC10 aggregation completed...");
    }
}