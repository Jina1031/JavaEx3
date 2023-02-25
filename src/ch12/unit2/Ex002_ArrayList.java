package ch12.unit2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex002_ArrayList {
	public static void main(String[] args) {
	
		List<String> list1 = new ArrayList<>();
		list1.add("서울");
		list1.add("부산");
		list1.add("대구");
				
		List<String> list2 = new ArrayList<>();
		list2.add("강원");
		list2.add("경기");
		list2.add("경상");
		
		//list 2에 list1에 있는 걸 추가
		list2.addAll(list1);
		System.out.println(list2); //[강원, 경기, 경상, 서울, 부산, 대구]
		
		//List<String> -> String[]
		//toArray 배열의 크기(사이즈)를 넘겨줘야 함. 배열의 주소까지 넘겨줌
		String[] ss = list2.toArray(new String[list2.size()]);
		System.out.println("\n리스트를 배열로...");
		for(String s : ss) {
			System.out.print(s+" "); //강원 경기 경상 서울 부산 대구 
		}
		System.out.println();
		
		//String[] -> List<String>
		List<String> list3 = Arrays.asList(ss); // java.util.Arrays$ArrayList (중첩 클래스)
		System.out.println("배열을 리스트로 : "+list3);// 배열을 리스트로 : [강원, 경기, 경상, 서울, 부산, 대구]
		
		System.out.println(list1.getClass().getName()); // java.util.ArrayList
		System.out.println(list3.getClass().getName()); // java.util.Arrays$ArrayList (중첩 클래스)
		                                                // ArraysList로 down-casting 불가
		
		//list3이 가지고 있는 내용 중에서 특정 부분만 추출
		//subList(a, b) -> index a에서 index b-1까지
		List<String> list4 = list3.subList(1, 4);
		System.out.println(list4);//[경기, 경상, 서울]
		
		list1.clear();
		System.out.println("전체 삭제 후 list1.size:"+ list1.size()); //0
		
		System.out.println("삭제 전: "+list2);//삭제 전: [강원, 경기, 경상, 서울, 부산, 대구]
		list2.subList(1, 4).clear();
		//list3.subList 는 runtime exception 발생. 클래스가 다르기 때문. 
		System.out.println("삭제 후: "+list2);//삭제 후: [강원, 부산, 대구]
		
		
		
	}
}

