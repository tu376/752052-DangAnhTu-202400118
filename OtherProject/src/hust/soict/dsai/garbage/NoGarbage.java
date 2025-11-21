package hust.soict.dsai.garbage;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NoGarbage {
    String filename = "src/hust/soict/dsai/garbage/file.txt";
    byte[] inputBytes = {0};
    long startTime, endTime;

    inputBytes = Files.readAllBytes(Paths.get(filename));
    startTime = System.currentTimeMillis();
    String outputString = "";
    for (byte b: inputBytes) {
        outputString += (char) b;
    } 
    endTime = System.currentTimeMillis();
    System.out.println(endTime - startTime);
}
