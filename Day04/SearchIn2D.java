import java.util.Scanner;

public class SearchIn2D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter rows : ");
        int row = scanner.nextInt();

        System.out.println("Enter columns");
        int column = scanner.nextInt();

        int[][] matrix = new int[row][column];

        // taking inputs in matrix
        for(int i=0; i<row; i++){
            for(int j=0; j<column; j++){
                matrix[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Enter Target : ");
        int target = scanner.nextInt();

        int start = 0;
        int end = row * column-1;

        while(start <= end){
            int mid = start + (end-start)/2;

            // if target element fount then return it
            if(matrix[mid/column][mid%column] == target){
                System.out.println("Target element present : " + matrix[mid/column][mid%column]);
                return;
            }

            // target is greater than mid element then search in second half of array
            else if(matrix[mid/column][mid%column] < target){
                start = mid +1;
            }

            // target is smaller than mid element then search in first half of array
            else{
                end = mid-1;
            }
        }

        // this part of code will only execute if target element is not found
        System.out.println("Element not found.");

    }
}
