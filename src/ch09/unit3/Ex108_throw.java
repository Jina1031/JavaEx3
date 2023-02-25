package ch09.unit3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex108_throw {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		User18 user = new User18();
		
		try {
			System.out.print("이름?");
			user.setName(br.readLine());
			
			System.out.print("나이?");
			user.setAge(Integer.parseInt(br.readLine()));
			
			System.out.println("이름: "+user.getName()+", 나이: "+user.getAge());

		} catch (NumberFormatException e) { //unchecked exception 숫자(정수)를 문자열로 바꿀 때 나타나는 예외
			System.out.println("나이는 숫자만 가능합니다.");
			//System.out.println(e.getMessage); //동일한 결과
		} catch (NameValidException e) {
			System.out.println("이름은 2~5자 이내의 한글만 가능합니다");
		} catch (AgeValidException e) {
			System.out.println("나이는 0살 이상만 가능합니다.");
		} catch (IOException e) { //readLine()에서 발생할 수 있는 예외
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

// 사용자 정의 예외 클래스 작성 
// : checked exception
// : Exception 클래스 상속
class NameValidException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public NameValidException(String msg) {
		super(msg); //상위 클래스(Exception)의 생성자 호출
	}
}

class AgeValidException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public AgeValidException(String msg) {
		super(msg);
	}
}

class User18 {
	private String name;
	private int age;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) throws NameValidException{
		if(! name.matches("^[가-힣]{2,5}$")) {
			throw new NameValidException("이름은 2~5 사이의 한글만 가능합니다."); 
		}
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) throws AgeValidException{
		if(age < 0) {
			throw new AgeValidException("나이는 0 이상만 가능합니다"); 
		}
		this.age = age;
	}
}

