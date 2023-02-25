package ch12.unit7;

import java.util.PriorityQueue;

public class Ex03_PriorityQueue {

	public static void main(String[] args) {
		PriorityQueue<UserVO> q = new PriorityQueue<>();
		
		q.offer(new UserVO("이자바", 25));
		q.offer(new UserVO("다자바", 23));
		q.offer(new UserVO("너자바", 27));
		q.offer(new UserVO("김자바", 22));
		q.offer(new UserVO("홍자바", 23));
		
		
		while(q.peek() != null) {
			UserVO ob = q.poll(); 
			System.out.println("이름: "+ob.getName()+", 나이: "+ob.getAge()); //나이가 적은 사람부터 
			/*
            이름: 김자바, 나이: 22
            이름: 홍자바, 나이: 23
            이름: 다자바, 나이: 23
            이름: 이자바, 나이: 25
            이름: 너자바, 나이: 27 
            */ 
		}
		
	}

}

class UserVO implements Comparable<UserVO> {
	private String name;
	
	public UserVO() {
	}
	
	public UserVO(String name, int age) {
		this.age=age;
		this.name=name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	private int age;

	@Override
	public int compareTo(UserVO o) {
		return age - o.getAge();
	}
	
	
}
