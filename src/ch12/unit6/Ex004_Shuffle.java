package ch12.unit6;

import java.util.Arrays;
import java.util.Collections;

public class Ex004_Shuffle {

	public static void main(String[] args) {
		//배열 shuffle
		String[] arr = {"java", "css", "html", "javascript", "jsp"};
		System.out.println(Arrays.toString(arr));
		System.out.println();
		
		//배열의 내용 섞기 : 배열을 List<>로 변환하여 처리
		//int[]는  Shuffle 불가능하며, Integer[]는 가능
		
		Collections.shuffle(Arrays.asList(arr)); // 배열을 List로 
		System.out.println(Arrays.toString(arr)); //실행할 때마다 다른 값이 나옴

	}

}
