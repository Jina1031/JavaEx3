package ch09.unit3;

public class Ex107_throw {

	public static void main(String[] args) {
		User17 ob = new User17();
		
		try {
			//ob.setName("김");
			//ob.setName("김김");
			//ob.setAge(15);
			
			ob.set("김자바", -15); // java.lang.Exception: 나이는 0 이상만 가능합니다 / 김자바, 0
			                     // 34번줄 예외 던진 후 : java.lang.Exception: 나이는 0 이상만 가능합니다
			
			System.out.println(ob.getName()+", "+ob.getAge());
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}

class User17{
	private String name;
	private int age;
	
	public void set(String name, int age) throws Exception {
		try {
			setName(name);
			setAge(age);
		} catch (Exception e) {
			//System.out.println(e.toString()); // 여기서 예외를 다 처리했기 때문에 15번 줄이 무리없이 실행됨. 0살이 그대로 출력
			                                  // 그래서 다시 예외를 일으켜서 다음 문장이 실행되지 않도록 해야 함
			throw e; //예외를 다시 일으킴 (checked exception 이기 때문에 throws 필수)
			//throws new Exception //새로운 예외를 던짐
		}
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) throws Exception{
		if(! name.matches("^[가-힣]{2,5}$")) {
			throw new Exception("이름은 2~5 사이의 한글만 가능합니다."); //checked exception
		}
		
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) throws Exception{
		if(age < 0) {
			throw new Exception("나이는 0 이상만 가능합니다"); //checked exception
		}
		
		this.age = age;
	}
}