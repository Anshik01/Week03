import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileUsingFileReader {
    public static void main(String[] args) {
        // initializing resource in try block parameter therefore bufferedReader will be closed automatically about try block is executed
        try (BufferedReader br = new BufferedReader(new FileReader("Sample File"))){
            String line;
            // read the file until the next line becomes null
            while((line = br.readLine()) != null){
                System.out.println(line);
            }
        }
        // Catch IOException
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
