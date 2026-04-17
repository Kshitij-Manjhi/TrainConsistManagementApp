import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class UseCase17SortTest {

    private String[] sort(String[] arr) {
        String[] copy = arr.clone();
        Arrays.sort(copy);
        return copy;
    }

    @Test
    void testSort_BasicAlphabeticalSorting() {
        String[] arr = {"Sleeper", "AC Chair", "First Class"};
        String[] sorted = sort(arr);

        assertArrayEquals(
                new String[]{"AC Chair", "First Class", "Sleeper"},
                sorted
        );
    }

    @Test
    void testSort_UnsortedInput() {
        String[] arr = {"Luxury", "General", "AC Chair"};
        String[] sorted = sort(arr);

        assertArrayEquals(
                new String[]{"AC Chair", "General", "Luxury"},
                sorted
        );
    }

    @Test
    void testSort_AlreadySortedArray() {
        String[] arr = {"A", "B", "C"};
        String[] sorted = sort(arr);

        assertArrayEquals(new String[]{"A", "B", "C"}, sorted);
    }

    @Test
    void testSort_DuplicateBogieNames() {
        String[] arr = {"Sleeper", "Sleeper", "AC"};
        String[] sorted = sort(arr);

        assertArrayEquals(
                new String[]{"AC", "Sleeper", "Sleeper"},
                sorted
        );
    }

    @Test
    void testSort_SingleElementArray() {
        String[] arr = {"Only"};
        String[] sorted = sort(arr);

        assertArrayEquals(new String[]{"Only"}, sorted);
    }
}