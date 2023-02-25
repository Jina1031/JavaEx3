package ch09.unit3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 첫번째 수? 10
 두번째 수? 5
 연산자 [+-*'/']? +
 10 + 5 = 15;
*/
public class Quiz01_realanswer {
	public static void main(String[] args) {
		
		
	}
}

class OperatorException extends Exception{
	private static final long serialVersionUID = 1L;
	
	public OperatorException (String msg) {
		super(msg);
	}
}

class Calculate{
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	//필드는 private 로 선언하는 것이 보편적. 값을 변경하지 못하게 해야함.
	
	public void calc() {
		
		int a, b;
		String op;
		
		try {
			System.out.println("첫번째 정수를 입력하세요");
			a = Integer.parseInt(br.readLine());
			System.out.println("첫번째 정수를 입력하세요");
			b = Integer.parseInt(br.readLine());
			System.out.println("연산자를 입력하세요");
			op = inputOperator();
			
			String s = null;
			
			switch(op) {
			case "+" : s = String.format("%d + %d = %d", a, b, a+b); break; 
			case "-" : s = String.format("%d - %d = %d", a, b, a-b); break; 
			case "*" : s = String.format("%d * %d = %d", a, b, a*b); break; 
			case "/" : s = String.format("%d / %d = %d", a, b, a/b); break; 
			}
			
			System.out.println(s);

		} catch (NumberFormatException e) {
			System.out.println("숫자만 입력 가능합니다");
		} catch (OperatorException e) {
			System.out.println(e.getMessage());
		} catch (ArithmeticException e) {
			System.out.println("0은 나눗셈 연산이 불가능합니다");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private String inputOperator() throws OperatorException {
		String op = null;
		
		try {
			op = br.readLine();
			
			if(!op.matches("(\\+|\\-|\\*|\\/)")) {
				throw new OperatorException("연산자 입력 오류 입니다");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return op;
	}
}