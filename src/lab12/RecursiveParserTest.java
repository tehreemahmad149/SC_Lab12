package lab12;

import static org.junit.Assert.*;

import org.junit.Test;
public class RecursiveParserTest {

    @Test
    public void testSimpleAddition() {
        assertEquals(8.0, RecursiveParser.evaluateExpression("3 + 5"), 0.0001);
    }

    @Test
    public void testMixedOperators() {
        assertEquals(13.0, RecursiveParser.evaluateExpression("3 + 5 * 2"), 0.0001);
    }

    @Test
    public void testParenthesesPrecedence() {
        assertEquals(16.0, RecursiveParser.evaluateExpression("(3 + 5) * 2"), 0.0001);
    }

    @Test
    public void testFloatingPointNumbers() {
        assertEquals(8.05, RecursiveParser.evaluateExpression("3.5 + 4.55"), 0.0001);
    }

    @Test
    public void testDivisionByZero() {
        Exception exception = assertThrows(ArithmeticException.class, () ->
            RecursiveParser.evaluateExpression("42 / (6 - 6)")
        );
        assertEquals("Division by zero.", exception.getMessage());
    }

    @Test
    public void testInvalidExpression() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
            RecursiveParser.evaluateExpression("3 + * 5")
        );
        assertEquals("Invalid character in expression.", exception.getMessage());
    }

    @Test
    public void testMismatchedParentheses() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
            RecursiveParser.evaluateExpression("(3 + 5")
        );
        assertEquals("Mismatched parentheses in expression.", exception.getMessage());
    }

    @Test
    public void testEmptyExpression() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
            RecursiveParser.evaluateExpression("")
        );
        assertEquals("Expression cannot be null or empty.", exception.getMessage());
    }
}
