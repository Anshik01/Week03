import java.util.Scanner;

public class RemoveDuplicate {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.next();

        // initialize stringBuilder
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<s.length(); i++){
            // append character in stringBuilder only if it doesn't contain in it
            if(sb.indexOf(String.valueOf(s.charAt(i))) == -1){
                sb.append(s.charAt(i));
            }
        }

        System.out.println(sb.toString());
    }
}
