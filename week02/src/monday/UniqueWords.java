package monday;

import java.util.HashMap;
import java.util.Map;

public class UniqueWords {
	
	public static int uniqueWordsCount(String[] arr){
		Map<String, Integer> words = new HashMap<>();
		for(int i = 0; i < arr.length; i++){
			if(words.containsKey(arr[i])){
				words.put(arr[i], words.get(arr[i]) + 1);
			} else {
				words.put(arr[i], 1);
			}
		}
		return words.size();
	}
	
	public static void main(String[] args) {
		System.out.println(uniqueWordsCount(new String[] {"apple", "banana", "apple", "pie"}));
		System.out.println(uniqueWordsCount(new String[] {"java", "java", "java", "android"}));
		System.out.println(uniqueWordsCount(new String[] {"HELLO!", "HELLO!", "HELLO!", "HELLO!"}));
	}
	
}
