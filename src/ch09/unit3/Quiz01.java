package ch09.unit3;

import java.util.Scanner;

/*
 첫번째 수? 10
 두번째 수? 5
 연산자 [+-*'/']? +
 10 + 5 = 15;
*/
public class Quiz01 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int a, b, c = 0;
		String s;
		
		try {
			System.out.print("첫번째 정수를 입력하세요");
			a= sc.nextInt();
			System.out.print("두번째 정수를 입력하세요");
			b= sc.nextInt();
			
			System.out.print("연산자를 입력하세요[+-*/]"); //연산자에 다른 게 들어갔을 경우 예외 처리가 안남
			s = sc.next();
			
			switch(s) {
			case ("+") : c = a+b; break; 
			case ("-") : c = a-b; break; 
			case ("/") : c = a/b; break; 
			case ("*") : c = a*b; break;
			}
			System.out.println(a + s + b + "=" + c);
			
		} catch (NumberFormatException e) { 
			System.out.println("숫자만 가능합니다.");
		} catch (ArithmeticException e) { 
			System.out.println("0은 나눗셈 연산이 불가합니다.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}
	}
}
