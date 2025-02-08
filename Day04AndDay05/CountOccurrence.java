import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class CountOccurrence {
    public static void main(String[] args) {

        // this will store all the words that file has
        ArrayList<String> words = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader("Sample File"))){
            String line;
            while((line = br.readLine()) != null){
                // array will include all the words of the line
                String[]word = line.split(" ");
                // add this array to arraylist
                words.addAll(Arrays.asList(word));
            }
        }
        // handle exception
        catch (IOException e){
            System.out.println(e.getMessage());
        }

        // creating hashmap to count the frequency
        HashMap<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word,0) + 1);
        }

        System.out.println("Frequency of characters : ");
        System.out.println(map);
    }
}
