import org.junit.jupiter.api.Test;
import java.util.regex.Pattern;
import static org.junit.jupiter.api.Assertions.*;

class UseCase11RegexTest {

    String trainPattern = "TRN-\\d{4}";
    String cargoPattern = "[A-Z]{3}-[A-Z]{2}";

    @Test
    void testRegex_ValidTrainID() {
        assertTrue(Pattern.matches(trainPattern, "TRN-1234"));
    }

    @Test
    void testRegex_InvalidTrainIDFormat() {
        assertFalse(Pattern.matches(trainPattern, "TRN1234"));
    }

    @Test
    void testRegex_ValidCargoCode() {
        assertTrue(Pattern.matches(cargoPattern, "PET-AB"));
    }

    @Test
    void testRegex_InvalidCargoCodeFormat() {
        assertFalse(Pattern.matches(cargoPattern, "pet-ab"));
    }

    @Test
    void testRegex_TrainIDDigitLengthValidation() {
        assertFalse(Pattern.matches(trainPattern, "TRN-123"));
    }

    @Test
    void testRegex_CargoCodeUppercaseValidation() {
        assertFalse(Pattern.matches(cargoPattern, "Pet-Ab"));
    }

    @Test
    void testRegex_EmptyInputHandling() {
        assertFalse(Pattern.matches(trainPattern, ""));
        assertFalse(Pattern.matches(cargoPattern, ""));
    }

    @Test
    void testRegex_ExactPatternMatch() {
        assertFalse(Pattern.matches(trainPattern, "TRN-12345"));
    }
}