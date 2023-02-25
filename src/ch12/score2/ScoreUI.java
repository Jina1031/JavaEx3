package ch12.score2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class ScoreUI {
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private Score score = new ScoreImpl();
	
	public void menu() {
		int ch;
		
		while(true) {
			try {
				do {
					System.out.print("1.등록 2.수정 3.삭제 4.리스트 5.학번검색 6.이름검색 7.종료 => ");
					ch = Integer.parseInt(br.readLine());
				} while(ch < 1 || ch > 7);
				
				if(ch == 7) {
					// return;
					System.exit(0); // 프로그램 강제 종료
				}
				
				switch(ch) {
				case 1 : insert(); break;
				case 2 : update(); break;
				case 3 : delete(); break;
				case 4 : printAll(); break;
				case 5 : findByHak(); break;
				case 6 : findByName(); break;
				}
				
			} catch (Exception e) {
				// e.printStackTrace();
			}
		}
	}
	
	private int inputScore() throws NumberFormatException, ScoreException {
		int s = 0;
		
		try {
			s = Integer.parseInt(br.readLine());
			if(s < 0 || s > 100) {
				throw new ScoreException("점수는 0~100 사이만 가능합니다.");
			}
		} catch (NumberFormatException e) {
			throw e;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return s;
	}
	
	protected void insert() {
		System.out.println("\n데이터 등록...");
		
		try {
			ScoreVO vo = new ScoreVO();
			
			System.out.print("학번 ? ");
			vo.setHak(br.readLine());
			
			System.out.print("이름 ? ");
			vo.setName(br.readLine());
			
			System.out.print("국어 ? ");
			vo.setKor(inputScore());
			
			System.out.print("영어 ? ");
			vo.setEng(inputScore());
			
			System.out.print("수학 ? ");
			vo.setMat(inputScore());
			
			score.insertScore(vo);
			
			System.out.println("데이터 등록이 완료 되었습니다.");
			
		} catch (MyDuplicationException e) {
			System.out.println(e.getMessage());
		} catch (NumberFormatException e) {
			System.out.println("점수는 숫자만 가능합니다.");
		} catch (ScoreException e) {
			System.out.println("점수는 0~100 사이만 가능합니다.");			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println();

	}
	
	protected void update() {
		System.out.println("\n데이터 수정...");
		
		String hak;
		try {
			System.out.print("수정할 학번 ? ");
			hak = br.readLine();
			
			ScoreVO vo = score.readScore(hak); //그 학번의 주소를 가지고 있음
			if(vo == null) {
				System.out.println(hak + " 학번은 등록된 학번이 아닙니다.\n");
				return;
			}
			
			String name;
			int kor, eng, mat;
			
			System.out.print("이름 ? ");
			name = (br.readLine());
			
			System.out.print("국어 ? ");
			kor = (inputScore());
			
			System.out.print("영어 ? "); //130점 입력해도 들어감
			eng = (inputScore());
			
			System.out.print("수학 ? ");
			mat = (inputScore());
			
			// 일반 지역변수로 선언하여 입력을 받고, 메소드를 실행하여 오류가 있으면 더이상 일이 실행되지 않도록함
			// 그리고 예외가 발생하지 않고 실행되면 vo 에 set.
			
			vo.setName(name);
			vo.setEng(eng);
			vo.setKor(kor);
			vo.setMat(mat);

			System.out.println("데이터가 수정되었습니다.");
			
		} catch (NumberFormatException e) {
			System.out.println("점수는 숫자만 가능합니다.");
		} catch (ScoreException e) {
			System.out.println("점수는 0~100 사이만 가능합니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println();
		
	}

	protected void delete() {
		System.out.println("\n데이터 삭제...");
		
		String hak;
		
		try {
			System.out.print("삭제할 학번 ? ");
			hak = br.readLine();
			
			boolean b = score.deleteScore(hak);
			if( b ) {
				System.out.println("[" + hak + "] 학번 자료가 삭제 되었습니다.\n");
			} else {
				System.out.println("[" + hak + "] 학번은 등록된 학번이 아닙니다.\n");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	protected void printAll() {
		System.out.println("\n전체 리스트...");
		
		List<ScoreVO> list = score.listScore();
		for(ScoreVO vo : list) {
			System.out.println(vo);
		}
		System.out.println();
		
	}
	
	protected void findByHak() {
		System.out.println("\n학번 검색...");
		String hak;
		
		try {
			System.out.print("검색할 학번 ? ");
			hak = br.readLine();
			
			ScoreVO vo = score.readScore(hak);
			if(vo == null) {
				System.out.println("[" + hak + "] 학번은 등록된 학번이 아닙니다.\n");
				return;
			}
			
			System.out.print(vo.getHak() + "\t");
			System.out.print(vo.getName() + "\t");
			System.out.print(vo.getKor() + "\t");
			System.out.print(vo.getEng() + "\t");
			System.out.println(vo.getMat());
			System.out.println();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	protected void findByName() {
		System.out.println("\n이름 검색...");
		
		String name;
		
		try {
			System.out.print("검색할 이름 ? ");
			name = br.readLine();
			
			List<ScoreVO> list = score.listScore(name);
			if(list.size() == 0) {
				System.out.println("등록된 이름이 없습니다.\n");
				return;
			}
			
			for(ScoreVO vo : list) {
				System.out.print(vo.getHak() + "\t");
				System.out.print(vo.getName() + "\t");
				System.out.print(vo.getKor() + "\t");
				System.out.print(vo.getEng() + "\t");
				System.out.println(vo.getMat());
			}
			System.out.println();			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
