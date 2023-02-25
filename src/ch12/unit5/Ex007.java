package ch12.unit5;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Ex007 {

	public static void main(String[] args) {
		String pathname = "subject.properties";
		Properties p = new Properties();
		
		//파일의 내용을 읽어 Properties 객체에 저장
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream(pathname);
			
			p.load(fis);//파일의 내용을 불러와 Properties 객체에 저장
			
			p.list(System.out);
			String s;
			s = p.getProperty("자바");
			System.out.println("자바: "+s); //자바: 95
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(fis != null) { //try - resource 쓰면 안 해도 됨
				try {
					fis.close();
				} catch (Exception e2) {
				}
			}
		}
				
	}

}
