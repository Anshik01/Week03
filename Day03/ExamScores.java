import java.util.Arrays;
import java.util.Scanner;

public class ExamScores {

    // in selection sort we find the smallest element of the array and swap it to the first element
    static void selectionSort(int[]score){

        for(int i=0; i<score.length; i++){

            // current index which we want to swap with the smallest element
            int minIndex = i;
            for(int j=i+1; j<score.length; j++){
                if(score[j] < score[minIndex]){
                    minIndex = j;
                }
            }

            // swap the two numbers
            int temp = score[i];
            score[i] = score[minIndex];
            score[minIndex] = temp;

        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[]score = new int[n];

        for(int i=0; i<n; i++){
            score[i] = sc.nextInt();
        }

        selectionSort(score);

        // display sorted scores using toString() method
        System.out.println(Arrays.toString(score));
    }
}
