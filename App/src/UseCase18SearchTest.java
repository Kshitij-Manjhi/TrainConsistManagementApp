import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UseCase18SearchTest {

    private boolean linearSearch(String[] arr, String key) {
        for (String s : arr) {
            if (s.equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Test
    void testSearch_BogieFound() {
        String[] arr = {"BG101", "BG205", "BG309"};
        assertTrue(linearSearch(arr, "BG309"));
    }

    @Test
    void testSearch_BogieNotFound() {
        String[] arr = {"BG101", "BG205", "BG309"};
        assertFalse(linearSearch(arr, "BG999"));
    }

    @Test
    void testSearch_FirstElementMatch() {
        String[] arr = {"BG101", "BG205"};
        assertTrue(linearSearch(arr, "BG101"));
    }

    @Test
    void testSearch_LastElementMatch() {
        String[] arr = {"BG101", "BG205", "BG309"};
        assertTrue(linearSearch(arr, "BG309"));
    }

    @Test
    void testSearch_SingleElementArray() {
        String[] arr = {"BG101"};
        assertTrue(linearSearch(arr, "BG101"));
    }
}