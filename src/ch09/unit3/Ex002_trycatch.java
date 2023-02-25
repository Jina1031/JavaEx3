package ch09.unit3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex002_trycatch {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		String s;
		int a, b, c;
		
		try {
			System.out.print("첫번째 수? ");
			s = br.readLine();
			a = Integer.parseInt(s);
			
			System.out.print("두번째 수?");
			b= Integer.parseInt(br.readLine());
			
			c=a/b;
			System.out.println(a + "/" + b + "=" + c);
		
		//예외 분류	
		} catch (NumberFormatException e) {
			//문자열을 숫자로 변환할 때 변환하지 못하면 발생하는 unchecked Exception
			//문자를 입력했을 때 발생
			System.out.println("숫자만 입력 가능합니다.");
		} catch (ArithmeticException e) {
			//0으로 나누는 등 산술 연산시 발생하는 unchecked Exception
			//0을 입력했을 때 발생
			System.out.println("0으로 나눌 수 없습니다");
		} catch (IOException e) {
			//readLine()에서 발생하는 checked Exception
			e.printStackTrace();
		} catch (Exception e) {
			//모든 예외를 catch
			e.printStackTrace();
		}
		
		System.out.println("end...");
	}

}
