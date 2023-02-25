package ch12.score;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class ScoreUI {
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private Score score = new ScoreImpl();
	
	public void meun() {
		int ch;
		
		while(true) {
			try {
				do {
					System.out.print("1.등록 2.수정 3.삭제 4.리스트 5.학번검색 6.이름검색 7.종료 =>");
					ch = Integer.parseInt(br.readLine());
				}while(ch < 1 || ch > 7);
				
				if(ch == 7) {
					return;
				}
				
				switch(ch) {
				case 1 : insert();break;
				case 2 : update();break;
				case 3 : delete();break;
				case 4 : printAll();break;
				case 5 : findByHak();break;
				case 6 : findByName();break;
				}
				
			} catch (Exception e) {
				//e.printStackTrace();
			}
		}
	}
	
	protected void insert() {
		System.out.println("\n데이터 등록");
		
		try {
			ScoreVO vo = new ScoreVO();
			
			System.out.print("학번?");
			vo.setHak(br.readLine());
			
			System.out.print("이름?");
			vo.setName(br.readLine());
			
			System.out.print("국어?");
			vo.setKor(Integer.parseInt(br.readLine()));
			
			System.out.print("영어?");
			vo.setEng(Integer.parseInt(br.readLine()));
			
			System.out.print("수학?");
			vo.setMat(Integer.parseInt(br.readLine()));
			
			score.insertScore(vo);
			
			System.out.println("데이터 등록이 완료되었습니다.\n");
			
		} catch (NumberFormatException e) {
			System.out.println("점수는 숫자만 가능합니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void update() {
		System.out.println("\n데이터 수정");
		String hak;
		
		try {
			System.out.print("수정할 학번 ?");
			hak = br.readLine();

			ScoreVO vo = score.readScoreVO(hak); // 학번이 있는 곳의 주소를 찾음
			
			if(vo == null) {
				System.out.println(hak+ "학번은 등록된 학번이 아닙니다.\n");
				return;
			}

			System.out.print("이름?");
			vo.setName(br.readLine());

			System.out.print("국어?");
			vo.setKor(Integer.parseInt(br.readLine()));

			System.out.print("영어?");
			vo.setEng(Integer.parseInt(br.readLine()));

			System.out.print("수학?");
			vo.setMat(Integer.parseInt(br.readLine()));

			System.out.println("데이터 수정이 완료되었습니다.\n");

		} catch (NumberFormatException e) {
			System.out.println("점수는 숫자만 가능합니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void delete() {
		System.out.println("\n데이터 삭제");
		
		String hak;
		
		try {
			System.out.print("삭제할 학번?");
			hak = br.readLine();
			
			boolean b = score.deleteScore(hak); // b= true
			
			if(b) {
				System.out.println(hak +"학번 자료가 삭제되었습니다\n");
			} else {
				System.out.println(hak +"학번은 등록된 학번이 아닙니다.\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void printAll() {
		System.out.println("\n전체 리스트");
		
		List<ScoreVO> list = score.listScore();
		int tot;

		for(ScoreVO vo : list){
			tot = vo.getKor()+vo.getEng()+vo.getMat();
			
			System.out.print(vo.getHak()+"\t");
			System.out.print(vo.getName()+"\t");
			System.out.print(vo.getKor()+"\t");
			System.out.print(vo.getEng()+"\t");
			System.out.print(vo.getMat()+"\t");
			System.out.print(tot + "\t");
			System.out.println((tot/3));
		}
		System.out.println();
	}

	protected void findByHak() {
		System.out.println("\n학번 검색");
		String hak;
		
		try {
			System.out.print("검색할 학번 ?");
			hak = br.readLine();
			
			ScoreVO vo = score.readScoreVO(hak);
			
			if(vo == null) {
				System.out.println(hak+ "학번은 등록된 학번이 아닙니다.\n");
				return;
			}
			
			System.out.print(vo.getHak()+"\t");
			System.out.print(vo.getName()+"\t");
			System.out.print(vo.getKor()+"\t");
			System.out.print(vo.getEng()+"\t");
			System.out.print(vo.getMat()+"\t");
			System.out.println();
			
		} catch (Exception e) {
		}
	}

	protected void findByName() {
		System.out.println("\n이름 검색");
		String name;
		
		try {
			System.out.println("검색할 이름?");
			name= br.readLine();
			
			List<ScoreVO> list = score.listScore(name);
			if(list.size()==0) {
				System.out.println("등록된 이름이 없습니다.\n");
				return;
			}

			for(ScoreVO vo : list) {

				System.out.print(vo.getHak()+"\t");
				System.out.print(vo.getName()+"\t");
				System.out.print(vo.getKor()+"\t");
				System.out.print(vo.getEng()+"\t");
				System.out.print(vo.getMat()+"\t");
				System.out.println();
			}
			System.out.println();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
