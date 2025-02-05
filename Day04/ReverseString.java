import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.next();

        // creating a stringBuilder and initializing it with given string
        StringBuilder sb = new StringBuilder(s);
        // this method will reverse the stringBuilder object
        sb.reverse();

        System.out.println("Reversed String : " + sb.toString());
    }
}
