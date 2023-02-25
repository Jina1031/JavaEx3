package ch12.score3_sort;

public class ScoreException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public ScoreException(String msg) { //점수 입력 예외
		super(msg);
	}
}
