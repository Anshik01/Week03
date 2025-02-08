package org.example;

import java.io.*;

public class LargeFileReading {
    public static void main(String[] args) {

        LargeFileReading largeFileReading = new LargeFileReading();

        String fileName = "Sample File";

        System.out.println("Operation status using File reader : " + largeFileReading.readFileUsingFileReader(fileName));
        System.out.println("Operation status using InputStreamReader : " + largeFileReading.readFileUsingInputStreamReader(fileName));

    }

    public String readFileUsingFileReader(String fileName){

        // initialising start and end time to calculate performance time
        long startTime = System.nanoTime();
        long endTime;

        // using bufferedReader inside try parameter to automatically close the resource after the try block is executed
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            String line;
            // reading file until null
            while((line = reader.readLine()) != null){}
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }

        endTime = System.nanoTime();
        // calculate total time for fileReader to execute read file
        System.out.println("Time taken by File reader : " + (endTime - startTime));

        return "Read file using File reader successfully";
    }

    public String readFileUsingInputStreamReader(String fileName){

        // initialising start and end time to calculate performance time
        long startTime = System.nanoTime();
        long endTime;

        try(InputStreamReader reader = new InputStreamReader(new FileInputStream(fileName))){
            int letter;

            // read file
            while((letter = reader.read()) != -1){}
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }

        endTime = System.nanoTime();
        // calculate total time for InputStreamReader to execute read file
        System.out.println("Time taken by InputStreamReader : " + (endTime - startTime));

        return "Read file using InputStreamReader SuccessFully";
    }
}
