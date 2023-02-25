package ch12.unit2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 -ArrayList
  : List 인터페이스 구현 클랫, 동기화 되지 않음
  : 검색시 속도가 빠름  
 -LinkedList
  : List 인터페이스 구현 클랫, 동기화 되지 않음
  : 검색할 때는 속도가 느림(데이터를 주소로 찾아가기 때문)
  : 앞에서 추가하고 뒤에서 삭제하는 작업이 빈번한 경우 빠름
  : 앞, 뒤 아무데서나 추가 삭제가 빈번한 경우 빠름
  : 중간에서 삽입, 삭제가 현저하면 속도가 현저히 떨어짐
  
  굳이 서로 차이 많이 나는 거 아니기 때문에 뭘 사용하던 상관 없음.
  소스 변화 없음.
 */
public class Ex003_LinkedList {

	public static void main(String[] args) {
		List<String> list1 = new ArrayList<>();
		list1.add("자바");
		list1.add("오라클");
		list1.add("스프링");
		System.out.println("ArrayList...");
		
		List<String> list2 = new LinkedList<>();
		list2.add("CSS");
		list2.add("HTML5");
		list2.add("javascript");
		System.out.println("LinkedList...");
		
	}
	
	public static void print(List<String> list) { // ArrayList LinkedList Vector 다 가능. 
		for(String s : list) {
			System.out.print(s+" ");
		}
		System.out.println();
	}
}
