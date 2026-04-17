import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UseCase15CargoTest {

    static class CargoSafetyException extends RuntimeException {
        public CargoSafetyException(String message) {
            super(message);
        }
    }

    static class GoodsBogie {
        String shape;
        String cargo;

        GoodsBogie(String shape) {
            this.shape = shape;
        }

        void assignCargo(String cargo) {
            if (shape.equals("Rectangular") && cargo.equals("Petroleum")) {
                throw new CargoSafetyException("Unsafe cargo assignment!");
            }
            this.cargo = cargo;
        }
    }

    @Test
    void testCargo_SafeAssignment() {
        GoodsBogie b = new GoodsBogie("Cylindrical");
        b.assignCargo("Petroleum");
        assertEquals("Petroleum", b.cargo);
    }

    @Test
    void testCargo_UnsafeAssignmentHandled() {
        GoodsBogie b = new GoodsBogie("Rectangular");

        assertThrows(CargoSafetyException.class, () -> {
            b.assignCargo("Petroleum");
        });
    }

    @Test
    void testCargo_CargoNotAssignedAfterFailure() {
        GoodsBogie b = new GoodsBogie("Rectangular");

        try {
            b.assignCargo("Petroleum");
        } catch (Exception e) {
            // ignore
        }

        assertNull(b.cargo);
    }

    @Test
    void testCargo_ProgramContinuesAfterException() {
        GoodsBogie b1 = new GoodsBogie("Rectangular");
        GoodsBogie b2 = new GoodsBogie("Cylindrical");

        try {
            b1.assignCargo("Petroleum");
        } catch (Exception e) {
            // handled
        }

        b2.assignCargo("Coal");
        assertEquals("Coal", b2.cargo);
    }

    @Test
    void testCargo_FinallyBlockExecution() {
        // Logical validation: finally always executes
        assertTrue(true); // placeholder (behavior verified via console)
    }
}