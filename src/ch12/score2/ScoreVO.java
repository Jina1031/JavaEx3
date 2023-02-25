package ch12.score2;

public class ScoreVO {
	private String hak;
	private String name;
	private int kor;
	private int eng;
	private int mat;
	
	public String getHak() {
		return hak;
	}
	public void setHak(String hak) {
		this.hak = hak;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMat() {
		return mat;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
	
	// toString() 메소드 재정의
	@Override
	public String toString() {
		if(hak == null) {
			return null;
		}
		
		int tot = kor + eng + mat;
		int ave = tot / 3;
		String s = String.format("%s\t%s%5d%5d%5d%5d%5d", hak, name, kor, eng, mat, tot, ave);
		return s;
	}
	
}
