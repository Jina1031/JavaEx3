package ch12.unit5;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Ex006 {

	public static void main(String[] args) {
		Properties p = new Properties();
		
		p.setProperty("스트링", "80");
		p.setProperty("서블릿", "90");
		p.setProperty("오라클", "100");
		p.setProperty("자바", "95");
		p.setProperty("HTML", "90");
		
		// Properties의 내용을 파일에 저장
		// 영문자와 숫자 제외한 나머지는 유니코드로 저장
		String pathname = "subject.properties";
		
		try(FileOutputStream fos = new FileOutputStream(pathname)) { //try-resource 자동 close
			
			p.store(fos, "과목별 성적"); //파일에 저장
			
			System.out.println("파일 저장 완료...");
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
