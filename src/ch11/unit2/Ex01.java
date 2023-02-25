package ch11.unit2;

public class Ex01 {
	public static void main(String[] args) {
		//Number는 Integer의 상위 클래스
		Test1<Number> ob1 = new Test1<>();
		Integer i = 100;
		ob1.set(i); //타입 매개변수에 상속 관계는 성립
		System.out.println(ob1.get());
		
		//Integer i2 = ob1.get(); //컴오류 Number를 Integer에 대입 불가
		Integer i2 = (Integer)ob1.get(); //다운 케스팅
		System.out.println(i2);
		System.out.println();
		
		Test1<Integer> ob2 = new Test1<>();
		ob2.set(50);
		System.out.println(ob2.get());
		
		//Test1<Number> ob3 = ob2; //제너릭은 상속관게가 아니라 업케스팅 불가
		// Test1<Number> ob3 = ob1; // 가능 자료형이 같기 때문에
	}
	
}

class Test1<T>{
	private T t;
	
	public void set(T t) {
		this.t=t;
	}
	
	public T get() {
		return t;
	}
}