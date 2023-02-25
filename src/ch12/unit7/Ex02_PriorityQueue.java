package ch12.unit7;

import java.util.PriorityQueue;
/*
 - Priority Queue
  : 우선순위 Queue
  : Comparable 인터페이스 구현 클래스만 가능
 */
public class Ex02_PriorityQueue {

	public static void main(String[] args) {
		PriorityQueue<String> q = new PriorityQueue<>();

		q.offer("자바");
		q.offer("오라클");
		q.offer("서블릿");
		q.offer("스프링");
		q.offer("자바스크립트");

		//오름차순 순서로 소모
		while(q.peek() != null) {
			String s = q.poll(); 
			System.out.print(s+" "); //서블릿 스프링 오라클 자바 자바스크립트 

		}
	}
}
