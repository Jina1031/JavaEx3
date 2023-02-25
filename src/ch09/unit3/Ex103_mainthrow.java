package ch09.unit3;

public class Ex103_mainthrow {

	public static void main(String[] args) throws Exception { //main에게 exception을 catch 하도록 함
		User13 obj = new User13();
		
		// 위 처럼 main() 메소드에서 예외를 throws 하면 JVM에서 예외를 catch
		// 프로그램은 비정상적으로 종료되어 end를 출력되지 않는다
		
		obj.setValue(-5); //Exceptoin checked exception 발생
		int n = obj.getValue();
		System.out.println(n);
		
		System.out.println("end...");
	}
}

//잘못 작성한 코드
class User13 {
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