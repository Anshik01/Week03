package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.*;

class CompareDataStructureTest {

    CompareDataStructure compareDataStructure;

    @BeforeEach
    void initializeObject(){
        compareDataStructure = new CompareDataStructure();
    }

    @Test
    @DisplayName("This test 1,000 elements")

    void Test1(){

        // creating testing array
        int[]testArray = new int[1000];
        for(int i=0; i< 1000; i++){
            testArray[i] = i;
        }

        // creating testing hashSet
        HashSet<Integer> hashSet = new HashSet<>();
        for(int i=0; i<1000; i++){
            hashSet.add(i);
        }

        // creating testing TreeSet
        TreeSet<Integer> treeSet = new TreeSet<>();
        for(int i=0; i<1000; i++){
            treeSet.add(i);
        }


        assertTrue(compareDataStructure.searchInArray(testArray, 850));
        assertTrue(compareDataStructure.searchInHashSet(hashSet, 850));
        assertTrue(compareDataStructure.searchInTreeSet(treeSet, 850));
    }


    @Test
    @DisplayName("This test 10,000 elements")

    void Test2(){

        // creating testing array
        int[]testArray = new int[10000];
        for(int i=0; i< 10000; i++){
            testArray[i] = i;
        }

        // creating testing hashSet
        HashSet<Integer> hashSet = new HashSet<>();
        for(int i=0; i<10000; i++){
            hashSet.add(i);
        }

        // creating testing TreeSet
        TreeSet<Integer> treeSet = new TreeSet<>();
        for(int i=0; i<10000; i++){
            treeSet.add(i);
        }


        assertTrue(compareDataStructure.searchInArray(testArray, 8500));
        assertTrue(compareDataStructure.searchInHashSet(hashSet, 8500));
        assertTrue(compareDataStructure.searchInTreeSet(treeSet, 8500));
    }


    @Test
    @DisplayName("This test 1,000,000 elements")

    void Test3(){

        // creating testing array
        int[]testArray = new int[1000000];
        for(int i=0; i< 1000000; i++){
            testArray[i] = i;
        }

        // creating testing hashSet
        HashSet<Integer> hashSet = new HashSet<>();
        for(int i=0; i<1000000; i++){
            hashSet.add(i);
        }

        // creating testing TreeSet
        TreeSet<Integer> treeSet = new TreeSet<>();
        for(int i=0; i<1000000; i++){
            treeSet.add(i);
        }


        assertTrue(compareDataStructure.searchInArray(testArray, 850000));
        assertTrue(compareDataStructure.searchInHashSet(hashSet, 850000));
        assertTrue(compareDataStructure.searchInTreeSet(treeSet, 850000));
    }

}