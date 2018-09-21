package EdmundWu;

class EWuLibTest {

    @org.junit.jupiter.api.Test
    void isPalindrome() {
        // These are palindromes
        assert(EWuLib.isPalindrome("racecar"));
        assert(EWuLib.isPalindrome("lkjjkl"));
        // This isn't
        assert(!EWuLib.isPalindrome("hi"));
    }

    @org.junit.jupiter.api.Test
    void dateStr() {
        // Make sure '/' doesn't exist anymore
        assert(EWuLib.dateStr("09/23/1239").indexOf('/') == -1);
        // Make sure format is correct
        assert(EWuLib.dateStr("09/23/1239").equals("23 - 09 - 1239"));
        // Nothing should change here
        assert(EWuLib.dateStr("12324234").equals("12324234"));
    }

    @org.junit.jupiter.api.Test
    void cutOut() {
        String subStr = "c12";

        // Make sure the new string has a smaller length
        assert(EWuLib.cutOut("abc123", subStr).equals("ab3"));
        // Make sure only first subStr is gone
        assert(EWuLib.cutOut("abc123c1c3243abc23ds", subStr).equals("ab3c1c3243abc23ds"));
        // Make sure this combination doesn't change anything
        assert(EWuLib.cutOut("abc23", subStr).equals("abc23"));
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
        assert(EWuLib.isFibonacci(EWuLib.fibonacci(20)));
        // Just a random number
        assert(!EWuLib.isFibonacci(100));
    }

    @org.junit.jupiter.api.Test
    void multiplicationTable() {
        // No actual way to check stdout, so just check it runs properly here
        EWuLib.multiplicationTable(5, 5);
    }

    @org.junit.jupiter.api.Test
    void sumUpTo() {
        // Checking sum
        assert(EWuLib.sumUpTo(3) == 6);
        assert(EWuLib.sumUpTo(15) == 120);
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