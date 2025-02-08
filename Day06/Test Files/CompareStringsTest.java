package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompareStringsTest {

    @Test
    @DisplayName("This test will check 1,000 string concatenation")
    void Test1(){

        CompareStrings compareStrings = new CompareStrings();

        // creating strings using String, stringBuilder and stringBuffer
        String usingString = compareStrings.concateUsingString(1000);
        String usingStringBuilder = compareStrings.concateUsingStringBuilder(1000);
        String usingStringBuffer = compareStrings.concateUsingStringBuffer(1000);

        String expectedOutput = "";

        // finding expected output
        expectedOutput += "Hello".repeat(1000);

        assertEquals(expectedOutput, usingString);
        assertEquals(expectedOutput, usingStringBuilder);
        assertEquals(expectedOutput, usingStringBuffer);

    }


    @Test
    @DisplayName("This test will check 10,000 string concatenation")
    void Test2(){

        CompareStrings compareStrings = new CompareStrings();

        // creating strings using String, stringBuilder and stringBuffer
        String usingString = compareStrings.concateUsingString(10000);
        String usingStringBuilder = compareStrings.concateUsingStringBuilder(10000);
        String usingStringBuffer = compareStrings.concateUsingStringBuffer(10000);

        String expectedOutput = "";

        // finding expected output
        expectedOutput += "Hello".repeat(10000);

        assertEquals(expectedOutput, usingString);
        assertEquals(expectedOutput, usingStringBuilder);
        assertEquals(expectedOutput, usingStringBuffer);

    }


    @Test
    @DisplayName("This test will check 1,000,000 string concatenation")
    void Test3(){

        CompareStrings compareStrings = new CompareStrings();

        // creating strings using String, stringBuilder and stringBuffer
        String usingString = compareStrings.concateUsingString(1000000);
        String usingStringBuilder = compareStrings.concateUsingStringBuilder(1000000);
        String usingStringBuffer = compareStrings.concateUsingStringBuffer(1000000);

        String expectedOutput = "";

        // finding expected output
        expectedOutput += "Hello".repeat(1000000);

        assertEquals(expectedOutput, usingString);
        assertEquals(expectedOutput, usingStringBuilder);
        assertEquals(expectedOutput, usingStringBuffer);

    }

}