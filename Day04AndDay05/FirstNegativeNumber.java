import java.util.Scanner;

public class FirstNegativeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[]numbers = new int[n];

        for(int i=0; i<n; i++){
            numbers[i] = sc.nextInt();
        }

        // applying linear search to find negative number
        for(int i=0; i<numbers.length; i++){
            // if we find the negative number then return main method
            if(numbers[i] <0){
                System.out.println("Index of negative number : " + i);
                return;
            }
        }

        // this part of code will only execute when there is no negative number in an array
        System.out.println("No negative number exit in given array");
    }
}
