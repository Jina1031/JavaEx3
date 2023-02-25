package ch09.unit3;

public class Ex006_finally {

	public static void main(String[] args) {
		divide(10, 5);
		//10/5=2
		//the finally bolock must run when it meets return
		divide(10, 0);
		//cant / with 0
		//the finally bolock must run when it meets return
		divide(10, -2); //the finally bolock must run when it meets return
		
	}
	
	public static void divide(final int a, final int b) {
		try {
			if( b < 0) {
				System.out.println("음수 입력 오류입니다.");
				//System.exit(0); // the only way to make finally doesn't run
				return; //never run under the return. but not finally
			}
			
			int c = a / b;
			System.out.println(a+"/"+b+"="+c);
		} catch (ArithmeticException e) {
			System.out.println("0으로 나눌 수 없습니다");
		}finally {
			System.out.println("finally 블록은 return을 만나도 실행 ");
		}
	}
}
