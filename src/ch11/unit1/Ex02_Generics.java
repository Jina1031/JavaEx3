package ch11.unit1;

public class Ex02_Generics {
	public static void main(String[] args) {
		Test2 t1 = new Test2();
		t1.setOb("서울");
		String s = (String)t1.getOb(); //down-casting 필수
		System.out.println(s+":"+s.length()); //서울:2

		Test2 t2 = new Test2();
		t2.setOb(100);
		Integer i = (Integer)t2.getOb();
		System.out.println(i); //100
		
	}
}

class Test2 {
	private Object ob;

	public Object getOb() {
		return ob;
	}

	public void setOb(Object ob) {
		this.ob = ob;
	}
}