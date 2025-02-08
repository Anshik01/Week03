package org.example;

import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;

public class CompareDataStructure {
    public static void main(String[] args) {

        // declaring amd initializing the data structures
        int[]array = {1,2,3,4,5,6};
        HashSet<Integer> set = new HashSet<>(Arrays.asList(1,2,3,4,5,6));
        TreeSet<Integer> treeSet = new TreeSet<>(Arrays.asList(1,2,3,4,5,6));

        CompareDataStructure compareDataStructure = new CompareDataStructure();

        System.out.println("Does target exist in array : " + compareDataStructure.searchInArray(array, 5));
        System.out.println("Does target exist in HashSet : " + compareDataStructure.searchInHashSet(set, 5));
        System.out.println("Does target exist in TreeSet : " + compareDataStructure.searchInTreeSet(treeSet, 5));
    }

    // return true if target element is found
    public boolean searchInArray(int[]array, int target){

        long startTime, endTime;
        startTime = System.nanoTime();

        // using linear search to find the element
        for(int i=0; i<array.length; i++){
            if(array[i] == target){
                endTime = System.nanoTime();
                System.out.println("Time taken for searching in array : " + (endTime - startTime));
                return true;
            }
        }

        endTime = System.nanoTime();
        System.out.println("Time taken for searching in array : " + (endTime - startTime));
        return false;
    }

    // return true if target element is found
    public boolean searchInHashSet(HashSet<Integer> set,int target){
        long startTime, endTime;
        startTime = System.nanoTime();

        boolean ans;

        if(set.contains(target)){
            ans =  true;
        }

        else{
            ans = false;
        }

        endTime = System.nanoTime();
        System.out.println("Time taken by HashSet : " + (endTime-startTime));
        return ans;
    }

    // return true if target element is found
    public boolean searchInTreeSet(TreeSet<Integer> treeSet, int target){

        long startTime, endTime;
        startTime = System.nanoTime();

        boolean ans;

        if(treeSet.contains(target)){
            ans = true;
        }
        else{
            ans = false;
        }

        endTime = System.nanoTime();
        System.out.println("Time taken by TreeSet : " + (endTime-startTime));
        return ans;
    }
}
