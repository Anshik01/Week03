import java.util.Scanner;

public class ConcatenateString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // length of string array
        int n = scanner.nextInt();
        String[] stringArray = new String[n];

        for(int i=0; i<n; i++){
            stringArray[i] = scanner.next();
        }

        // initialize stringBuffer object
        StringBuffer stringBuilder = new StringBuffer();

        // iterating array
        for(int i=0; i<n; i++){
            // iterating each string
            for(int j=0; j<stringArray[i].length(); j++){
                stringBuilder.append(stringArray[i].charAt(j));
            }
        }

        System.out.println(stringBuilder);
    }
}
