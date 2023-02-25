package ch12.unit6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ex001_sort {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		
		list.add("서울");
		list.add("부산");
		list.add("대구");
		list.add("광주");
		list.add("대전");
		list.add("울산");
		list.add("세종");
		System.out.println("정렬 전: "+list);
		
		int idx;
		String s;
		
		// 순차검색
		idx = list.indexOf("울산"); //없으면 -1
		System.out.println(idx);
		
		// 정렬 : Comparable 인터페이스가 구현된 클래스만 가능
		// Collections : 컬렉션과 관련된 유용한 메소드를 제공
		Collections.sort(list);
		System.out.println("정렬 후: "+list);
		
		//이분 검색: 정렬되어 있어야 가능
		s = "서울";
		idx = Collections.binarySearch(list, s); //없으면 -1
		System.out.println(s + "위치 : "+idx);
		
		//역순 정렬
		Collections.sort(list, Collections.reverseOrder());
		System.out.println("역순 정렬: "+list);
	}
}
