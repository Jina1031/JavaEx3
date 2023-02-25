package ch10.unit2;

import java.lang.reflect.Constructor;

public class Ex02_reflect {

	public static void main(String[] args) {
		String className;
		
		className = "ch10.unit2.UserImpl";
		execute(className);//합 -> 11
		className = "ch10.unit2.UserImpl2";
		execute(className);//합 -> 55
	}
	
	public static void execute(String className) {
		try {
			Class<?> cls = Class.forName(className);
			//className 클래스의 정보를 가져옴
			
			//객체 생성
			//User u = new UserImpl(); (정적 객체 생성)
			//@SuppressWarnings("deprecation")
			//User u = (User)cls.newInstance(); //JDK 9에서 Deprecated // 인터페이스 down-casting
			
			Constructor<?> con = cls.getDeclaredConstructor();
			//cls를 통해 className 의 생성자를 호출
			User u = (User)con.newInstance();
			//반환값이 Object이기 때문에 down-casting 으로 객체 생성
			
			int s = u.sum(1, 10);
			u.print("합", s);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

interface User {
	public int sum(int a, int b);
	public void print(String title, int result);
}

class UserImpl implements User {

	@Override
	public int sum(int a, int b) {
		return a+b;
	}

	@Override
	public void print(String title, int result) {
		System.out.println(title + " -> " + result);
	}
	
}

class UserImpl2 implements User {

	@Override
	public int sum(int a, int b) {
		int s, t;
		if( a> b) {
			t = a; a = b; b = t;
		}
		
		s= 0;
		for(int i=a; i<=b;i++) {
			s+=i;
		}
		
		return s;
	}

	@Override
	public void print(String title, int result) {
		System.out.println(title + " -> " + result);
	}
	
}
