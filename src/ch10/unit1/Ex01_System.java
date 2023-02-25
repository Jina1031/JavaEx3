package ch10.unit1;

import java.util.Scanner;

public class Ex01_System {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		
		try {
			while(true) {
				System.out.print("정수[0:종료]?");
				n = sc.nextInt();
				
				if(n==0) {
					//return; //finally 블록 실행
					System.exit(0); //프로그램 강제 종료, finally 블록 실행 안됨
				}
				
				System.out.println("입력 값: " + n);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sc.close();
			System.out.println("finally"); ////0 눌러서 프로그램 종료시 출력
		}
		
		System.out.println("end...");
	}
}
