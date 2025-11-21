package hust.soict.dsai.garbage;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class GarbageCreator {
    String filename = "src/hust/soict/dsai/garbage/file.txt";
    byte[] inputBytes = {0};
    long startTime, endTime;

    inputBytes = Files.readAllBytes(Paths.get(filename));
    startTime = System.currentTimeMillis();
    StringBuilder outputStringBuilder = new StringBuilder();
    for (byte b: inputBytes) {
        outputStringBuilder.append((char) b);
    }
    endTime = System.currentTimeMillis();
    System.out.println(endTime - startTime);
}
