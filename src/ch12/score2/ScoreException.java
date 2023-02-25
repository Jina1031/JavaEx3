package ch12.score2;

public class ScoreException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public ScoreException(String msg) { //점수 입력 예외
		super(msg);
	}
}
