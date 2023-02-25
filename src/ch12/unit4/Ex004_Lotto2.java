package ch12.unit4;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Ex004_Lotto2 {

	public static void main(String[] args) {
		Set<Integer> set = lotto();
		
		for(Integer n: set) {
			System.out.print( n +" ");
		}
		System.out.println();
	}
	
	public static Set<Integer> lotto() {
		Set<Integer> set = new TreeSet<>();
		Random rnd = new Random();
		int n;
		
		while(set.size() < 6) {
			n=rnd.nextInt(45)+1;
			set.add(n);
		}
		return set;
	}
}
