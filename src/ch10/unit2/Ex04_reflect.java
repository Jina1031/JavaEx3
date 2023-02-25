package ch10.unit2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Ex04_reflect {
	public static void main(String[] args) {
		/*
		Test t = new Test();
		int a = t.sub(10, 5);
		t.write("차", a);
		*/
		
		try {
			String className = "ch10.unit2.Test";
			
			Class<?> cls = Class.forName(className);
			
			//Constructor<?> con = cls.getConstructor(); // public 생성자만 가능, default 생성자 Runtime Exception 발생
			Constructor<?> con = cls.getDeclaredConstructor(); // public, default, private 생성자 모두 접근 가능
			
			Object obj = con.newInstance();
			//System.out.println(obj); //ch10.unit2.Test@7c30a502
			
			//메소드 정의
			                                        //(메소드명 , 피리미터 타입)
			//Method m1 = cls.getDeclaredMethod("hap", Integer.class, Integer.class);
			Method m1 = cls.getDeclaredMethod("hap", new Class[] {Integer.class, Integer.class});
			Method m2 = cls.getDeclaredMethod("sub", int.class, int.class);
			Method m3 = cls.getDeclaredMethod("write", String.class, int.class);
			Method m4 = cls.getDeclaredMethod("print"); // 메소드 파라미터가 없는 경우
			
			//메소드 호출
			Object rt1 = m1.invoke(obj, 20, 5);
			m3.invoke(obj, "합", rt1);//합->25
			
			int rt2 = (int)m2.invoke(obj, 20, 5);
			m3.invoke(obj, "차", rt2); //차->15
			
			m4.invoke(obj); //print...
			
			
			
			
					
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class Test {
	public Integer hap (Integer a, Integer b) {
		return a + b;
	}
	
	public int sub(int a, int b) {
		return a - b;
	}
	
	public void write(String title, int result) {
		System.out.println(title + "->" + result);
	}
	
	public void print() {
		System.out.println("print...");
	}
}