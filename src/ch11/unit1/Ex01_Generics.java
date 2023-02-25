package ch11.unit1;

public class Ex01_Generics {

	public static void main(String[] args) {
		Object[] obj = new Object[5];
		//Object는 모든 클래스의 객체를 참조할 수 있음
		
		obj[0] = new String("자바");
		obj[1] = new String("오라클");
		obj[2] = 90;
		obj[3] = 100;
		obj[4] = "스프링";
		
		//Arrays.sort(obj); //런타임 오류 ClassCastException 발생
		for(Object o : obj) {
			//String s = (String)o; //down-casting
			//System.out.println(s.length()); //자바와 오라클까지만 출력되고 90에서 런타임 오류 ClassCastException 발생
			
			if( o instanceof String) {
				String s= (String)o;
				System.out.println(s.length());
			} else if(o instanceof Integer) {
				Integer i = (Integer)o;
				System.out.println("정수: "+ i);
			}
		}
		
	}

}
