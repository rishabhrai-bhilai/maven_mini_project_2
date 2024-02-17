import org.example.Main;
import org.junit.Test;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    @Test
    public void testAddition() {
        assertEquals(8.0, performOperation(5, 3, 1));
    }

    @Test
    public void testSubtraction() {
        assertEquals(2.0, performOperation(5, 3, 2));
    }

    @Test
    public void testMultiplication() {
        assertEquals(15.0, performOperation(5, 3, 3));
    }

    @Test
    public void testDivision() {
        assertEquals(2.0, performOperation(6, 3, 4));
    }

    @Test
    public void testDivisionByZero() {
        assertEquals(Double.NaN, performOperation(5, 0, 4));
    }

    @Test
    public void testInvalidChoice() {
        assertEquals(Double.NaN, performOperation(5, 3, 5));
    }

    private double performOperation(double num1, double num2, int choice) {
        // Redirect System.in to provide predefined input for testing
        String input = String.format("%f%n%f%n%d%n", num1, num2, choice);
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Capture System.out to check the printed result
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Run the main method
        Main.main(new String[]{});

        // Restore System.in and System.out
        System.setIn(System.in);
        System.setOut(System.out);

        // Parse and return the printed result
        return Double.parseDouble(outputStream.toString().trim().split(":")[1].trim());
    }
}
