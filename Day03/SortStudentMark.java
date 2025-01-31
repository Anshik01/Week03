import java.util.Scanner;

public class SortStudentMark {

    static int[]bubbleSort(int[]marks){
        // swapped variable helps to break the program when the program is already sorted
        boolean swapped;

        for(int i=0; i< marks.length-1; i++){
            swapped = false;
            for(int j = 0; j<marks.length-i-1; j++){
                if(marks[j] > marks[j+1]){
                    // swapping values
                    int temp = marks[j];
                    marks[j] = marks[j+1];
                    marks[j+1] = temp;
                    swapped = true;
                }
            }
            // since there was no swap therefore the array is sorted
            if(!swapped) break;
        }

        return marks;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[]marks = new int[n];

        for(int i=0; i<marks.length; i++){
            marks[i] = sc.nextInt();
        }

        int[]answer = bubbleSort(marks);

        for(int i : answer){
            System.out.print(i + " ");
        }
    }
}
