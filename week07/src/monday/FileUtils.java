package monday;
//looks good
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtils {

  private static FileUtils instance = null;

  private FileUtils() {

  }

  public static FileUtils getInstance() {
    if (instance == null) {
      instance = new FileUtils();
    }
    return instance;
  }

  public String readFrom(File file) throws IOException {
    StringBuilder sb = new StringBuilder();
    String line;

    try (BufferedReader reader = 
         new BufferedReader(new FileReader(file))) {
      while ((line = reader.readLine()) != null) {
        sb.append(line);
      }
    }

    return sb.toString();
  }

  public String readFrom(Path path) throws IOException {
    return readFrom(path.toFile());
  }

  public void writeTo(File source, File output) throws IOException {
    try (BufferedWriter writer = 
         new BufferedWriter(new FileWriter(output))) {
      writer.write(readFrom(source));
    }
  }

  public void writeTo(Path source, Path output) throws IOException{
    writeTo(source.toFile(), output.toFile());
  }

  // It's a good idea to extract this main function into a separate class
  public static void main(String[] args) throws IOException {
    FileUtils f1 = new FileUtils();
    System.out.println(f1.readFrom(new File("/home/polinakk/Desktop/untitled.txt")));
    f1.writeTo(Paths.get("/home/polinakk/Desktop/untitled.txt"), Paths.get("/home/polinakk/Desktop/untitled2.txt"));
  }
}
