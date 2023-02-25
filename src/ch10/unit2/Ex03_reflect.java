package ch10.unit2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Ex03_reflect {

	public static void main(String[] args) {
		String className = "ch10.unit2.Book";
		
		try {
			Class<?> cls = Class.forName(className);
			
			System.out.println("Constructor를 이용한 객체 생성...");

			//인자가 없는 public 생성자를 이용하여 객체 생성
			Constructor<?> con = cls.getConstructor(/*인자가 있는 경우 여기에 기술*/); //default 생성자
			Book b1 = (Book)con.newInstance();
			b1.disp(); //책이름 - 자바
			System.out.println();
			
			//인자가 있는 public 생성자를 이용하여 객체 생성
			Constructor<?> con2 = cls.getConstructor(String.class); //인자가 하나인 생성자
			Book b2 = (Book)con2.newInstance("스프링");
			b2.disp(); //책이름 - 스프링
			System.out.println();
			
			//static 필드 접근
			System.out.println("static 필드 접근...");
			Field f2 = cls.getDeclaredField("publisher"); //필드의 객체
			
			//static 값 가져오기
			String s = (String)f2.get(null); //static 필드는 null
			System.out.println("static 필드 값: "+s); //static 필드 값: 너자바
			
			//static 값 변경하기
			f2.set(null, "사랑");
			s = (String)f2.get(null);
			System.out.println("static 변경된 필드 값: "+s); //static 변경된 필드 값: 사랑
			
			//private 필드 접근
			System.out.println("private 필드 접근...");
			Field f3 = cls.getDeclaredField("subject"); 
			f3.setAccessible(true);//private 필드를 접근할 수 있도록 설정
			
			//private 값 가져오기
			s = (String)f3.get(b1); // 값을 가져올 객체 =b1 / 위에서 생성한 Book 의 객체
			System.out.println("private 필드 값: "+s); //static 필드 값: 너자바
			
			//private 값 변경
			f3.set(b1, "오라클");
			s=(String)f3.get(b1);
			System.out.println("private 변경된 필드 값: "+s);
			
			System.out.println("private 메소드 접근...");
			Method m1 = cls.getDeclaredMethod("bookName"); 
			//Method m1 = Book.class.getDeclaredMethod("bookName");
			m1.setAccessible(true); //private 메소드 접근하도록 설정
			
			//b1 객체의 메소드 호출
			s = (String)m1.invoke(b1); //invoke() : 메소드 호출
			System.out.println("private 메소드: "+s);
			
			System.out.println("메소드 접근...");
			Method m2 = cls.getDeclaredMethod("amt", int.class, int.class);
			int n = (int)m2.invoke(b1, 10, 5000);
			System.out.println("메소드 호출 : "+ n);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}

class Book {
	public static String publisher = "너자바";
	private String subject = "자바";
	
	public Book() { //default 생성자가 명시적으로 없으면 Constructor로 객체 생성 불가
	}
	
	public Book(String subject) {
		this.subject = subject;
	}
	
	public int amt(int su, int price) {
		return su * price;
	}
	
	private String bookName() { // 외부 접근 불가
		return subject;
	}
	
	public void disp() {
		System.out.println("책이름 - " + bookName());
	}
}
