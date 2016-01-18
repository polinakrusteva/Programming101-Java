package monday;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
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
		BufferedReader reader = Files.newBufferedReader(Paths.get(file.getPath()));
		String line = null;
		while ((line = reader.readLine()) != null) {
			sb.append(line);
		}
		reader.close();
		return sb.toString();
	}

	public String readFrom(Path path) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader reader = Files.newBufferedReader(path);
		String line = null;
		while ((line = reader.readLine()) != null) {
			sb.append(line);
		}
		reader.close();
		return sb.toString();
	}

	public void writeTo(File source, File output) throws IOException{
		BufferedWriter writer = Files.newBufferedWriter(Paths.get(output.getAbsolutePath()));
		writer.write(readFrom(source));
		writer.close();
	}
	
	public void writeTo(Path source, Path output) throws IOException{
		BufferedWriter writer = Files.newBufferedWriter(output);
		writer.write(readFrom(source));
		writer.close();
	}
	
	public static void main(String[] args) throws IOException {
		FileUtils f1 = new FileUtils();
		System.out.println(f1.readFrom(new File("/home/polinakk/Desktop/untitled.txt")));
		f1.writeTo(Paths.get("/home/polinakk/Desktop/untitled.txt"), Paths.get("/home/polinakk/Desktop/untitled2.txt"));
	}
}
