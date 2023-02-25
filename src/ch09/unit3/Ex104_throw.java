package ch09.unit3;

public class Ex104_throw {

	public static void main(String[] args) {
		User14 obj = new User14();

		obj.setValue(-5);
		int n = obj.getValue();
		System.out.println(n); //0 나옴
		System.out.println("end...");
	}
}

class User14 {
	private int value;
	
	public void setValue(int value) { 
		try {
			if(value < 0) {
				
				throw new Exception("0이상만 가능합니다."); // 예외를 메소드에서 잡아서 처리함
			}
			
			this.value= value; //value 초기값 0
			
		} catch (Exception e) {
			//위에서 throws한 예외를 이곳에서 catch 함
			System.out.println(e.toString());
		}
	}
	
	public int getValue() {
		return value;
	}
}