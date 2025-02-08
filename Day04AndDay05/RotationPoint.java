public class RotationPoint {
    public static void main(String[] args) {
        // rotated sorted array with rotation point = 1;
        int[]rotatedArray = {4,5,1,2,3};

        System.out.println(binarySearch(rotatedArray));
    }

    static int binarySearch(int[]rotatedArray){
        // initializing start and end pointer to track which side of the array should be tracked
        int start = 0;
        int end = rotatedArray.length-1;

        // run the loop until the value of start and end becomes equal
        while(start != end){
            int mid = start + (end-start)/2;

            // if rotation point exist in right side of array
            if(rotatedArray[mid] > rotatedArray[end]){
                start = mid+1;
            }
            // if rotation point exist in left side of array
            else if(rotatedArray[mid] < rotatedArray[end]){
                end = mid;
            }

        }
        // return rotation point which is equal to start
        return start;
    }
}
