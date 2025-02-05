import java.util.Scanner;

public class FirstAndLastOccurrence {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Total number of number : ");

        int n= scanner.nextInt();
        int[]frequencyArray = new int[n];

        System.out.println("Enter elements : ");

        // input sorted array
        for(int i=0; i<n; i++){
            frequencyArray[i] = scanner.nextInt();
        }

        System.out.println("Enter target element : ");

        // input target element
        int target = scanner.nextInt();

        int first = firstOccurence(frequencyArray, target);
        int last = lastOccurence(frequencyArray, target);

        System.out.println("First and last occurence of target is : " + first + ", " + last);
    }
    static int firstOccurence(int[]frequencyArray, int target){
        int start = 0;
        int end = frequencyArray.length-1;
        int first = -1;

        while(start <= end){
            int mid = start + (end-start)/2;

            if(frequencyArray[mid] == target){
                // updating first occurrence
                first = mid;
                // check for smaller index
                end = mid-1;
            }
            else if(frequencyArray[mid] > target){
                end = mid -1;   // look on the left
            }
            else {
                start = mid+1;   // look on the right
            }
        }
        return first;
    }

    static int lastOccurence(int[]frequencyArray, int target){
        int start = 0;
        int end = frequencyArray.length-1;
        int last = -1;

        while(start <= end){
            int mid = start + (end-start)/2;

            if(frequencyArray[mid] == target){
                // updating last occurrence
                last = mid;
                // check on the larger index
                start = mid+1;
            }

            else if(frequencyArray[mid] > target){
                end = mid-1;    // check on left side
            }

            else{
                start = mid+1;   // check on right side
            }
        }
        return last;
    }
}
