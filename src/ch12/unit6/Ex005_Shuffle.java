package ch12.unit6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ex005_Shuffle {

	public static void main(String[] args) {
		//List<> shuffle 
		List<String> list = new ArrayList<>();
		
		list.add("java");
		list.add("spring");
		list.add("html");
		list.add("css");
		list.add("javascript");
		System.out.println("shuffle 전: "+ list);
		
		Collections.shuffle(list);
		System.out.println("shuffle 후"+list);
	}

}
