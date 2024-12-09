package lab12;

public class RecursiveParser {
	//improvement of lab11

    /**
     * Evaluates a mathematical expression represented as a string.
     *
     * @param expression The mathematical expression to evaluate.
     * @return The result of the evaluated expression.
     * @throws IllegalArgumentException if the expression is invalid.
     */
    public static double evaluateExpression(String expression) {
        if (expression == null || expression.isEmpty()) {
            throw new IllegalArgumentException("Expression cannot be null or empty.");
        }
        return parseExpression(expression.replaceAll("\\s+", ""), 0).result;
    }
    
    private static class ParseResult {
        double result;
        int nextIndex;

        ParseResult(double result, int nextIndex) {
            this.result = result;
            this.nextIndex = nextIndex;
        }
    }

    /**
     * Parses and evaluates an expression with addition and subtraction.
     *
     * @param expression The mathematical expression to parse.
     * @param index The current index to parse from.
     * @return The result of the parsed expression and the next index.
     */
    private static ParseResult parseExpression(String expression, int index) {
        ParseResult current = parseTerm(expression, index);

        while (current.nextIndex < expression.length()) {
            char operator = expression.charAt(current.nextIndex);

            if (operator == '+' || operator == '-') {
                ParseResult next = parseTerm(expression, current.nextIndex + 1);
                current.result = (operator == '+') ? current.result + next.result : current.result - next.result;
                current.nextIndex = next.nextIndex;
            } else {
                break;
            }
        }

        return current;
    }

    /**
     * Parses and evaluates a term with multiplication and division.
     *
     * @param expression The mathematical expression to parse.
     * @param index The current index to parse from.
     * @return The result of the parsed term and the next index.
     */
    private static ParseResult parseTerm(String expression, int index) {
        ParseResult current = parseFactor(expression, index);

        while (current.nextIndex < expression.length()) {
            char operator = expression.charAt(current.nextIndex);

            if (operator == '*' || operator == '/') {
                ParseResult next = parseFactor(expression, current.nextIndex + 1);
                if (operator == '*') {
                    current.result *= next.result;
                } else {
                    if (next.result == 0) {
                        throw new ArithmeticException("Division by zero.");
                    }
                    current.result /= next.result;
                }
                current.nextIndex = next.nextIndex;
            } else {
                break;
            }
        }

        return current;
    }

    /**
     * Parses and evaluates a factor (a number or a parenthesized expression).
     *
     * @param expression The mathematical expression to parse.
     * @param index The current index to parse from.
     * @return The result of the parsed factor and the next index.
     */
    private static ParseResult parseFactor(String expression, int index) {
        if (expression.charAt(index) == '(') {
            ParseResult inner = parseExpression(expression, index + 1);
            if (inner.nextIndex >= expression.length() || expression.charAt(inner.nextIndex) != ')') {
                throw new IllegalArgumentException("Mismatched parentheses in expression.");
            }
            inner.nextIndex++;
            return inner;
        }

        StringBuilder number = new StringBuilder();
        while (index < expression.length() && 
               (Character.isDigit(expression.charAt(index)) || expression.charAt(index) == '.')) {
            number.append(expression.charAt(index++));
        }

        if (number.length() == 0) {
            throw new IllegalArgumentException("Invalid character in expression.");
        }

        return new ParseResult(Double.parseDouble(number.toString()), index);
    }

    public static void main(String[] args) {
        String[] testExpressions = {
            "3 + 5 * 2",
            "(3 + 5) * 2",
            "10 / 2 + 3 * 4 - 6",
            "3.5 + 2.1 * (2 - 0.5)",
            "42 / (6 - 6)"
        };

        for (String expression : testExpressions) {
            try {
                System.out.println("Expression: " + expression + " = " + evaluateExpression(expression));
            } catch (Exception e) {
                System.out.println("Expression: " + expression + " Error: " + e.getMessage());
            }
        }
    }
}
