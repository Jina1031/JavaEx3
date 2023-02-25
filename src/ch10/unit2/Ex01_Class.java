package ch10.unit2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Ex01_Class {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String className;
		
		try {
			
			// Class 클래스
			// : 클래스나 인터페이스의 메타 정보를 검색할 수 있는 메소드 제공
			// : 상위 클래스는 무엇인지, 메소드는 무엇인지, 필드는 무엇인지 등
			
			/*
			String 클래스의 정보 얻기
			1. 컴파일 단계에서 클래스의 정보를 알고 있는 경우(정적)
			   => Class<?> cls = String class;
			2. 런타임시 문자열로 클래스의 정보를 넘겨 받는 경우(패키지명 반드시 포함)(동적)
			   => Class<?> cls = Class.forName("java.lang.String");
			   * <?> 제네릭
			*/
			
			System.out.print("패키지명을 포함한 클래스명?");
			className = br.readLine();
			Class<?> cls = Class.forName(className);
			
			//Class<?> cls = Class.forName("java.lang.String");
			
			System.out.println("상위 클래스...");
			if(cls.getSuperclass() != null) {
				System.out.println(cls.getSuperclass().getName());
			}
			
			System.out.println("\n인터페이스...");
			for(Class<?> c : cls.getInterfaces()) {
				System.out.println(c.getName());
			}
			
			System.out.println("\n생성자...");
			Constructor<?>[] cc = cls.getConstructors();
			for(Constructor<?> c : cc) {
				System.out.println(c);
			}
			
			System.out.println("\n필드...");
			Field[] ff = cls.getDeclaredFields(); //접근제어자 private 포함
			//Field[] ff = cls.getFields(); //접근 제어자 public만
			for(Field f: ff) {
				System.out.println(f);
			}
			
			System.out.println("\n메소드...");
			Method[] mm = cls.getDeclaredMethods(); //접근제어자 private 포함
			//Method[] mm = cls.getMethods(); //접근 제어자 public만
			for(Method m : mm) {
				System.out.println(m);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
