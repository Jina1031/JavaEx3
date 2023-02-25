package ch11.unit1;

public class Ex05_Generics {
	public static void main(String[] args) {
		TestImpl5<Integer> obj = new TestImpl5<>();
		obj.print(10);
		
		DemoImpl5 obj2 = new DemoImpl5();
		obj2.print("서울");
	}
}

//제너릭 인터페이스
//구현하는 클래스마다 객체 타입을 다르게 할 수 있음
interface Test5<T> {
	public void print(T t);
}

//구현 1
class TestImpl5<T> implements Test5<T>{
	
	@Override
	public void print(T t) {
		System.out.println(t);
	}
}

//구현 2
class DemoImpl5 implements Test5<String>{
	
	@Override
	public void print(String t) {
		System.out.println(t);
	}
}