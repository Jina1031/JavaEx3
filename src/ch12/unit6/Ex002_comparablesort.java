package ch12.unit6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ex002_comparablesort {
	public static void main(String[] args) {
		List<User2> list  = new ArrayList<>();
		
		list.add(new User2("다자바", "010-1", 20));
		list.add(new User2("너자바", "010-2", 21));
		list.add(new User2("홍자바", "010-3", 20));
		list.add(new User2("더자바", "010-5", 22));
		list.add(new User2("김자바", "010-4", 19));
		
		System.out.println("정렬 전...");
		print(list);
		
		//Collections.sort(list); // 컴오류 
		//이름순인지 전화번호순인지 나이순인지 모름. 정렬의 기준점이 없음
	    // 이걸 해결하기 위에 User2에 인터페이스 구현
 		
		Collections.sort(list);
		
		System.out.println("정렬 후...");
		print(list); //가나다 순으로 정렬
	}
	
	public static void print(List<User2> list) {
		for(User2 vo :list) {
			System.out.print(vo.getName()+"\t");
			System.out.print(vo.getTel()+"\t");
			System.out.println(vo.getAge()+"\t");
		}
		System.out.println();
	}
	
}

class User2 implements Comparable<User2>{
	private String name;
	private String tel;
	private int age;
	
	public User2() {
	}
	
	public User2(String name, String tel, int age) {
		this.name=name;
		this.tel=tel;
		this.age=age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	@Override //이름 오름 차순
	public int compareTo(User2 o) { //얘는 Comparable 인터페이스의 compareTo
		//차이값이 양수이면 스와핑하고 차이값이 음수이면 스와핑 하지 않음
		return name.compareTo(o.getName()); //얘는 String 클래스의 compareTo // 이름 오름 차순
		//return - name.compareTo(o.getName()); // 이름 내림 차순
		//return age - o.getAge();              // 나이 오름 차순
		//return -(age - o.getAge());           // 나이 내림 차순
	}
	
}