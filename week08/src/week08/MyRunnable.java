package week08;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MyRunnable implements Runnable{

	private List<Integer> sortList;
	
	public MyRunnable() {
		sortList = new LinkedList<>();
		for(int i = 0; i< 1_000_000;i++){
			sortList.add(i);
		}
		Collections.shuffle(sortList);
	}
	
	@Override
	public void run() {
		Collections.sort(sortList);
		//TODO parallel sort
	}

}
