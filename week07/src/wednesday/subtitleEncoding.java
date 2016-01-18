package wednesday;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class subtitleEncoding {

	public static String readFrom(Path path) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader reader = Files.newBufferedReader(path);
		String line = null;
		while ((line = reader.readLine()) != null) {
			sb.append(line);
		}
		reader.close();
		return sb.toString();
	}
	
	public static void writeTo(String text, Path output) throws IOException{
		BufferedWriter writer = Files.newBufferedWriter(output);
		writer.write(text);
		writer.close();
	}

	
	public static void fixEncoding() throws IOException{
		String text = new String(Files.readAllBytes(Paths.get("/home/polinakk/Desktop/lost.s04e11.hdtv.xvid-2hd.srt")));
		String result = new String(text.getBytes(),StandardCharsets.UTF_8);
		writeTo(result, Paths.get("/home/polinakk/Desktop/fixedsubs.srt"));
	}
	public static void main(String[] args) throws IOException {
		fixEncoding();
	}
}
	