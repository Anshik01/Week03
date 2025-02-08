package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class CompareSearchAlgo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter length of array : ");
        int n = scanner.nextInt();

        System.out.println("Enter the elements of array : ");
        int[]arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }

        // sorting the array before searching
        Arrays.sort(arr);

        System.out.println("Enter target element : ");
        int target = scanner.nextInt();

        CompareSearchAlgo compareSearchAlgo = new CompareSearchAlgo();

        System.out.println("Answer using Linear search : " + compareSearchAlgo.linearSearch(arr,target));
        System.out.println("Answer using Binary search : " + compareSearchAlgo.binarySearch(arr,target));

    }

    int linearSearch(int[]arr, int target){

        // initializing the timer
        long startTime = System.nanoTime();
        long endTime;

        // checking target element linearly
        for(int i=0; i<arr.length; i++){
            if(arr[i] == target){
                // ending the timer if answer is found
                endTime = System.nanoTime();
                System.out.println("Time Taken by linear search : " + (endTime - startTime));
                return i;
            }
        }
        // ending the timer if answer is not found
        endTime = System.nanoTime();
        System.out.println("Time Taken by linear search : " + (endTime - startTime));
        return -1;
    }

    int binarySearch(int[]arr, int target){

        // initializing the timer
        long startTime = System.nanoTime();
        long endTime;
        int start = 0;
        int end = arr.length-1;

        // everytime the search area is reducing to half
        while(start <= end){
            int mid = start + (end-start)/2;

            if(arr[mid] == target){
                // ending the timer if answer is found
                endTime = System.nanoTime();
                System.out.println("Time Taken by Binary Search is : " + (endTime - startTime));
                return mid;
            }

            else if(arr[mid] > target){
                end = mid-1;      // check on the left array
            }

            else{
                start = mid+1;    // check on the right array
            }
        }

        // ending the timer if answer is not found
        endTime = System.nanoTime();
        System.out.println("Time Taken by Binary Search is : " + (endTime - startTime));
        return -1;
    }

}
