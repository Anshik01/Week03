package org.example;

public class CompareSortingAlgo {
    public static void main(
            String[] args) {

        int[]arr1 = {5,1,4,2,3,9,4,8,6,7};
        int[]arr2 = {5,1,4,2,3,9,4,8,6,7};
        int[]arr3 = {5,1,4,2,3,9,4,8,6,7};

        // declaring variables to measure time taken
        long startTime, endTime;

        CompareSortingAlgo compareSortingAlgo = new CompareSortingAlgo();

        // Bubble sort function call
        startTime = System.nanoTime();
        arr1 =  compareSortingAlgo.bubbleSort(arr1);
        endTime = System.nanoTime();
        System.out.println("Time Taken by Bubble sort : " + (endTime - startTime));

        // Merge sort function call
        startTime = System.nanoTime();
        arr2 =  compareSortingAlgo.mergeSort(arr2, 0, 4);
        endTime = System.nanoTime();
        System.out.println("Time Taken by Merge sort : " + (endTime - startTime));

        // Quick sort function call
        startTime = System.nanoTime();
        arr3 =  compareSortingAlgo.quickSort(arr3, 0, 4);
        endTime = System.nanoTime();
        System.out.println("Time Taken by Quick sort : " + (endTime - startTime));

        for (int i : arr1) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i : arr2) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i : arr3) {
            System.out.print(i + " ");
        }
        System.out.println();

    }

        public int[] bubbleSort ( int[] arr){

            // using swapped variable to break the loop if the elements are already sorted
            boolean swapped;

            for (int i = 0; i < arr.length - 1; i++) {

                swapped = false;

                for (int j = 0; j < arr.length - i - 1; j++) {
                    if (arr[j] > arr[j + 1]) {
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                        // modifying swapped value as the value has been swapped in the loop
                        swapped = true;
                    }
                }

                // break condition
                if (!swapped){
                    return arr;
                }

            }
            return arr;
        }

        public int[] mergeSort ( int[] arr, int low, int high){

            // base condition
            if (low < high) {
                int mid = low + (high - low) / 2;

                // dividing array into segments
                mergeSort(arr, low, mid);
                mergeSort(arr, mid + 1, high);

                // merging the array again
                merge(arr, low, mid, high);
            }

            return arr;
        }

        private void merge ( int[] arr, int low, int mid, int high){
            // defining length of both arrays
            int length1 = mid - low + 1;
            int length2 = high - mid;

            // defining left and right array
            int[] leftArray = new int[length1];
            int[] rightArray = new int[length2];

            // copying elements to each array
            System.arraycopy(arr, low, leftArray, 0, length1);
            System.arraycopy(arr, mid + 1, rightArray, 0, length2);

            int i = 0, j = 0;
            int k = low;

            while (i < length1 && j < length2) {
                if (leftArray[i] < rightArray[j]) {
                    arr[k] = leftArray[i];     // leftArray element will be added
                    i++;
                } else {
                    arr[k] = rightArray[j];    // rightArray element will be added
                    j++;
                }
                k++;
            }

            // remaining elements of leftArray is added
            while (i < length1) arr[k++] = leftArray[i++];
            // remaining elements of rightArray is added
            while (j < length2) arr[k++] = rightArray[j++];

        }

        public int[] quickSort(int[]arr, int low, int high){

            // base condition
            if(low >= high){
                return arr;
            }

            int s = low;
            int e = high;
            int mid = low + (high-low)/2;
            int pivot = arr[mid];

            while(s <= e){
                // finding element that is in the wrong position from start
                while(pivot > arr[s]){
                    s++;
                }

                // finding element that is in the wrong position from end
                while(pivot < arr[e]){
                    e--;
                }

                // swap elements if condition is fulfilled
                if(s <= e){
                    int temp = arr[s];
                    arr[s] = arr[e];
                    arr[e] = temp;
                    s++;
                    e--;
                }

                quickSort(arr, low, e);
                quickSort(arr, s, high);
            }

            return arr;
        }
}