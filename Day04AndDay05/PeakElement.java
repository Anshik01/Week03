import java.util.Scanner;

public class PeakElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of elements in array");
        int n = sc.nextInt();
        int[]peakArray = new int[n];

        System.out.println("Enter elements");
        for(int i=0; i<n; i++){
            peakArray[i] = sc.nextInt();
        }

        System.out.println("Peak element : " + findPeakElement(peakArray));
    }

    static int findPeakElement(int[]peakArray){
        // checking if the array is sorted or not
        if(peakArray[0] < peakArray[peakArray.length-1]){
            return peakArray[peakArray.length-1];
        }

        // if array has just one element then peak element will be the first element
        if(peakArray.length == 1){
            return peakArray[0];
        }

        int start = 0;
        int end = peakArray.length -1;

        while(start <= end){
            int mid = start + (end-start)/2;

            // condition to avoid indexOutOfBound exception
            if(mid == 0){
                if(peakArray[mid] < peakArray[mid+1]) {
                    start++;
                }
                else{
                    return peakArray[mid];
                }
            }

            else if(peakArray[mid] > peakArray[mid+1] && peakArray[mid] > peakArray[mid-1]){
                return peakArray[mid];
            }

            else if(peakArray[mid] < peakArray[start]){
                end = mid-1;
            }

            else if(peakArray[mid] > peakArray[start]){
                start = mid;
            }
        }

        return -1;
    }
}
