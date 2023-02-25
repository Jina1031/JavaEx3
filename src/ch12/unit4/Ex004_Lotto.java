package ch12.unit4;

import java.util.Set;
import java.util.TreeSet;

public class Ex004_Lotto {

	public static void main(String[] args) {
		// Lotto
		Set<Integer> lotto = new TreeSet<>();

		lotto.add((int)(Math.random()*45)+1);


		for(int i=1; i<6; i++) {
			int n = (int)(Math.random()*45)+1;

			if(lotto.contains(n)) {
				i--;
			}
			lotto.add(n);
		} 
		System.out.println(lotto + " ");

	}

}
