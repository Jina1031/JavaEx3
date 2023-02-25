package ch09.unit3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex001_trycatch {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// System.in = 바이트 스트림
		// InputStreamReader = 바이트를 문자로 만들어줌
		// BufferedReader = Buffer로 입력 받아서 속도가 빠름
		// 대신 문자로만 입력 가능. 숫자로 바꾸고 싶으면 Integer.to
		String s;
		int a, b, c;
		
		//System.out.println("정수? ");
		//s = br.readLine(); ////IOException 발생이라고 컴파일 오류(checked exception)
		
		try {
			System.out.print("첫번째 수? ");
			s = br.readLine();
			//readLine() 은 checked exception이 발생하므로 예외처리 필수
			a = Integer.parseInt(s);
			//문자열로 받았기 때문에 int로 바꿔줘야함
			//문자열을 정수로 변경하지 못하면 NumberFormatException 발생 (unchecked exception)
			
			System.out.print("두번째 수?");
			b= Integer.parseInt(br.readLine());
			
			c=a/b;
			//0으로 나눌 경우 ArithmeticException 발생 (unchecked exception)
			
			System.out.println(a + "/" + b + "=" + c);
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		System.out.println("end...");
	}

}
