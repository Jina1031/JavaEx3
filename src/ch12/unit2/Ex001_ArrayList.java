package ch12.unit2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/*
 List 인터페이스
 : 순서가 있음
 : 배열과 유사한 구조
 : 가변 길이(용량이 부족하면 자동으로 공간이 늘어남)
 : 중복 데이터 가능
 : 처음, 중간에 추사/삭제 가능
 : 주요 구현 클래스 - ArrayList, Vector, LinkedList, Stack
 : 동기화 지원 (다중 스레드 환경에서 안전) - Vector
 : 동기화 지원하지 않음(다중 스레드 환경에서 안전하지 않음) -ArrayList, LinkedList
 
 */
public class Ex001_ArrayList {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		String s;
		
		//add() 마지막에 추가
		list.add("서울");
		list.add("부산");
		list.add("인천");
		list.add("서울"); // 중복 데이터 추가 가능
		list.add("광주");
		list.add("대전");
		System.out.println(list); //[서울, 부산, 인천, 서울, 광주, 대전]
		
		//index 2 에 데이터 추가
		//add(index, )원하는 위치에 데이터 추가
		list.add(2, "대구");
		System.out.println(list); //[서울, 부산, 대구, 인천, 서울, 광주, 대전]
		
		//데이터 개수
		System.out.println(list.size()); //7
		
		//index 데이터 반환
		s = list.get(0);
		System.out.println(s); //서울

		s = list.get(1);
		System.out.println(s); //부산
		
		s = list.get(list.size()-1);
		System.out.println(s); //대전
		
		//원하는 위치에 데이터 추가
		list.add(0, "한국");
		System.out.println(list); //[한국, 서울, 부산, 대구, 인천, 서울, 광주, 대전]
		
		//데이터 수정
		list.set(0, "대한민국");
		System.out.println(list); //[대한민국, 서울, 부산, 대구, 인천, 서울, 광주, 대전]
		
		// 인덱스 추출
		int idx; 
		idx = list.indexOf("인천");
		System.out.println("인천 위치: "+ idx); //4
		
		idx = list.indexOf("세종");
		System.out.println("세종 위치: "+ idx); //-1
		
		idx = list.indexOf("서울");
		System.out.println("서울 위치: "+ idx); //1

		idx = list.lastIndexOf("서울");
		System.out.println("서울 위치: "+ idx); //5
		
		//부산이 있나요
		System.out.println("부산이 있나요? "+ list.contains("부산")); //부산이 있나요? true
		
		//특정 인덱스 삭제
		//list.remove(0);
		list.remove("대한민국");
		System.out.println(list); //[서울, 부산, 대구, 인천, 서울, 광주, 대전]
		
		//list 전체 출력
		System.out.println("\n전체 출력 1");
		for(String str : list) {
			System.out.print(str+ " "); //서울 부산 대구 인천 서울 광주 대전
		}
		System.out.println();
		
		System.out.println("\n전체 출력 2");
		for(int i=0; i<list.size();i++) {
			System.out.print(list.get(i)+ " "); //서울 부산 대구 인천 서울 광주 대전 
		}
		System.out.println();
		
		System.out.println("\n전체 출력 3");
		//반복자(데이터를 처음부터 끝까지 순회하는 거라고 생각하면 됨)
		Iterator<String> it = list.iterator(); //순방향만 검색 가능
		while(it.hasNext()) { //다음에 데이터가 존재하는한 계속 true
			String a = it.next();
			System.out.print(a+" ");
		}
		System.out.println();
		
		System.out.println("\n전체 역순 출력 1");
		for(int i=list.size()-1; i>=0;i--) { //역순으로 출력
			System.out.print(list.get(i)+ " "); //대전 광주 서울 인천 대구 부산 서울 
		}
		System.out.println();
		
		System.out.println("\n전체 역순 출력 2"); 
		// ListIterator : 순방향 역방향 모두 이동 가능
		// 반복자의 위치를 가장 뒤로 이동
		ListIterator<String> it2 = list.listIterator(list.size()); //역순으로 출력
		while(it2.hasPrevious()) {
			String a = it2.previous();
			System.out.print(a+" "); //대전 광주 서울 인천 대구 부산 서울
		}
		System.out.println();
		
		//모두 지우기
		list.clear();
		System.out.println(list.size()); //0
	}

}
