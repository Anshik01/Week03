import java.util.Scanner;

public class SortBookPrice {

    static void mergeSort(int[]price, int left, int right){
        // stop the recursion when left >= right
        if(left < right){
            int mid = left + (right-left)/2;

            // breaking array
            mergeSort(price, left, mid);
            mergeSort(price, mid+1, right);
            // merging array
            merge(price, left, mid, right);
        }
    }

    static void merge(int[]price, int left, int mid, int right){
        int n1 = mid -left +1;
        int n2 = right -mid;

        // this array will store first half of the array
        int[]leftprice = new int[n1];
        // this array will store second half of the array
        int[]rightprice = new int[n2];

        System.arraycopy(price, left, leftprice, 0, n1);
        System.arraycopy(price, mid+1, rightprice, 0, n2);

        int i=0;
        int j=0;
        int k=left;

        while(i<leftprice.length && j<rightprice.length){
            if(leftprice[i]<rightprice[j]){
                price[k] = leftprice[i];
                i++;
            }
            else{
                price[k] = rightprice[j];
                j++;
            }
            k++;
        }

        // if there exist any leftover elements
        while(i < leftprice.length) price[k++] = leftprice[i++];
        while(j < rightprice.length) price[k++] = rightprice[j++];

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[]price = new int[n];

        for(int i=0; i<n; i++){
            price[i] = sc.nextInt();
        }

        mergeSort(price, 0, n-1);

        for (int i : price) {
            System.out.print(i + " ");
        }
    }
}
