package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LargeFileReadingTest {

    @Test
    @DisplayName("Testing a 12MB file")

    void Test(){
        LargeFileReading largeFileReading = new LargeFileReading();

        String fileName = "Sample File";

        String statusFileReader = largeFileReading.readFileUsingFileReader(fileName);
        String statusInputStreamFileReader = largeFileReading.readFileUsingInputStreamReader(fileName);

        assertEquals("Read file using File reader successfully", statusFileReader);
        assertEquals("Read file using InputStreamReader SuccessFully", statusInputStreamFileReader);
    }

}