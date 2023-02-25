package ch12.unit5;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
 - Map
  : key + value
  : key는 중복을 허용하지 않음
  : key는 순서가 없음
  : 반복자가 없음(향상된 for문 사용 불가)
 - 구현 클래스
  : HashMap : 동기화 지원 안됨
  : Hashtable : 동기화 지원
  : LinkedHashMap : key가 등록 순서 유지
  : TreeMap : key는 순서로 정렬. key는 Comparable 인터페이스가 구현되어 있어야 함
 */
public class Ex001_HashMap {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		
		//put(key, value) 데이터 입력
		map.put("서울", 1000);
		map.put("부산", 350);
		map.put("대구", 250);
		map.put("인천", 330);
		map.put("광주", 150);
		map.put("대전", 150);
		map.put("서울", 950); //key가 중복되면 value를 덮어씀
		
		System.out.println(map); //{대전=150, 서울=950, 부산=350, 대구=250, 인천=330, 광주=150}

		//get 데이터 가져오기
		int a = map.get("서울");
		System.out.println(a); //950

		//a = map.get("세종");
		//System.out.println(a); // runtime exception 발생
		
		Integer n = map.get("세종");
		System.out.println(n); //null
		
		// Map에는 반복자(Iterator)가 없음
		// 향상된 for문장 사용 불가
		// Set<String> set = map.keySet(); 에서 key에 대한 Set 객체를 반환 받아
		// 처음부터 끝까지 순회 가능
		Set<String> set = map.keySet(); //key에 대한 Set 객체
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			String s = it.next(); // key
			int v = map.get(s);   //value
			System.out.println("s: "+s+", v: "+v);
			/*
			 s: 대전, v: 150
             s: 서울, v: 950
             s: 부산, v: 350
             s: 대구, v: 250
             s: 인천, v: 330
             s: 광주, v: 150
			 */
		}
		System.out.println();
		
		for(String key : map.keySet()) {
			int value = map.get(key);
			System.out.println("key: "+ key +", value: "+ value);
			/*
			key: 대전, value: 150
			key: 서울, value: 950
			key: 부산, value: 350
			key: 대구, value: 250
			key: 인천, value: 330
			key: 광주, value: 150
			*/

		}
		System.out.println();
		
		System.out.println("key에 서울이 있나요? "+map.containsKey("서울")); //key에 서울이 있나요? true
		System.out.println("key에 경기가 있나요? "+map.containsKey("경기")); //key에 경기가 있나요? true
		System.out.println("value에 330이 있나요? "+map.containsValue(330)); //value에 330이 있나요? true
		
		//대전 삭제
		map.remove("인천"); //key가 인천인 객체 삭제. 삭제된 객체 반환
		System.out.println(map); //{대전=150, 서울=950, 부산=350, 대구=250, 광주=150}
		System.out.println("전체 개수: "+map.size()); //전체 개수: 5
		
		//전체 삭제
		map.clear();
		System.out.println("전체 개수: "+map.size()); //전체 개수: 0
		
	}

}
