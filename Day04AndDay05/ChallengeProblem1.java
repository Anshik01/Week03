import java.io.*;

public class ChallengeProblem1 {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuffer stringBuffer = new StringBuffer();

        long startTime, endTime;

        try(BufferedWriter bw = new BufferedWriter(new FileWriter("Sample File 2"))){

            startTime = System.nanoTime();

            for(int i=0; i<1000000; i++){
                String hello = "Hello ";
                stringBuilder.append(hello);
                bw.write(hello);
            }

            endTime = System.nanoTime();

            System.out.println("Time taken by StringBuilder = " + (endTime-startTime));

            startTime = System.nanoTime();

            for(int i=0; i<1000000; i++){
                String hello = "Hello ";
                stringBuffer.append(hello);
                bw.write(hello);
            }

            endTime = System.nanoTime();

            System.out.println("Time taken by StringBuffer = " + (endTime - startTime));


        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }

        readFileUsingFileReader();
        readFileUsingInputStreamReader();
    }

    static void readFileUsingFileReader(){

        long startTime, endTime;

        try(BufferedReader br = new BufferedReader(new FileReader("Sample file 2"))){
            String line;
            long count = 0;

            startTime = System.nanoTime();
            while((line = br.readLine()) != null){
                String[]word = line.split(" ");
                count += word.length;
            }
            endTime = System.nanoTime();

            System.out.println("Number of words : " + count);
            System.out.println("Time taken by FileReader : " + (endTime - startTime));

        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    static void readFileUsingInputStreamReader(){

        long startTime, endTime;

        try(InputStreamReader isr = new InputStreamReader(new FileInputStream("Sample File 2"))){
            long count = 0;
            int letter;

            startTime = System.nanoTime();

            while((letter = isr.read()) != -1){
                if((char)letter == ' '){
                    count++;
                }
            }

            endTime = System.nanoTime();

            System.out.println("Number of words = " + (count));
            System.out.println("Time Taken by InputStreamReader : " + (endTime - startTime));
        }

        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
