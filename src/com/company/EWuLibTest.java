package com.company;

class EWuLibTest {

    @org.junit.jupiter.api.Test
    void isPalindrome() {
        // These are palindromes
        assert(EWuLib.isPalindrome("racecar"));
        assert(EWuLib.isPalindrome("lkjjkl"));
        // This isn't
        assert(EWuLib.isPalindrome("hi") == false);
    }

    @org.junit.jupiter.api.Test
    void dateStr() {
        // Make sure '/' doesn't exist anymore
        assert(EWuLib.dateStr("09/23/1239").indexOf('/') == -1);
        // Nothing should change here
        assert(EWuLib.dateStr("12324234").equals("12324234"));
    }

    @org.junit.jupiter.api.Test
    void cutOut() {
        String mainStr = "abc123";
        String mainStr2 = "abc23";
        String subStr = "c12";

        // Make sure the new string has a smaller length
        assert(EWuLib.cutOut(mainStr, subStr).length() < mainStr.length());
        // Make sure this combination doesn't change anything
        assert(EWuLib.cutOut(mainStr2, subStr).equals(mainStr2));
    }

    @org.junit.jupiter.api.Test
    void fooBarBaz() {
        // No actual way to check stdout, so just check it runs properly here
        EWuLib.fooBarBaz(34);
    }

    @org.junit.jupiter.api.Test
    void vigCipher() {
        // Wikipedia example
        assert(EWuLib.vigCipher("ATTACKATDAWN", "LEMONLEMONLE").equals("LXFOPVEFRNHR"));
        // Based on current implementation this should also work
        assert(EWuLib.vigCipher("attackatdawn", "lemon").equals("LXFOPVEFRNHR"));
    }

    @org.junit.jupiter.api.Test
    void stringUnion() {
        // Default example
        assert(EWuLib.stringUnion("hello", "hola", "nihao") == 4);
    }

    @org.junit.jupiter.api.Test
    void isFibonacci() {
        // All numbers here should work
        assert(EWuLib.isFibonacci(EWuLib.fibonacci(12)));
        assert(EWuLib.isFibonacci(EWuLib.fibonacci(42)));
        // Just a random number
        assert(EWuLib.isFibonacci(100) == false);
    }

    @org.junit.jupiter.api.Test
    void multiplicationTable() {
        // No actual way to check stdout, so just check it runs properly here
        EWuLib.multiplicationTable(5, 5);
    }

    @org.junit.jupiter.api.Test
    void sumUpTo() {
        // Checking sum
        assert(EWuLib.sumUpTo(3) == 3);
        assert(EWuLib.sumUpTo(15) == 105);
        // Obvious logic
        assert(EWuLib.sumUpTo(100) > 100);
        assert(EWuLib.sumUpTo(23) > 0);
    }

    @org.junit.jupiter.api.Test
    void primePrinter() {
        // No actual way to check stdout, so just check it runs properly here
        EWuLib.primePrinter(20);
    }

    @org.junit.jupiter.api.Test
    void quadSolver() {
        // Checking answers
        assert(EWuLib.quadSolver(1, 2, -24).equals("4.0, -6.0"));
        assert(EWuLib.quadSolver(3.4, 5.6, 2.4).equals("Imaginary numbers"));
    }

    @org.junit.jupiter.api.Test
    void leastCommonMultiple() {
        // Just random stuff at this point
        assert(EWuLib.leastCommonMultiple(1, 2, 3) == 6);
        assert(EWuLib.leastCommonMultiple(4, 5, 6) >= Math.max(4, Math.max(5, 6)));
        assert(EWuLib.leastCommonMultiple(10, 20, 30) == 60);
    }
}