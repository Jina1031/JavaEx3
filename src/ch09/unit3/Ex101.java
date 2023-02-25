package ch09.unit3;

public class Ex101 {

	public static void main(String[] args) {
		User11 u = new User11();
		
		u.setValue(-5);
		int n= u.getValue();
		System.out.println(n); // 0 출력
	}
}
//잘못 작성한 코드
class User11 {
	private int value;
	
	public void setValue(int value) {
		if(value < 0) 
			return;
		this.value= value;
	}
	
	public int getValue() {
		return value;
	}
}