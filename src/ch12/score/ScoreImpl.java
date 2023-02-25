package ch12.score;

import java.util.ArrayList;
import java.util.List;

public class ScoreImpl implements Score{
	//학생의 정보를 저장할 List 인터페이스 구현 클래스의 객체
	private List<ScoreVO> list = new ArrayList<>();
	//List 인터페이스 - ArrayList 구현 클래스

	@Override
	public void insertScore(ScoreVO vo) { // 등록
		//List 객체의 마지막에 요소를 추가
		list.add(vo);
	}

	@Override
	public List<ScoreVO> listScore() { // 전체 리스트
		return list; // list 반환
	}

	@Override
	public ScoreVO readScoreVO(String hak) { // 학번검색
		for(ScoreVO vo : list) {
			if(vo.getHak().equals(hak)) {
				return vo; // 같으면 주소 반환
			}
		}
		return null; //학번 검색 안되면 null이 넘어감
	}

	@Override
	public boolean deleteScore(String hak) { // 삭제
		ScoreVO vo = readScoreVO(hak);
		
		if(vo == null) {
			return false; // null값이면 false
		}
		
		list.remove(vo); //null 값 아니면 remove
				
		return true;
	}

	@Override
	public List<ScoreVO> listScore(String name) { // 이름검색
		List<ScoreVO> finds = new ArrayList<>(); // 새로운 객체 발생
		
		for(ScoreVO vo : list) {
			if(vo.getName().indexOf(name)>=0) { //홍길동, 길동, 홍 만 검색해도 나옴
				finds.add(vo);
			}
		}
		
		return finds;
	}
	
}
