package ch10.unit1;

public class Ex02_System {

	public static void main(String[] args) {
		String s;
		long ms = System.currentTimeMillis(); //1970.1.1 00:00:00 부터
		long ns = System.nanoTime(); 
		
		System.out.println(ms); //1677205310915
		System.out.println(ns); //50451986133500
		
		s=System.getProperty("os.name"); //OS 출력
		System.out.println("운영체제: "+s); //Windows 10
		
		s=System.getProperty("file.encoding"); //encoding 출력
		System.out.println("인코딩: "+ s); //UTF-8
		
		s=System.getProperty("java.version"); //자바 버전 출력
		System.out.println("자바 버전: "+ s); //자바 버전: 17.0.5
		
		s=System.getProperty("user.dir"); //작업 경로 출력
		System.out.println("작업 경로: "+ s); //C:\study\work\javaEx3
		
		
		
	}

}
