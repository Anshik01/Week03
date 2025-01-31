import java.util.Arrays;

public class StudentAges {

    static void countSort(int[]age){
        // freq array stores the frequency of ages
        int[]freq = new int[9];

        // calculating the frequency of each age
        for (int j : age) {
            freq[j - 10]++;
        }

        int i=0;
        for (int j = 0; j < freq.length; j++) {
            // inserting number in array until frequency becomes 0
            while (freq[j] > 0) {
                age[i] = j + 10;
                i++;
                freq[j]--;
            }
        }
    }

    public static void main(String[] args) {
        int[]age = {12,18,10,16,15,12};

        // calling countSort function
        countSort(age);

        // print sorted array
        System.out.println(Arrays.toString(age));
    }
}
