import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UseCase16SortTest {

    private int[] bubbleSort(int[] arr) {
        int[] copy = arr.clone();

        for (int i = 0; i < copy.length - 1; i++) {
            for (int j = 0; j < copy.length - i - 1; j++) {
                if (copy[j] > copy[j + 1]) {
                    int temp = copy[j];
                    copy[j] = copy[j + 1];
                    copy[j + 1] = temp;
                }
            }
        }
        return copy;
    }

    @Test
    void testSort_BasicSorting() {
        int[] arr = {72, 56, 24, 70, 60};
        int[] sorted = bubbleSort(arr);
        assertArrayEquals(new int[]{24, 56, 60, 70, 72}, sorted);
    }

    @Test
    void testSort_AlreadySortedArray() {
        int[] arr = {10, 20, 30};
        int[] sorted = bubbleSort(arr);
        assertArrayEquals(new int[]{10, 20, 30}, sorted);
    }

    @Test
    void testSort_DuplicateValues() {
        int[] arr = {5, 3, 5, 2};
        int[] sorted = bubbleSort(arr);
        assertArrayEquals(new int[]{2, 3, 5, 5}, sorted);
    }

    @Test
    void testSort_SingleElementArray() {
        int[] arr = {1};
        int[] sorted = bubbleSort(arr);
        assertArrayEquals(new int[]{1}, sorted);
    }

    @Test
    void testSort_AllEqualValues() {
        int[] arr = {7, 7, 7};
        int[] sorted = bubbleSort(arr);
        assertArrayEquals(new int[]{7, 7, 7}, sorted);
    }
}
