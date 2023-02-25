package ch09.unit1;

import java.util.Scanner;

public class Ex01_trycatch {

	public static void main(String[] args) {
		// 잘못 작성한 프로그램의 예
		Scanner sc = new Scanner(System.in);
		int a, b, c;
		
		System.out.print("두 정수?");
		a = sc.nextInt();
		b = sc.nextInt();
		
		c= a/b;
		
		System.out.println(a+"/"+b+"="+c);
		
		System.out.println("end...");
		
		sc.close();
	}
	
	/*
	  - 0을 입력하는 경우
	  - 숫자가 아닌 문자를 잘못 입력한 경우
	  프로그램 비정상적으로 종료
	  아래 코드는 실행되지 않음
	 */

}
