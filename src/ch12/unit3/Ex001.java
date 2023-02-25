package ch12.unit3;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Vector;

//데이터 전체를 가져오는 방법들
public class Ex001 {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("자바");
		list.add("오라클");
		list.add("스프링");
		list.add("javascript");
		list.add("CSS3");
		list.add("HTML5");
		
		System.out.println("전체-1");
		for(String s : list) {
			System.out.print(s+" "); //자바 오라클 스프링 javascript CSS3 HTML5 
		}
		System.out.println();
		
		System.out.println("\n전체-2");
		Iterator<String> it = list.iterator();
		while(it.hasNext()) {
			String s= it.next();
			System.out.print(s+" "); //자바 오라클 스프링 javascript CSS3 HTML5 
		}
		System.out.println();
		
		System.out.println("\n전체-3");
		ListIterator<String> it2 = list.listIterator();//역순도 가능.
		while(it2.hasNext()) {
			String s= it2.next();
			System.out.print(s+" ");//자바 오라클 스프링 javascript CSS3 HTML5 
		}
		System.out.println();
		
		System.out.println("\n전체역순");
		while(it2.hasPrevious()) {
			String s= it2.previous();
			System.out.print(s+" "); //HTML5 CSS3 javascript 스프링 오라클 자바 
		}
		System.out.println();
		
		Vector<String> vv = new Vector<>();
		vv.add("서울");
		vv.add("인천");
		vv.add("경기");
		
		System.out.println("Vector 전체-1");
		Enumeration<String> e = vv.elements();
		while(e.hasMoreElements()) {
			String s = e.nextElement();
			System.out.print(s+" "); // 서울 인천 경기 
		}
		System.out.println();
		
		System.out.println("Vector 전체-2");
		for(String s : vv) {
			System.out.print(s+" "); // 서울 인천 경기 
		}
		System.out.println();
	}
}
