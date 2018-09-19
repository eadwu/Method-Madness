package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class EWuLib {
    /**
     * Checks whether or not `str` is a palindrome.
     *
     * @param str the String
     * @return    whether or not the String is a palindrome
     */
    public static boolean isPalindrome (String str) {
        return str.equals(new StringBuilder(str).reverse().toString());
    }

    /**
     * Formats a date from 00/00/0000 to 00-00-0000.
     *
     * @param date the String containing the date
     * @return     a newly formatted or the original date
     */
    public static String dateStr (String date) {
        return date.replace("/", " - ");
    }

    /**
     * Removes `subStr` from `mainStr` if it exists.
     *
     * @param mainStr the String to remove `subStr` from
     * @param subStr  the String to remove from `mainStr`
     * @return        the newly created or old string
     */
    public static String cutOut (String mainStr, String subStr) {
        return mainStr.replaceFirst(subStr, "");
    }

    /**
     * Outputs sequence [1, num1) where multiples of 3 and 5 are replaced
     * with "baz", multiples of 5 are replaced with "bar", and multiples of
     * 3 are replace with "foo".
     *
     * @param num1 the last digit to be included
     */
    public static void fooBarBaz (int num1) {
        System.out.println(IntStream.rangeClosed(1, num1)
                .mapToObj(String::valueOf)
                .map(v -> {
                    int i = Integer.parseInt(v);

                    return i % 3 == 0 && i % 5 == 0
                            ? "baz"
                            : i % 3 == 0
                            ? "foo"
                            : i % 5 == 0
                            ? "bar"
                            : v;
                })
                .collect(Collectors.joining(", ")));
    }

    /**
     * Encrypts `message` using `key` through the Vigenere Cipher.
     *
     * @param message the plaintext to be encrypted
     * @param key     the encryption key
     * @return        the cipher text
     */
    public static String vigCipher (String message, String key) {
        // Simplify cipher by restricting to .toUpperCase()
        // Assume A-Z refers to 0-25 and addition is performed for modulo 26
        // Convert through ASCII table
        List<Integer> plaintextChars = message.toUpperCase().codePoints().boxed().collect(Collectors.toList());
        List<Integer> keyChars = key.toUpperCase().codePoints().boxed().collect(Collectors.toList());

        return IntStream.range(0, message.length())
                .map(i -> (plaintextChars.get(i) + keyChars.get(i % key.length()) - 130) % 26 + 65)
                .mapToObj(i -> ((char) i))
                .map(String::valueOf)
                .collect(Collectors.joining(""));
    }

    /**
     * Returns the number of distinct chars that appear on at least two words.
     *
     * @param word1 the first word
     * @param word2 the second word
     * @param word3 the third word
     * @return      the amount of distinct chars
     */
    public static int stringUnion (String word1, String word2, String word3) {
        return (int) Arrays.stream((word1 + word2 + word3).split(""))
                .distinct()
                .filter(v -> word1.contains(v) && word2.contains(v) ||
                        word1.contains(v) && word3.contains(v) ||
                        word2.contains(v) && word3.contains(v))
                .count();
    }

    /**
     * Gives the nth number in the fibonacci sequence.
     *
     * @param n which number in the sequence
     * @return  the value of the nth number in the sequence
     */
    public static int fibonacci (int n) {
        return n <= 1
                ? n
                : fibonacci(n - 1) + fibonacci(n - 2);
    }

    /**
     * Checks if a number is within the fibonacci sequence.
     *
     * @param n the number to check
     * @return  whether or not the number is in the sequence
     */
    public static boolean isFibonacci (int n) {
        // https://math.stackexchange.com/questions/9999/checking-if-a-number-is-a-fibonacci-or-not
        // "The standard way (other than generating up to N) is to check if
        // (5N^2+4) or (5N^2−4) is a perfect square".
        double plusFour = 5 * Math.pow(n, 2) + 4;
        double minusFour = 5 * Math.pow(n, 2) - 4;

        return (int) Math.sqrt(plusFour) * (int) Math.sqrt(plusFour) == plusFour ||
                (int) Math.sqrt(minusFour) * (int) Math.sqrt(minusFour) == minusFour;
    }

    /**
     * Outputs an extremely "pretty" table that is formatted as a
     * multiplication table.
     *
     * @param base  the base number of the table
     * @param range the range the table should reach
     */
    public static void multiplicationTable (int base, int range) {
        IntStream.rangeClosed(0, range).forEach(v -> System.out.printf("%d * %d = %d\n", base, v, base * v));
    }

    /**
     * Returns the sum of the sequence [0, n).
     *
     * @param n the last number in the sequence
     * @return  the sum of the sequence
     */
    public static int sumUpTo (int n) {
        return IntStream.rangeClosed(0, n).sum();
    }

    /**
     * Outputs the first `num` prime numbers through the Sieve of Eratosthenes.
     *
     * @param num the number of primes
     */
    public static void primePrinter (int num) {
        List<Integer> primes = new ArrayList<>(Arrays.asList(2));
        int number = 3;

        while (primes.size() < num) {
            boolean check = true;

            for (int n : primes)
                check = check ? number % n != 0 : check;

            if (check)
                primes.add(number);
            number++;
        }
        System.out.println(primes.stream().map(String::valueOf).collect(Collectors.joining(", ")));
    }

    /**
     * Finds the root of ax^2+bx+c through the quadratic formula. Also takes
     * into account if the solution is imaginary.
     *
     * @param a the value of a
     * @param b the value of b
     * @param c the value of c
     * @return  string containing the roots or explanation regarding imaginary
     *          roots
     */
    public static String quadSolver (double a, double b, double c) {
        double radicalCompute = Math.pow(b, 2) - 4 * a * c;
        double radical = Math.sqrt(radicalCompute);
        double invertedB = b * -1;
        double twiceA = a * 2;

        return radicalCompute < 0
                ? "Imaginary numbers"
                : (invertedB + radical) / twiceA + ", " + (invertedB - radical) / twiceA;
    }

    /**
     * Finds the greatest common divisor given two integers through Euclidean's
     * algorithm. Also known as the greatest common factor.
     *
     * @param a the first number
     * @param b the second number
     * @return  the greatest common divisor of the two numbers
     */
    public static int gcd (int a, int b) {
        // https://en.wikipedia.org/wiki/Euclidean_algorithm#Implementations
        return b == 0
                ? a
                : gcd(b, a % b);
    }

    /**
     * Computes the least common multiple of `a` and `b` using the greatest
     * common divisor.
     *
     * @param a the first number
     * @param b the second number
     * @return  the least common multiple
     */
    public static int lcm (int a, int b) {
        // https://en.wikipedia.org/wiki/Least_common_multiple#Reducation_by_the_greatest_common_divisor
        return Math.abs(a * b) / gcd(a, b);
    }

    /**
     * Given three numbers (`num1`, `num2`, `num3`), this function finds the least
     * common multiple of the three.
     *
     * @param num1 the first number
     * @param num2 the second number
     * @param num3 the third number
     * @return     the least common multiple
     */
    public static int leastCommonMultiple (int num1, int num2, int num3) {
        return lcm(num1, lcm(num2, num3));
    }
}
