package ch12.adress;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class AddressUI {
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private Address addr = new AddressImpl();
	private DateUtil util = new DateUtil();
	
	
	public void menu() {
		int ch;

		while(true) {
			try {
				do {
					System.out.print("1.등록 2.수정 3.삭제 4.전화번호검색 5.이름검색 6.전체리스트 7.종료=> ");
					ch = Integer.parseInt(br.readLine());
				}while(ch < 1 || ch > 8);

				if(ch==7) {
					System.exit(0);
				}

				switch(ch) {
				case 1 :insert();break;
				case 2 :update();break;
				case 3 :delete();break;
				case 4 :findByTel();break;
				case 5 :findByName();break;
				case 6 :printAll();break;
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	public void insert() {
		System.out.println("\n[등록]");
		AddressVO vo = new AddressVO();
		
		try {
			System.out.print("전화 번호?");
			String tel = br.readLine();
			
			System.out.print("이름? ");
			vo.setName(br.readLine());
			
			System.out.print("생년월일");
			vo.setBirth(br.readLine());
			
			if(vo.getBirth().length() != 0 && ! util.IsValidDate(vo.getBirth())) { 
			  //   0이 아니고(입력했고)        &&           형식에 맞지 않으면
				System.out.println("날짜 형식 입력 오류 입니다.");
				return;
			}
			
			System.out.print("주소?");
			vo.setAdd(br.readLine());
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			vo.setRegisterDate(sdf.format(new Date()));
			
			addr.insertAddress(tel, vo);
			
			System.out.println("등록이 완료 되었습니다.");
			
		} catch (DuplicationException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println();
	}

	public void update() {
		System.out.println("\n[수정]");
		
		try {
			String key;
			System.out.print("수정할 전화번호 ? ");
			key = br.readLine();
			
			AddressVO vo = addr.readAddress(key);
			if( vo == null) {
				System.out.println("등록된 자료가 없습니다.\n");
				return;
			}
			String tel, name, a, birth;
			System.out.print("새로운 전화번호 ? ");
			tel = br.readLine();
			
			if(!key.equals(tel)) {
				if(addr.readAddress(tel) != null) { //새로 입력한 번호가 등록된 자료라면
					System.out.println("등록된 자료 입니다.");
					return;
				}
				
				//key를 수정하는 방법은 기존 데이터를 삭제후 다시 등록
				addr.deleteAddress(key);
				
				addr.insertAddress(tel, vo);
			}
			
			System.out.print("이름? ");
			name = br.readLine();
			
			System.out.print("생년월일? ");
			birth = br.readLine();
			if(birth.length()!=0 && ! util.IsValidDate(birth)) {
				System.out.println("생년월일을 정확히 입력하세요.");
				return;
			}
			
			System.out.print("주소? ");
			a = br.readLine();
			
			vo.setName(name);
			vo.setAdd(a);
			vo.setBirth(birth);
			
			System.out.println("수정 완료 했습니다.");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println();
	}

	public void delete() {
		System.out.println("\n[삭제]");
		
		try {
			String tel;
			System.out.print("삭제할 전화번호를 입력하세요");
			tel = br.readLine();
			
			
			if(addr.deleteAddress(tel)) {
				System.out.println("삭제 했습니다.");
			}else {
				System.out.println("등록된 자료가 아닙니다.");
			}
			/*

			AddressVO vo = addr.readAddress(tel);
			
			if(vo == null) {
				System.out.println("등록되지 않은 정보입니다.");
				return;
			}
			
			addr.deleteAddress(tel);
			
			System.out.println("삭제가 완료되었습니다.");
			*/
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void findByTel() {
		System.out.println("\n[전화번호검색]");
		
		String tel;
		try {
			System.out.println("검색할 전화번호를 입력해주세요.");
			tel = br.readLine();
			
			AddressVO vo = addr.readAddress(tel);
			
			if(vo == null) {
				System.out.println("등록되지 않은 정보입니다.");
				return;
			}
			System.out.print(vo.getName()+"\t");
			System.out.print(tel+"\t");
			System.out.print(vo.getAdd()+"\t");
			System.out.print(vo.getBirth()+"\t");
			System.out.println(vo.getRegisterDate()+"\t");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void findByName() {
		System.out.println("\n[이름검색]");
		
		String name;
		try {
			System.out.println("검색할 이름를 입력해주세요.");
			name = br.readLine();
			
			Map<String , AddressVO> map = addr.listAdress(name);
			
			for(String key : map.keySet()) {
				AddressVO vo = map.get(key);
				System.out.print(key+"\t");
				System.out.print(vo.getName()+ "\t");
				System.out.print(vo.getBirth()+ "\t");
				System.out.print(vo.getAdd()+ "\t");
				System.out.print(vo.getRegisterDate()+ "\t");
			}
			System.out.println();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void printAll() {
		System.out.println("\n[전체리스트]");
		
		Map<String, AddressVO> map = addr.listAdress();
		
		System.out.println("번호\t이름\t전화번호\t생년월일\t주소\t등록일");
		System.out.println("==========================================");
		int n = 1;
		for(String key : map.keySet()) {
			AddressVO vo = map.get(key);
			System.out.print((n++)+"\t");
			System.out.print(vo.getName()+ "\t");
			System.out.print(key + "\t");
			System.out.print(vo.getBirth()+ "\t");
			System.out.print(vo.getAdd()+ "\t");
			System.out.print(vo.getRegisterDate()+ "\t");
		}
		System.out.println();
	}
}
