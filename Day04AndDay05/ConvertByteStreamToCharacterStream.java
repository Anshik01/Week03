import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConvertByteStreamToCharacterStream {
    public static void main(String[] args) {
        // using FileInputStream to read the file
        // using InputStreamReader to convert byteStream to CharacterStream
        // using bufferedReader for efficient reading
        try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("Sample File")))){
            String i;
            while((i = br.readLine()) != null){
                // print every line of code
                System.out.println(i);
            }
        }
        // catch exception
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
