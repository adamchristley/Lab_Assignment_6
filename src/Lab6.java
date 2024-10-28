import java.util.Arrays;

public class Lab6 {
    // What are the recursive steps and base cases for Fibonacci when n < 0?
    // When n is less than zero, the function manipulates the sign of fib(-n) using the pow operator.
    // With the fib(-n) call a positive number is called which will undergo more recursion and finally return an answer.
    // fib(n > 1) returns fib(n - 2) + fib(n - 1) which undergoes more recursion steps.
    // fib(n) will not undergo any more recursion if its base cases are called.
    // Those base cases are fib(0) and fib(1).

    // What is missing from the above Fibonacci code (Base Case and Recursive Step)?
    // The above fibonacci code is missing the case for negative numbers.
    // And its base cases are incorrect for negative numbers too.
    // |n| <= 1 -> |n| is not a correct compared to the full definition of the fibonacci sequence.
    // The recursive step is missing for negative numbers.
    // n < 0 -> (-1) ^ (n + 1) * fibonacci(-n)

    public static long fib( long n ) {
        if(n < 0) {
            return (long) Math.pow(-1, n + 1) * fib(-n);
        } else if(n == 0) {
            return 0;
        } else if(n == 1) {
            return 1;
        } else {
            return fib(n - 2) + fib(n - 1);
        }
    }
    // How can you test this method?
    // By providing it a variety of test cases in the main method where we call the function with various palindromes and non-palindromes and see how it does.

    // What are the unusual cases (also called edge cases) that you have to test?
    // Technically any single letter is a palindrome. So the code needs to account for that as well.

    public static boolean isPalindrome(String s) {
        if(s.length() < 1) {
            return true;
        }
        if(s.charAt(0) != s.charAt(s.length() - 1)) {
            return false;
        }
        if(s.length() > 2) {
            return isPalindrome(s.substring(1, s.length() - 1));
        }
        return true;
    }

    // Suppose the input array could be null or empty. What would reasonable results be?
    // Returning null

    // How would you test for these results?
    // By providing test cases in the main method for maxValue({}) and maxValue(null)
    public static Integer maxValue( Integer[ ] a ) {
        // Segment for follow up question
        if(a == null || a.length < 1) {
            return null;
        }

        if(a.length < 2) {
            return a[0];
        }
        int maxValueSmallerSegment = maxValue(Arrays.copyOfRange(a, 1, a.length));
        if(a[0] > maxValueSmallerSegment) {
            return a[0];
        } else {
            return maxValueSmallerSegment;
        }
    }


    public static int sumDigits(int n) {
        if(n < 0) {
            return -1 * sumDigits(-n);
        }
        if(n < 10) {
            return n;
        }

        int numberOfDigits = (int) Math.log10(n);
        int smallestBase10 = (int) Math.pow(10, numberOfDigits);
        int firstDigit = n / smallestBase10;
        int remindingDigits = n % smallestBase10;

        return firstDigit + sumDigits(remindingDigits);
    }

    public static void main(String args[]) {

        System.out.println("Test cares for isPalindrome:");
        System.out.println("isPalindrome(\"racecar\") = " + Boolean.toString(isPalindrome("racecr")));
        System.out.println("isPalindrome(\"hannah\") = " + Boolean.toString(isPalindrome("hannah")));
        System.out.println("isPalindrome(\"moon\") = " + Boolean.toString(isPalindrome("moon")));
        System.out.println("isPalindrome(\"car\") = " + Boolean.toString(isPalindrome("car")));
        System.out.println("isPalindrome(\"c\") = " + Boolean.toString(isPalindrome("c")));
        System.out.println();

        System.out.println("Test cares for maxValue:");

        Integer[] testArray = {1, 2, 3, 4, 5};
        System.out.println("maxValue({1, 2, 3, 4, 5}) = " + Integer.toString(maxValue(testArray)));

        Integer[] testArray2 = {52, 16, 178, -23};
        System.out.println("maxValue({52, 16, 178, -23}) = " + Integer.toString(maxValue(testArray2)));

        Integer[] testArray3 = {-49};
        System.out.println("maxValue({-49}) = " + Integer.toString(maxValue(testArray3)));

        System.out.println();

        System.out.println("Test cares for SumDigits:");

        System.out.println("sumDigits(56) = " + Integer.toString(sumDigits(56)));
        System.out.println("sumDigits(6323) = " + Integer.toString(sumDigits(6323)));
        System.out.println("sumDigits(242) = " + Integer.toString(sumDigits(242)));
        System.out.println("sumDigits(-46) = " + Integer.toString(sumDigits(-46)));

        System.out.println();

        System.out.println("Test cares for Fibonacci:");
        for(int i = -10; i < 10; i++) {
            System.out.println("At index " + Integer.toString(i) + " fib is " + Long.toString(fib(i)));
        }
    }
}
