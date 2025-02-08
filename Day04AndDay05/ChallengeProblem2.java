import java.util.Arrays;
import java.util.Scanner;

public class ChallengeProblem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter length of array : ");
        int n = sc.nextInt();

        int[]numbers = new int[n];
        System.out.println("Enter elements of array");

        for(int i=0; i<n; i++){
            numbers[i] = sc.nextInt();
        }

        System.out.println("Enter target element : ");
        int target = sc.nextInt();

        // sorting the array for binary search as well as for searching missing number
        Arrays.sort(numbers);

        int missingNumber = findMissing(numbers);
        int indexOfTarget = findTarget(numbers, target);

        System.out.println("Missing number in the array : " + missingNumber);
        System.out.println("Index of target element is : " + indexOfTarget);
    }

    static int findMissing(int[]number){

        //Assuming all elements need to be consecutive
        // if difference between two elements is not 1 than missing number = current element -1;
        for(int i=1; i<number.length; i++){
            if(number[i] - number[i-1] != 1){
                return number[i-1] +1;
            }
        }
        return -1;
    }

    static int findTarget(int[]number, int target){
        // using regular binary search to find the target element
        int start = 0;
        int end = number.length-1;

        while(start <= end){
            int mid = start + (end-start)/2;

            if(number[mid] == target){
                return mid;
            }

            else if(number[mid] > target){
                end = mid-1;
            }

            else{
                start = mid +1;
            }
        }

        return -1;
    }
}
