package monday;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Properties {

	public static Map<String, String> parseProperties(File file) throws IOException {
		Map<String, String> propertiesMap = new HashMap<>();
		BufferedReader reader = Files.newBufferedReader(Paths.get(file.getPath()));
		String line = null;
		while ((line = reader.readLine()) != null) {
			if (!line.startsWith("#")) {
				propertiesMap.put(line.split("=",2)[0], line.split("=",2)[1]);
			}
		}
		reader.close();
		return propertiesMap;
	}

	public static void main(String[] args) throws IOException {
		Map<String,String> testMap = new HashMap<>();
		testMap = parseProperties(new File("/home/polinakk/Desktop/untitled.txt"));
		System.out.println(testMap.toString());
	}
}
