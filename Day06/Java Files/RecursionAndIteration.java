package org.example;

import java.util.Scanner;

public class RecursionAndIteration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long startTime, endTime;

        int n = scanner.nextInt();

        startTime = System.nanoTime();
        System.out.println(fibonacciUsingIteration(n));
        endTime = System.nanoTime();
        System.out.println("Time taken by Iteration is : " + (endTime-startTime));

        startTime = System.nanoTime();
        System.out.println(fibonacciUsingRecursion(n));
        endTime = System.nanoTime();
        System.out.println("Time taken by Recursion is : " + (endTime-startTime));

    }

    public static long fibonacciUsingIteration(int n){

        // return the value directly if n==1 || n==2
        if(n == 1){
            return 0;
        }
        if(n == 2){
            return 1;
        }

        long sum = 0;
        long first =0, second = 1;

        // adding previous two number to the next number
        for(int i=2; i<=n; i++){
            sum = first+second;
            first = second;
            second = sum;
        }

        return second;
    }

    public static long fibonacciUsingRecursion(int n){
        // base condition returning first and second element
        if(n == 0 || n == 1){
            return n;
        }

        // adding n-1 and n-2 using recursion
        // value of n is updating in each recursion call
        return fibonacciUsingRecursion(n-1)+fibonacciUsingRecursion(n-2);
    }
}
