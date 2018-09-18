package com.company;

import static com.company.EWuLib.*;

public class testFile {

    public static void main(String[] args) {
        System.out.println(isPalindrome("racecar"));
        System.out.println(dateStr("09/23/1239"));
        System.out.println(cutOut("abc123", "c12"));
        fooBarBaz(34);

        System.out.println(stringUnion("hello", "hola", "nihao"));
        System.out.println(vigCipher("attackatdawn", "lemon"));

        System.out.println(isFibonacci(55));
        multiplicationTable(5, 5);
        System.out.println(sumUpTo(15));
        primePrinter(10);

        System.out.println(quadSolver(1, 2, -24));
        System.out.println(leastCommonMultiple(4, 2, 3));
    }
}
