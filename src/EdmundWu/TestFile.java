package EdmundWu;

import static EdmundWu.EWuLib.*;

public class TestFile {

    public static void main(String[] args) {
        //// String Methods
        // This is a palindrome
        System.out.println(isPalindrome("racecar"));
        // This isn't one
        System.out.println(isPalindrome("hi"));

        // Format date properly (08 - 01 - 1999)
        System.out.println(dateStr("01/08/1999"));

        // Remove only the first occurrence (atonic cat)
        System.out.println(cutOut("catatonic cat", "cat"));

        // Check stdout and should be fine
        fooBarBaz(15);

        //// Challenge Methods
        // Distinct characters in a word that occur in multiple words (4)
        System.out.println(stringUnion("hello", "hola", "nihao"));

        // Wikipedia example (LXFOPVEFRNHR)
        System.out.println(vigCipher("attackatdawn", "lemon"));

        //// Math Methods
        // This should be part of the fibonacci sequence
        System.out.println(isFibonacci(fibonacci(4)));
        // This shouldn't be part of the sequence
        System.out.println(isFibonacci(100));

        // Check stdout and it should look fine
        multiplicationTable(5, 5);

        // The sum of integers in the sequence [0, 15] (120
        System.out.println(sumUpTo(15));

        // The first 10 prime numbers (2, 3, 5, 7, 11, 13, 17, 19, 23, 29)
        primePrinter(10);

        //// Challenge Methods
        // Quadratic equation (4, -6)
        System.out.println(quadSolver(1, 2, -24));
        // LCM through a * b / gcd(a, b) (12)
        System.out.println(leastCommonMultiple(4, 2, 3));
    }
}
