package ch09.unit1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex03_trycatch {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a, b, c;
		
		try {
			System.out.print("두 정수?");
			a = sc.nextInt();
			b = sc.nextInt();
			
			c= a/b;
			System.out.println(a+"/"+b+"="+c);
		
		//예외를 분류
		//InputMismatchException, ArithmeticException
		//: 런타임시 발생하는 예외
		//: uncheked exception (예외처리 필수 아님. 컴파일, 실행에는 문제 없음) 	
		} catch (InputMismatchException e) { //정수가 아닌 수를 입력했을 때
			System.out.println("정수만 입력 가능합니다");
		} catch (ArithmeticException e) {    //정수에 0을 입력했을 때
			System.out.println("0으로 나눌 수 없습니다.");
		} catch (Exception e) {              //위에서 걸러지지 않는 예외를 처리
			e.printStackTrace();
		} finally {
			System.out.println("예외 발생 유무와 상관없이 실행...");
			sc.close();
		}
		
		System.out.println("end...");
		
	}

}
