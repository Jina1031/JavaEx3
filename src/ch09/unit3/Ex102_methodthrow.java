package ch09.unit3;

public class Ex102_methodthrow {

	public static void main(String[] args) {
		User12 obj = new User12();
		
		//obj.setValue(-5); //컴파일 오류 발생 checked exception 발생 시켰기 때문
		
		try {
			obj.setValue(-5);
			int n = obj.getValue();
			System.out.println(n);
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println(e.toString()); // 0이상만 가능합니다.
		} 
		System.out.println("end...");
	}
}

//잘못 작성한 코드
class User12 {
	private int value;
	// throw : 예외를 일으키는 것
	// throws : 메소드를 호출하는 곳에서 예외를 catch 하도록 하는 것
	public void setValue(int value) throws Exception { //메소드 호출하는 곳에서 발생시킨 예외를 catch하도록 설정
		if(value < 0) {
			// 강제로 checked exception 발생
			// 즉 예외를 일부러 발생 시키는 것
			throw new Exception("0이상만 가능합니다.");
		}
		this.value= value;
	}
	
	public int getValue() {
		return value;
	}
}