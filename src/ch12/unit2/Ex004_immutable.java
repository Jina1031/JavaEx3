package ch12.unit2;

import java.util.List;

public class Ex004_immutable {

	public static void main(String[] args) {
		//JDK 9 부터 가능. 불변
		//List.of => 불변하는 List
		List<String> list = List.of("A", "B", "C"); 
		System.out.println(list); //[A, B, C]
		
		//list.add("D"); //runtime exception 발생
		//list.set(0, "a");//runtime exception 발생
	}

}
