package ch11.unit2;

public class Ex02 {

	public static void main(String[] args) {
		Test2<Integer> t1 = new Test2<>();
		t1.set(100);
		disp(t1); //100 //Test2<Integer> obj
		
		Test2<String> t2 = new Test2<>();
		t2.set("서울");
		disp(t2); //서울 //Test2<String> obj
	}
	
	// 제너릭-와일드 카드
	// ? : 모든 클래스나 인터페이스 가능
	//   : 제너릭 타입에 의존적이지 않는 메소드를 호출할 때 사용
	//   : 읽기 전용(있는 값을 가져오는 것만 가능)
	public static void disp(Test2<?> obj) {
		obj.print();
		// obj.set(100); //컴파일 오류. 자료형이 결정되지 않음
	}
}

class Test2<T>{
	private T t;
	public void set(T t) {
		this.t=t;
	}
	
	public T get() {
		return t;
	}
	
	public void print() {
		System.out.println(t);
	}
}
