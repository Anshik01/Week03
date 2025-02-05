import java.util.Scanner;

public class SearchWordInSentence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // sentences stores all the sentence entered by user
        String[] sentences = new String[5];

        System.out.println("Enter target string");
        // target string
        String target = scanner.next();

        scanner.nextLine();

        System.out.println("Enter 5 sentences");

        for(int i=0; i<5; i++){
            sentences[i] = scanner.nextLine();
        }

        // iterating sentence array
        for (String sentence : sentences) {
            // words array stores all the words in the sentence
            String[] words = sentence.split(" ");
            // iterating each word and check if it is equal to target string
            for (String word : words) {
                if (word.equals(target)) {
                    System.out.println(sentence);
                    return;
                }
            }
        }

        // this part of the code will only execute if target element does not exist in any sentence
        System.out.println("Not found");
    }
}
