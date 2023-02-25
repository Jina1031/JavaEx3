package ch09.unit3;

import java.util.Scanner;

public class Ex005_finally {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a, b, c;
		
		try {
			System.out.println("두 정수?");
			a=sc.nextInt();
			b=sc.nextInt();
			c=a/b;
			System.out.println(a+ "/"+b+"="+c);
		} finally {
			System.out.println("예외 발생 유무와 상관 없이 실행 ");
			sc.close();
		} 
		System.out.println("end...");
	}
}
