package ch09.unit3;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
 첫번째 수? 10
 두번째 수? 5
 연산자 [+-*'/']? +
 10 + 5 = 15;
*/
public class Quiz01_answer {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int a, b;
		String s, result;
		
		try {
			System.out.print("첫번째 정수를 입력하세요");
			a= sc.nextInt();
			System.out.print("두번째 정수를 입력하세요");
			b= sc.nextInt();
			System.out.print("연산자를 입력하세요[+-*/]");
			s = sc.next();
			
			result = "";
			
			switch(s) {
			case "+" :result = String.format("%d + %d = %d", a, b, a+b); break; 
			case "-" :result = String.format("%d - %d = %d", a, b, a-b); break; 
			case "*" :result = String.format("%d * %d = %d", a, b, a*b); break; 
			case "/" :result = String.format("%d / %d = %d", a, b, a/b); break; 
			default : result = "연산자 입력 오류입니다."; break;
			}
			
			System.out.println(result);
			
		} catch (InputMismatchException e) { 
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
