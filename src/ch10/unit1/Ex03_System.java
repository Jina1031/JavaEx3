package ch10.unit1;

import java.util.Enumeration;
import java.util.Properties;

public class Ex03_System {

	public static void main(String[] args) {
		//내가 가진 환경설정 값 보여주는 것. 
		Properties p = System.getProperties(); //모든 프로퍼티(환경설정)
		Enumeration<?> e = p.propertyNames(); //프로퍼티 이름
		while(e.hasMoreElements()) {
			String key = (String)e.nextElement();
			String value = p.getProperty(key);
			System.out.println(key + "==>" + value);
		}
		
	}

}
