import java.util.Scanner;

public class ProductPrices {

    static void quickSort(int[]price, int low, int high){

        // break the recursion if low>=high
        if(low>=high){
            return;
        }

        int s = low;
        int e = high;
        int mid = s + (e-s)/2;
        // pivot element is taken middle element to avoid worst case
        int pivot = price[mid];

        while(s <= e){

            // fining element on left side that is greater than pivot
            while(pivot > price[s]){
                s++;
            }
            // finding element on right side that is smaller than pivot
            while(pivot < price[e]){
                e--;
            }

            // swap both the numbers
            if(s <= e){
                int temp = price[s];
                price[s] = price[e];
                price[e] = temp;
                s++;
                e--;
            }

            // Recursively calling the functions
            quickSort(price, low, e);
            quickSort(price, s, high);
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[]price = new int[n];

        for(int i=0; i<n; i++){
            price[i] = sc.nextInt();
        }

        quickSort(price, 0, price.length-1);

        // display sorted array
        for (int i : price) {
            System.out.print(i + " ");
        }

    }
}
