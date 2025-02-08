package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecursionAndIterationTest {

    @Test
    @DisplayName("Test 10 fibonacci number")
    void Test1(){

        long ansUsingIteration = RecursionAndIteration.fibonacciUsingIteration(10);
        long ansUsingRecursion = RecursionAndIteration.fibonacciUsingRecursion(10);

        assertEquals(55, ansUsingIteration);
        assertEquals(55, ansUsingRecursion);

    }

    @Test
    @DisplayName("Test 30 fibonacci number")
    void Test2(){

        long ansUsingIteration = RecursionAndIteration.fibonacciUsingIteration(30);
        long ansUsingRecursion = RecursionAndIteration.fibonacciUsingRecursion(30);

        assertEquals(832040, ansUsingIteration);
        assertEquals(832040, ansUsingRecursion);

    }

    @Test
    @DisplayName("Test 50 fibonacci number")
    void Test3(){

        long ansUsingIteration = RecursionAndIteration.fibonacciUsingIteration(50);
        long ansUsingRecursion = RecursionAndIteration.fibonacciUsingRecursion(50);

        // since the number is too long, converting it to string to compare
        String expectedAnswer = "12586269025";

        assertEquals(expectedAnswer, ("" + ansUsingIteration));
        assertEquals(expectedAnswer, ("" + ansUsingRecursion));

    }

}