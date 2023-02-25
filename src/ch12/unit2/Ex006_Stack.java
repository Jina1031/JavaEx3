package ch12.unit2;

import java.util.Stack;

/*
 - Strack
  : Vector의 하위 클래스
  : LIFO 구조 (Last In First Out)
  : 가장 나중에 입력된 것이 가장 처음에 출력 
  : Stack 자체 메소드 사용하는 게 좋음
 */
public class Ex006_Stack {

	public static void main(String[] args) {
		Stack<String> st = new Stack<>();
		
		//push 데이터 추가
		st.push("A");
		st.push("B");
		st.push("C");
		st.push("D");
		
		//empty(): 비어있는지 확인
		//pop(): 스택 top의 위치 요소를 반환하고 삭제
		//peek(): 스택 top 위치의요소를 반환하고 삭제하지 않음. 그래서 계속 top에 있는 데이터만 반환됨
		while(! st.empty()) {
			String s= st.pop();
			System.out.print(s+" "); //D C B A 
		}
		System.out.println();
	}

}
