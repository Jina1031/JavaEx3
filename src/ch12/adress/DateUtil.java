package ch12.adress;

import java.util.Calendar;

public class DateUtil {
	/**
	 * 날짜 형식이 올바른지 판별
	 * @param date 날짜형식을 파별할 문자열
	 * @return     형식이 올바른지 여부(true/false)
	 */
	public boolean IsValidDate(String date) {
/*
 1. 입력 받은 날짜의 길이를 확인
 2. 숫자 중간에 들어간 부호 삭제		
 */
		
		try {
			if(date.length() != 8 && date.length() != 10) {
				return false;
			}
			
			date = date.replaceAll("(\\-|\\.|\\/)", "");
			if(date.length() != 8) {
				return false;
			}
			
			int y = Integer.parseInt(date.substring(0, 4));
			int m = Integer.parseInt(date.substring(4, 6));
			int d = Integer.parseInt(date.substring(6));
			
			Calendar cal = Calendar.getInstance();
			cal.set(y, m-1, d);
			
			int y1=cal.get(Calendar.YEAR);
			int m1=cal.get(Calendar.MONTH)+1;
			int d1=cal.get(Calendar.DATE);

			if(y!=y1||m!=m1||d!=d1) {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	
		return true;
	}
	
	
	public static long dday(String day) {
	
		day = day.replaceAll("(\\-|\\.|\\/)", "");
		
		int y = Integer.parseInt(day.substring(0,4));
		int m = Integer.parseInt(day.substring(4,6));
		int d = Integer.parseInt(day.substring(6));
		
		Calendar cal = Calendar.getInstance();
		cal.set(y, m-1, d);
		
		Calendar now = Calendar.getInstance();
		now.getTime();
		
		long cal2 = cal.getTimeInMillis();
		long now2 = now.getTimeInMillis();
		
		long result = (cal2-now2)/1000*60*60*24;
		
		
		return result;
		
	

	}
	
}

