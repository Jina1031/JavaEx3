package ch11.unit1;

public class Ex03_Generics {
	public static void main(String[] args) {
		Test3<String> t1 = new Test3<>(); // String 이라는 자료형으로 결정
		//Test3<String> t1 = new Test3<String>(); // 뒤에는 생략 가능
		t1.set("서울");
		//t1.set(100); //컴오류 발생
		String s = t1.get(); //캐스팅 불 필요
		System.out.println(s);

		Test3<Integer> t2 = new Test3<>(); // Integer 이라는 자료형으로 결정
		t2.set(100);
		Integer i = t2.get();
		System.out.println(i);

		/*
		Test3 t3 = new Test3(); // Object로 처리. 가능은 하지만 경고 발생.
		t3.set("서울");
		t3.set(100);
		*/
	}
}
/*
  Generics(하나의 타입 파라미터)
  : 클래스명<> = 제너릭.
  : 자료형이 결정되지 않은 상태
  : 객체를 생성할 때 (실행 시에) 자료형 결정
 */
class Test3<T> {
	private T t;
	
	public void set(T t) {
		this.t=t;
	}
	
	public T get() {
		System.out.println(t.getClass());
		return t;
	}
}