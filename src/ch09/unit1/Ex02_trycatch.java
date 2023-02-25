package ch09.unit1;

import java.util.Scanner;

public class Ex02_trycatch {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a, b, c;
	
		try {
			//try 블록
			// : 예외가 발생할 가능성이 있는 코드
			System.out.print("두 정수?");
			a = sc.nextInt();
			b = sc.nextInt();
			
			c= a/b;
			System.out.println(a+"/"+b+"="+c);
			
		} catch (Exception e) {
			// Exception 
			// : 모든 예외를 catch 할 수 있음
			// : 예외 상황별로 분리가 어려움 (숫자를 잘못 입력해서 에러가 나온 건지, 0을 입력해서 에러가 나온 건지 구분이 안 감) 
			//catch 블록
			// : 예외가 발생할 때 실행할 코드
			// 1) System.out.println("예외가 발생했습니다."); // 런타임 오류로 비정상 종료가 아닌 정상 종료.
			// 2) System.out.println(e.getMessage());    // 에러 메세지를 간단하게 출력
			// 3) System.out.println(e.toString());      // 예외 발생 클래스 및 간단한 메세지
			// 4) e.printStackTrace();                   // 자세히 예외 상황 메세지 출력
		}
	
		System.out.println("end...");
		
		sc.close();
	}

}
