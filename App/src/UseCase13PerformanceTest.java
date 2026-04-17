import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.Collectors;
import static org.junit.jupiter.api.Assertions.*;

class UseCase13PerformanceTest {

    static class Bogie {
        String type;
        int capacity;

        Bogie(String type, int capacity) {
            this.type = type;
            this.capacity = capacity;
        }
    }

    private List<Bogie> getSampleData() {
        List<Bogie> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add(new Bogie("Type" + i, i % 100));
        }
        return list;
    }

    @Test
    void testLoopFilteringLogic() {
        List<Bogie> list = getSampleData();
        List<Bogie> result = new ArrayList<>();

        for (Bogie b : list) {
            if (b.capacity > 50) {
                result.add(b);
            }
        }

        assertFalse(result.isEmpty());
    }

    @Test
    void testStreamFilteringLogic() {
        List<Bogie> list = getSampleData();

        List<Bogie> result = list.stream()
                .filter(b -> b.capacity > 50)
                .collect(Collectors.toList());

        assertFalse(result.isEmpty());
    }

    @Test
    void testLoopAndStreamResultsMatch() {
        List<Bogie> list = getSampleData();

        List<Bogie> loopResult = new ArrayList<>();
        for (Bogie b : list) {
            if (b.capacity > 50) {
                loopResult.add(b);
            }
        }

        List<Bogie> streamResult = list.stream()
                .filter(b -> b.capacity > 50)
                .collect(Collectors.toList());

        assertEquals(loopResult.size(), streamResult.size());
    }

    @Test
    void testExecutionTimeMeasurement() {
        long start = System.nanoTime();
        long end = System.nanoTime();
        assertTrue(end >= start);
    }

    @Test
    void testLargeDatasetProcessing() {
        List<Bogie> list = getSampleData();
        assertEquals(1000, list.size());
    }
}