package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompareSearchAlgoTest {

    @Test
    @DisplayName("This test checks the array of 1,000")
    void Test1(){

        // creating a testing array
        int[]arr = new int[1000];
        for(int i=0; i<1000; i++){
            arr[i] = i;
        }

        // creating object of linear search and binary search
        CompareSearchAlgo compareSearchAlgo = new CompareSearchAlgo();

        int linearSearchAns = compareSearchAlgo.linearSearch(arr,943);
        int binarySearchAns = compareSearchAlgo.binarySearch(arr,943);

        // testing linear search algorithm
        assertEquals(943, linearSearchAns);
        // testing binary search algorithm
        assertEquals(943, binarySearchAns);

    }


    @Test
    @DisplayName("This test checks the array of 10,000")
    void Test2(){

        // creating a testing array
        int[]arr = new int[10000];
        for(int i=0; i<10000; i++){
            arr[i] = i;
        }

        // creating object of linear search and binary search
        CompareSearchAlgo compareSearchAlgo = new CompareSearchAlgo();

        int linearSearchAns = compareSearchAlgo.linearSearch(arr,9403);
        int binarySearchAns = compareSearchAlgo.binarySearch(arr,9403);

        // testing linear search algorithm
        assertEquals(9403, linearSearchAns);
        // testing binary search algorithm
        assertEquals(9403, binarySearchAns);

    }


    @Test
    @DisplayName("This test checks the array of 1,000,000")
    void Test3(){

        // creating a testing array
        int[]arr = new int[1000000];
        for(int i=0; i<1000000; i++){
            arr[i] = i;
        }

        // creating object of linear search and binary search
        CompareSearchAlgo compareSearchAlgo = new CompareSearchAlgo();

        int linearSearchAns = compareSearchAlgo.linearSearch(arr,904031);
        int binarySearchAns = compareSearchAlgo.binarySearch(arr,904031);

        // testing linear search algorithm
        assertEquals(904031, linearSearchAns);
        // testing binary search algorithm
        assertEquals(904031, binarySearchAns);

    }

    @Test
    @DisplayName("What if element is not present")
    void Test4(){

        int[] arr = {5,1,3,2,4};

        // creating object of linear search and binary search
        CompareSearchAlgo compareSearchAlgo = new CompareSearchAlgo();

        int linearSearchAns = compareSearchAlgo.linearSearch(arr,8);
        int binarySearchAns = compareSearchAlgo.binarySearch(arr,8);

        // testing linear search algorithm
        assertEquals(-1, linearSearchAns);
        // testing binary search algorithm
        assertEquals(-1, binarySearchAns);
    }

}