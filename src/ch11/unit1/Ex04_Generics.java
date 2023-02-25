package ch11.unit1;

public class Ex04_Generics {
	public static void main(String[] args) {
		Test4<String, Integer> tt = new Test4<>();
		tt.set("서울", 1000);
		tt.disp();
		/*
		 T: java.lang.String, 서울
         U: java.lang.Integer, 1000
		 */
		
		
	}
}

//두 개의 타입 파라미터
class Test4<T, U>{
	private T t;
	private U u;
	
	public void set(T t, U u) {
		this.t=t;
		this.u=u;
	}
	
	public void disp() {
		System.out.println("T: "+t.getClass().getName()+", "+t);
		System.out.println("U: "+u.getClass().getName()+", "+u);
	}
}