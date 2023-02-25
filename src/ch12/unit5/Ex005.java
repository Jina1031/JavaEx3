package ch12.unit5;

import java.util.Iterator;
import java.util.Properties;
/*
 Properties 
 : Hashtable 클래스 상속 받음
 : key와 value가 모두 String일 때만 가능
 : 파일 저장 및 불러오기가 간단해서 환경설정 등에서 사용
 */
public class Ex005 {

	public static void main(String[] args) {
		Properties p = new Properties();
		
		//Properties의 값을 저장
		// : put() 가능은 하지만 사용하지 말 것을 권장
		p.setProperty("스트링", "80");
		p.setProperty("서블릿", "90");
		p.setProperty("오라클", "100");
		p.setProperty("자바", "95");
		p.setProperty("마리아디비", "90");
		
		p.list(System.out);
		System.out.println();
		
		//Properties 값 가져오기
		// : getProperty()
		//전체 가져올 목적으로 쓰지 않음
		String s;
		s=p.getProperty("오라클");
		System.out.println(s);
		System.out.println();
		
		//전체 출력
		Iterator<Object> it = p.keySet().iterator();
		while(it.hasNext()) {
			String key = (String)it.next();
			String value = p.getProperty(key);
			System.out.println("key: "+key+", value: "+ value);
		}
	}

}
