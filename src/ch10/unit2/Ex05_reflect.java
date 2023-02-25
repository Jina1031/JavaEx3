package ch10.unit2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Ex05_reflect {

	public static void main(String[] args) {
		String calssName = "ch10.unit2.TestVO";

		//name -> setName, getName (필드의 이름을 가져와서 getter setter 만드는 것)
		
		try {
			Class<?> cls = Class.forName(calssName);
			
			Constructor<?> con = cls.getDeclaredConstructor();
			Object obj = con.newInstance();
			
			Field[] ff = cls.getDeclaredFields();
			
			// setter 호출
			for(Field f : ff) {
				String name = f.getName();
				String first = name.substring(0, 1).toUpperCase();
				String last = name.substring(1);
				String setter = "set"+first+last;
				//System.out.println(setter);
				/*
				 setName
				 setTel
				 setAge
				 */
				
				Method m = cls.getDeclaredMethod(setter, f.getType());
				
				if(f.getName().equals("name")) {
					m.invoke(obj, "김자바");
				} else if (f.getName().equals("tel")) {
					m.invoke(obj, "010-1");
				}else if (f.getName().equals("age")) {
					m.invoke(obj, 20);
				}
				
			}
			
			//getter 호출
			for(Field f : ff) {
				String name = f.getName();
				String first = name.substring(0, 1).toUpperCase();
				String last = name.substring(1);
				String getter = "get"+first+last;
				//System.out.println(getter);
				
				Method m = cls.getDeclaredMethod(getter);
				Object rt = m.invoke(obj);
				
				if(f.getType().getName().equals("java.lang.String")) {
					String s = (String)rt;
					System.out.println(f.getName()+":"+s);
				}else if(f.getType().getName().equals("int")) {
					int i = (int)rt;
					System.out.println(f.getName()+":"+i);
				}
			}
			/*
			name:김자바
			tel:010-1
			age:20
			*/
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}

class TestVO {
	private String name;
	private String tel;
	private int age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}