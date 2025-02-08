package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;

class CompareSortingAlgoTest {


    @Test
    @DisplayName("This test will check array of 1,000 elements")
    void Test1(){
        int[]arr1 = new int[1000];
        int[]arr2 = new int[1000];
        int[]arr3 = new int[1000];
        Random random = new Random();

        // generate random value to store in array
        for(int i=0; i< arr1.length; i++){
            arr1[i] = random.nextInt(1000) +1;
            arr2[i] = random.nextInt(1000) +1;
            arr3[i] = random.nextInt(1000) +1;
        }

        CompareSortingAlgo compareSortingAlgo = new CompareSortingAlgo();

        // sorted array using each algorithm is stored in ans
        int[]ans1 = compareSortingAlgo.bubbleSort(arr1);
        int[]ans2 = compareSortingAlgo.mergeSort(arr2,0,arr2.length-1);
        int[]ans3 = compareSortingAlgo.quickSort(arr3,0,arr2.length-1);

        // sorting array using in-built method to find the expected output
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        Arrays.sort(arr3);

        assertEquals(ans1, arr1);
        assertEquals(ans2, arr2);
        assertEquals(ans3, arr3);
    }

    @Test
    @DisplayName("This test will check array of 10,000 elements")
    void Test2(){
        int[]arr1 = new int[10000];
        int[]arr2 = new int[10000];
        int[]arr3 = new int[10000];
        Random random = new Random();

        // generate random value to store in array
        for(int i=0; i< arr1.length; i++){
            arr1[i] = random.nextInt(10000) +1;
            arr2[i] = random.nextInt(10000) +1;
            arr3[i] = random.nextInt(10000) +1;
        }

        CompareSortingAlgo compareSortingAlgo = new CompareSortingAlgo();

        // sorted array using each algorithm is stored in ans
        int[]ans1 = compareSortingAlgo.bubbleSort(arr1);
        int[]ans2 = compareSortingAlgo.mergeSort(arr2,0,arr2.length-1);
        int[]ans3 = compareSortingAlgo.quickSort(arr3,0,arr2.length-1);

        // sorting array using in-built method to find the expected output
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        Arrays.sort(arr3);

        assertEquals(ans1, arr1);
        assertEquals(ans2, arr2);
        assertEquals(ans3, arr3);
    }

    @Test
    @DisplayName("This test will check array of 1,000,000 elements")
    void Test3(){
        int[]arr1 = new int[1000000];
        int[]arr2 = new int[1000000];
        int[]arr3 = new int[1000000];
        Random random = new Random();

        // generate random value to store in array
        for(int i=0; i< arr1.length; i++){
            arr1[i] = random.nextInt(1000000) +1;
            arr2[i] = random.nextInt(1000000) +1;
            arr3[i] = random.nextInt(1000000) +1;
        }

        CompareSortingAlgo compareSortingAlgo = new CompareSortingAlgo();

        // sorted array using each algorithm is stored in ans
        int[]ans1 = compareSortingAlgo.bubbleSort(arr1);
        int[]ans2 = compareSortingAlgo.mergeSort(arr2,0,arr2.length-1);
        int[]ans3 = compareSortingAlgo.quickSort(arr3,0,arr2.length-1);

        // sorting array using in-built method to find the expected output
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        Arrays.sort(arr3);

        assertEquals(ans1, arr1);
        assertEquals(ans2, arr2);
        assertEquals(ans3, arr3);
    }

}