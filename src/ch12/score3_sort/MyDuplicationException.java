package ch12.score3_sort;

public class MyDuplicationException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public MyDuplicationException(String msg) { //학번 중복 예외
		super(msg);
	}
}
