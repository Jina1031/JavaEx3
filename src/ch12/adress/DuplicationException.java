package ch12.adress;

//전화번호 똑같으면 입력 못하게 하는 오류
public class DuplicationException extends Exception {
	private static final long serialVersionUID = 1L;

	public DuplicationException(String msg) {
		super(msg);
	}
}
