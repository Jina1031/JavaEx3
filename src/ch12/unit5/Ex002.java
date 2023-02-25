package ch12.unit5;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Ex002 {

	public static void main(String[] args) {
		
		Map<String, Integer> map = new HashMap<>();
		map.put("자바", 80);
		map.put("오라클", 90);
		map.put("빅데이터", 100);
		map.put("서블릿", 70);
		map.put("스프링", 80);
		
		System.out.println("map...");
		System.out.println();
		
		//key를 set 안으로
		Set<String> set = map.keySet();
		System.out.println("\nkey를 set안으로...");
		System.out.println(set); //[오라클, 스프링, 서블릿, 자바, 빅데이터]
		
		//map의 value를 List로...
		List<Integer> list = new LinkedList<>(map.values());// map.values()의 반환값은 Collection
		System.out.println("\nvalue를 List로....");
		System.out.println(list); //[90, 80, 70, 80, 100]
		
		//value를 collection으로..
		Collection<Integer> col = map.values();
		for(Integer i : col) {
			System.out.print(i + " "); //90 80 70 80 100 
		}
		System.out.println();
		
		System.out.println("최댓값: "+Collections.max(col)); //최댓값: 100
		System.out.println("최소값: "+Collections.min(col)); //최소값: 70
		
	}

}
