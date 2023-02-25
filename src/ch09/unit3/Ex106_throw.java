package ch09.unit3;

public class Ex106_throw {

	public static void main(String[] args) {
		User16 obj = new User16();
/*		
		obj.setValue(-5);
		// value가 음수이면 RuntimeException 예외를 발생
		// 예외를 처리하지 않았으므로 이곳에서 비정상적인 프로그램 종료
		
		int n = obj.getValue();
		System.out.println(n);
		System.out.println("end...");
*/	
	
		try {
			obj.setValue(-5);
			
			int n = obj.getValue();
			System.out.println(n);
		} catch (Exception e) {
			System.out.println(e.getMessage()); //0이상만 가능합니다
		}
		System.out.println("end...");
	}

}

class User16 {
	private int value;
	
	public void setValue(int value) {
		if(value < 0) {
			// 숫자가 음수이면 RuntimeException 예외를 발생
			// RuntimeException 예외는 unchecked exception으로 반드시 catch 할 필요 없음
			// throws 해도 그만, 안 해도 그만. 의미 없음
			throw new RuntimeException("0이상만 가능합니다");
		}
 		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
}
