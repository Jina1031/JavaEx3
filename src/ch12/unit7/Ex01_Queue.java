package ch12.unit7;

import java.util.LinkedList;
import java.util.Queue;

/*
 - Queue 인터페이스
  : FIFO(First In First Out)
  : 먼저 입력된 것이 먼저 출력되는 구조
 - 구현 클래스
  : LinkedList
 */
public class Ex01_Queue {

	public static void main(String[] args) {
		Queue<String> q = new LinkedList<>();
		
		//Queued의 마지막 요소 삽입
		//offer()
		q.offer("자바");
		q.offer("오라클");
		q.offer("서블릿");
		q.offer("스프링");
		q.offer("자바스크립트");
		
		//데이터 가져오기
		//peek() : head 반환, 없으면 null
		//pool() : head 반환 후 삭제, 없으면 null  
		while(q.peek() != null) {
			String s = q.poll(); //반환하면 삭제되는 구조
			System.out.print(s+" "); //자바 오라클 서블릿 스프링 자바스크립트
		}
		
		

	}

}
