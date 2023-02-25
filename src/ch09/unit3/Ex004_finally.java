package ch09.unit3;

import java.util.Scanner;

public class Ex004_finally {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] ss = new String[3];
		int idx;
		String s;
		
		try {
			idx=0;
			System.out.println("문자열 입력[종료: 입력하지 않고 엔터]...");
			while((s=sc.nextLine()).length() != 0) {
				ss[idx++] = s;
				System.out.println("문자열 입력 ? ");
			}
			
			for(String a : ss) {
				System.out.println(a);
			}
			
		} catch (ArrayIndexOutOfBoundsException e) {
			//ArrayIndexOutOfBoundsException
			//: 배열 첨자를 벗어나면 생기는 unchecked exception
			System.out.println("입력을 초과했씁니다");
		} finally {
			System.out.println("입력 문자열...");
			for(String a : ss) {
				System.out.println(a);
			}
			sc.close();
		}
	}

}
