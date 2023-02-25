package ch11.unit1;

public class Ex06_Generics {
	public static void main(String[] args) {
		Test6<Integer> t = new Test6<>();
		t.set(10);
		int a = t.get();
		System.out.println(a);
		
		//Test6<String> t2 = new Test6<>(); //String은 Number클래스의 하위 클래스가 아님
		
	}
}

//제한된 타입 파라미터
// : Number를 상속 받은 클래스만 가능
// : Integer, Long, Double... 
class Test6<T extends Number> {
	private T t;
	
	public void set(T t) {
		this.t=t;
	}
	
	public T get() {
		return t;
	}
}