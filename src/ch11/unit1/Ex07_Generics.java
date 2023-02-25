package ch11.unit1;

public class Ex07_Generics {
	public static void main(String[] args) {
		Test7 t = new Test7();
		t.disp(100); //java.lang.Integer, 100
		t.disp("서울"); //java.lang.String, 서울
		t.sub(100);
		//t.sub("서울"); //컴오류 
	}
}

//제너릭 메소드
//메소드의 자료형이 결정나지 않음
//접근제어자 파라미터 리턴타입 메소드명
class Test7 {
	public <U> void disp(U u) {
		System.out.println(u.getClass().getName()+ ", "+ u);
	}
	
	public <U extends Number> void sub(U u) {
		System.out.println(u.getClass().getName()+", "+u);
	}
}