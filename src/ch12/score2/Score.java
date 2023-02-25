package ch12.score2;

import java.util.List;

public interface Score { //예외는 뺄 수는 있어도 추가는 불가.
	public void insertScore(ScoreVO vo) throws MyDuplicationException; // 등록 (예외 추가)
	public List<ScoreVO> listScore();	// 전체리스트
	public ScoreVO readScore(String hak); // 학번검색
	public boolean deleteScore(String hak);	// 삭제
	public List<ScoreVO> listScore(String name);  // 이름검색
}
