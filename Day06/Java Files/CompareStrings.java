package org.example;

import java.util.Scanner;

public class CompareStrings {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of Hello : ");
        int n = scanner.nextInt();

        CompareStrings compareStrings = new CompareStrings();

        System.out.println(compareStrings.concateUsingString(n));
        System.out.println(compareStrings.concateUsingStringBuilder(n));
        System.out.println(compareStrings.concateUsingStringBuffer(n));

    }

    public String concateUsingString(int n){

        long startTime = System.nanoTime();
        long endTime;

        String string = "";

        // repeatedly concatenating Hello to string
        string += "Hello".repeat(n);

        endTime = System.nanoTime();
        // print calculated take taken
        System.out.println("Time taken by String is : " + (endTime - startTime));
        return string;

    }

    public String concateUsingStringBuilder(int n){

        long startTime = System.nanoTime();
        long endTime;

        StringBuilder stringBuilder = new StringBuilder();

        // repeatedly appending Hello to stringBuilder
        stringBuilder.append("Hello".repeat(n));

        endTime = System.nanoTime();
        // print calculated take taken
        System.out.println("Time taken by StringBuilder is : " + (endTime - startTime));
        return stringBuilder.toString();

    }

    public String concateUsingStringBuffer(int n){

        long startTime = System.nanoTime();
        long endTime;

        StringBuffer stringBuffer = new StringBuffer();

        // repeatedly appending Hello stringBuffer
        stringBuffer.append("Hello".repeat(n));

        endTime = System.nanoTime();
        // print calculated take taken
        System.out.println("Time taken by StringBuffer is : " + (endTime - startTime));
        return stringBuffer.toString();

    }
}
