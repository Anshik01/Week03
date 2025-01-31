import java.util.Scanner;

public class SortEmployeeID {

    static void insertionSort(int[]employeeID){

        for(int i = 1; i<employeeID.length; i++){
            // key points to the current value
            int key = employeeID[i];
            int j = i-1;

            // shift all elements that are greater than key
            while(j>=0 && employeeID[j] > key){
                employeeID[j+1] = employeeID[j];
                j--;      // decrease value of j
            }

            employeeID[j+1] = key;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[]employeeId = new int[n];

        for(int i=0; i<n; i++){
            employeeId[i] = sc.nextInt();
        }

        insertionSort(employeeId);

        for (int i : employeeId) {
            System.out.print(i + " ");
        }
    }
}
