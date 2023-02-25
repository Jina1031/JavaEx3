package ch12.unit2;

import java.util.Vector;

public class Ex005_Vector {

	public static void main(String[] args) {
		//동기화 지원
		//멀티 쓰레드에서 안전하기 때문에 사용
		//List<String> list = new Vector<>(); 오류날 수도 있음
		Vector<String> list = new Vector<>();
		
		System.out.println("초기 용량 : "+list.capacity()); //10
		
		list.add("a1");
		list.add("a2");
		list.add("a3");
		list.add("a4");
		list.add("a5");
		list.add("a6");
		list.add("a7");
		list.add("a8");
		list.add("a9");
		list.add("a10");
		list.add("a11");
		list.add("a12");
		list.add("a13");

		System.out.println("개수 : "+list.size()); //13
		System.out.println("용량 : "+list.capacity()); //20

		
		list.add(0, "자바");
		System.out.println(list); //[자바, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13]
		
		System.out.println("처음(get(0)) : "+list.get(0)); //자바
		System.out.println("처음(firstElement()) : "+list.firstElement()); //자바
		
		System.out.println("마지막(get(list.size()-1)) : "+list.get(list.size()-1)); //a13
		System.out.println("처음(lastElement()) : "+list.lastElement()); //a13
		
		System.out.println("전체 ...");
		for(String s:list) {
			System.out.print(s+" "); //자바 a1 a2 a3 a4 a5 a6 a7 a8 a9 a10 a11 a12 a13 
		}
		System.out.println();
		
		list.remove(3);
		list.remove("a7");
		System.out.println(list.size()); //12
		System.out.println(list.capacity()); //20
		
		//trimToSize()
		// : 벡터의 용량을 벡터의 데이터 개수로 조정하는 것
		list.trimToSize();
		System.out.println(list.capacity()); //12
		
	}

}
