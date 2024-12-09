package lab12;

public class RecursiveSumOfDigits {

    /**
     * Calculates the sum of the digits of a given integer recursively.
     *
     * @param number The integer whose digits need to be summed.
     * @return The sum of the digits.
     */
    public static int sumOfDigits(int number) {
        // conversion to positive
        if (number < 0) {
            number = -number;
        }
        
        // base case
        if (number == 0) {
            return 0;
        }

        //add the last digit to the cumulative sum
        return number % 10 + sumOfDigits(number / 10);
    }

}

