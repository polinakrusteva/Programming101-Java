package monday;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WordCountResult {
#some
	private int words;
	private int lines;
	private int characters;

	public int getWords(String str) {
		String[] subStr = str.split(" ");
		return subStr.length;
	}

	public void setWords(int words){
		this.words += words;
	}

	public int getLines(){
		return this.lines;
	}

	public void setLines(int lines){
		this.lines = lines;
	}

	public int getCharacters(String str) {
		String[] subStr = str.split(" ");
		int carCount = 0;
		for (String string : subStr) {
			carCount += string.length();
		}
		return carCount;
	}

	public void setCharacters(int characters){
		this.characters += characters;
	}

	public WordCountResult wordCount(Path path) throws IOException{
		BufferedReader reader = Files.newBufferedReader(path);
		WordCountResult temp = new WordCountResult();
		int lines = 0;
		String line = null;
		while ((line = reader.readLine()) != null) {
			lines++;
			temp.setCharacters(getCharacters(line));
			temp.setWords(getWords(line));
		}
		temp.setLines(lines);
		System.out.println("Lines: " + temp.lines + ", Words: " + temp.words + ", Characters: "+ temp.characters);
		reader.close();
		return temp;
	}

	public static void main(String[] args) throws IOException {
		WordCountResult testCount = new WordCountResult();
		testCount.wordCount(Paths.get("/home/polinakk/Desktop/untitled2.txt"));
	}
}
