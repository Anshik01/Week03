public class PerformanceTest {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();

        long startTime, endTime;

        // start time for stringBuilder
        startTime = System.nanoTime();

        // appending "Hello" 1000000 times
        stringBuilder.append("Hello".repeat(1000000));

        // end time for stringBuilder
        endTime = System.nanoTime();

        // print resultant time
        System.out.println("StringBuilder Time : " + (endTime-startTime));

        // start time for stringBuffer
        startTime = System.nanoTime();

        StringBuffer stringBuffer = new StringBuffer();

        // appending "Hello" 1000000 times
        stringBuilder.append("Hello".repeat(1000000));

        // end time for stringBuffer
        endTime = System.nanoTime();

        // print resultant time
        System.out.println("StringBuffer Time : " + (endTime - startTime));
    }
}
