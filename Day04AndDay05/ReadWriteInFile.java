import java.io.*;
import java.util.Objects;

public class ReadWriteInFile {
    public static void main(String[] args){
        try{
            // using bufferReader to reader input from user
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            // using bufferWriter and fileWriter to write user input in the file
            BufferedWriter bw = new BufferedWriter(new FileWriter("Sample File",true));

            String line;
            // if user enters exit then program will terminate
            while(!Objects.equals(line = br.readLine(), "exit")){
                // write every statement in new line
                bw.write("\n" + line);
            }

            // closing the resources
            br.close();
            bw.close();
        }
        // catching exceptions
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
