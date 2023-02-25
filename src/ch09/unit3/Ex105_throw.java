package ch09.unit3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex105_throw {

	public static void main(String[] args) {
		
		User15 obj = new User15();
		
		obj.input();
		obj.input();
		
	}

}

class User15 {
	private Scanner sc= new Scanner(System.in);
	
	public void input() {
		String name, tel;
		int kor, eng;
	
		try {
			System.out.print("이름?");
			name = sc.next();
			
			System.out.print("국어?");
			kor = inputScore();
			
			System.out.print("영어?");
			eng = inputScore();
			
			System.out.print("전화번호?");
			tel = sc.next();
			
			System.out.println("이름: "+name+ ", 국어: "+kor+ ", 영어: "+eng+ ", 전화번호: "+tel);
			
		} catch (Exception e) { //inputScore에서 에러 발생하면 이 catch 문제서 잡음
			//System.out.println(e.toString());
			System.out.println(e.getMessage());
		}
		System.out.println("===================");
	}

	//점수 입력
	private int inputScore() throws Exception {
		int s = 0;
		try {
			s=sc.nextInt();
			if(s < 0 || s > 100) {
				throw new Exception("점수는 0~100 사이만 가능합니다."); //문제를 일으켜서 더이상 프로그램이 진행되지 않도록 함
			}
			
		} catch (InputMismatchException e) {
			sc.nextLine(); //잘못 입력된 문자열을 읽어서 버림 / 얘가 없으면 잘못 입력된 애가 다름 사람 이름으로 넘어감
			
			throw new Exception("점수는 숫자만 가능합니다."); // 여기서 예외 발생 안 시키면 국어 점수에서 a를 입력했을 때 예외처리하고 영어 점수 입력받는 거로 넘어감.
			                                            // 국어 점수는 0으로 초기화 됨
		}
		
		return s;
	}
}
