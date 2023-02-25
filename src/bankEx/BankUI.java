package bankEx;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


// 화면 입출력
public class BankUI {
	
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private Bank bank = new BankImpl();
	int cnt; // 비밀번호 오류 카운트

	private final String id = "bank";
	private final String pass ="bank";

	public void banklogin (String id, String pass){
		
		try {
			
			
			System.out.print("아이디를 입력하세요.");
			do {
				id = br.readLine();
				if(!this.id.equals(id)) {
					System.out.print("아이디가 틀렸습니다. 다시 입력해주세요.");
				}
			}while(!this.id.equals(id));
			
			System.out.print("비밀번호를 입력하세요.");
			pass=br.readLine();
			
			while(this.id.equals(id) && ! this.pass.equals(pass)) {
				do {
					cnt++;
					System.out.println("비밀번호가" + cnt + "번 틀렸습니다. 다시 입력해주세요.");
					System.out.print("비밀번호를 입력하세요.");
					pass=br.readLine();	
					if(cnt == 2 ) {
						System.out.println("비밀번호 3회 오류입니다. 프로그램을 종료합니다.");
						System.exit(0);
					}
					
				}while(! this.pass.equals(pass));
			}
			


			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	
	public void menu() {
		int ch;
		while(true) {
			try {
				do {
					System.out.println("\n-------------------------------------------------");
					System.out.println("\t1.은행      2.고객      3.종료");
					System.out.println("-------------------------------------------------");
					System.out.print("선택=> ");
					ch=Integer.parseInt(br.readLine());
				} while(ch<1||ch>3);
				
				if(ch==3) {
					System.exit(0);
				}else if(ch == 1) {
					banklogin(id,pass);
				    menubank();
				}else {
					menucus();
				}
				
			}catch(Exception e) { 
				System.out.println("메뉴 입력 오류입니다.");
		    }
			
		}
		
	}



	public void menucus() {
		int ch;
		while(true) {
			try {
				do {
					System.out.println("\n-----------------------고객-----------------------");
					System.out.println("1.계좌개설    2.입금       3.출금");
					System.out.println("4.계좌이체    5.잔액조회    6.거래내역    7.종료");
					System.out.println("-------------------------------------------------");
					System.out.print("선택=> ");
					ch=Integer.parseInt(br.readLine());
				} while(ch<1||ch>7);
				
				if(ch==7) {
					return;
				}
				
				switch(ch) {
				case 1: System.out.println("\n[개인-계좌 개설]"); addAccount();  break;
				case 2: System.out.println("\n[개인-입금]"); deposit(); break;
				case 3: System.out.println("\n[개인-출금]"); withdraw(); break;
				case 4: System.out.println("\n[개인-계좌이체]"); accountTransfer(); break;
				case 5: System.out.println("\n[개인-잔액조회]"); balance(); break;
				case 6: System.out.println("\n[개인-거래내역조회]"); transactionHistory(); break;
				}
			} catch (Exception e) {
				System.out.println("메뉴 입력 오류입니다.");
			} // catch_end
			
		} // while_end
	}
	
	public void menubank() {
		int ch;
		while(true) {
			try {
				do {
					System.out.println("\n----------------------------은행----------------------------");
					System.out.println("1.계좌개설   2.입금        3.출금        4.계좌이체      5.잔액조회");
					System.out.println("6.거래내역   7.계좌번호검색   8.이름검색     9.계좌리스트    10.종료");
					System.out.println("-----------------------------------------------------------");
					System.out.print("선택=> ");
					ch=Integer.parseInt(br.readLine());
				} while(ch < 1||ch > 10);
	
				if(ch==10) {
					return;
				}

				switch(ch) {
				case 1: System.out.println("\n[은행-계좌 개설]"); addAccount(); break;
				case 2: System.out.println("\n[은행-입금]"); deposit(); break;
				case 3: System.out.println("\n[은행-출금]"); withdraw(); break;
				case 4: System.out.println("\n[은행-계좌이체]"); accountTransfer(); break;
				case 5: System.out.println("\n[은행-잔액조회]"); balance(); break;
				case 6: System.out.println("\n[은행-거래내역조회]"); transactionHistory(); break;
				case 7:findByAccountNo(); break;
				case 8:findByOwner(); break;
				case 9:accountList(); break;
				}
			} catch (Exception e) {
				System.out.println("메뉴 입력 오류입니다.");
			} // catch_end
		} // while_end
	}
	
	public void addAccount() {
	
		try {
			System.out.print("이름 ? ");
			String name = br.readLine();

			if(name == null || name.trim().length() == 0) {
				System.out.println("이름을 다시 입력해주세요.");
				return;
			}
			
			System.out.print("비밀번호 ? ");
			String pass = br.readLine();

			if(pass == null || pass.trim().length() == 0) {
				System.out.println("비밀번호를 다시 입력해주세요");
				return;
			}
			
			Account nub = bank.addAccount(name, pass);
			AccountVO accVO = nub.getAccountVO();
			System.out.println("계좌번호\t\t이름\t잔액\t개설시각");
			System.out.println
			(accVO.getAccountNo() +"\t" + name + "\t" 
			+nub.getTransactionVO().getBalance() +"\t" + accVO.getLaunch_date());

		} catch (Exception e) {
			System.out.println("메뉴 입력 오류입니다.");
		}
		
	}

	public void deposit() {
		
		try {
			System.out.print("계좌번호 ? ");
			String accoNo = br.readLine();
			
			// 계좌 검증
			Account acc = bank.readAccount(accoNo);
			if(acc == null) {
				System.out.println("존재하지 않는 계좌입니다.");
				return;
			}
			
			System.out.print("입금액 ? ");
			long amount = Long.parseLong(br.readLine());
			if(amount < 10) {
	            System.out.println("10원 이상만 입금 가능합니다.");
	            return;
	         }
			
			TransactionVO t;
			t = bank.deposit(accoNo, amount);
			
			System.out.println("계좌번호\t\t거래정보\t구분\t거래액\t잔고\t시각");
			System.out.println(accoNo + "\t" + t.getInfo() +"\t" + t.getKind() + 
			"\t" +t.getAmount() + "\t" +t.getBalance() +"\t" + t.getTransaction_date());
			
		} catch (Exception e) {
			System.out.println("숫자만 입력 가능합니다.");
		}
	}

	public void withdraw() {
		
		try {
			System.out.print("계좌번호 ? ");
			String accoNo = br.readLine();
			
			// 계좌 검증
			Account acc = bank.readAccount(accoNo);
			if(acc == null) {
				System.out.println("존재하지 않는 계좌입니다.");
				return;
			}
			
			// 비밀번호 검증
			passwordVerify(accoNo);
			
			System.out.print("출금액 ? ");
			long amount = Long.parseLong(br.readLine());
			if(amount < 10) {
	            System.out.println("10원 이상만 입금 가능합니다.");
	            return;
	         }
			
			
			TransactionVO t;
			t = bank.withdraw(accoNo, amount);
			
			// 잔액 부족
			if(t == null) {
				System.out.println("잔액이 부족합니다.");
				return;
			}
			System.out.println("계좌번호\t\t거래정보\t구분\t거래액\t잔고\t시각");
			System.out.println(accoNo + "\t" + t.getInfo() +"\t" + t.getKind() + 
			"\t" +t.getAmount() + "\t" +t.getBalance() +"\t" + t.getTransaction_date());
			
		} catch (Exception e) {
			System.out.println("숫자만 입력 가능합니다.");
		}
	}

	public void accountTransfer() {
	
		try {
			System.out.print("송금할 계좌번호 ? ");
			String accoNo1 = br.readLine();
			
			// 계좌 검증1
			Account acc1 = bank.readAccount(accoNo1);
			if (acc1 == null) {
				System.out.println("존재하지 않는 계좌입니다.");
				return;
			}
			
			System.out.print("송금받을 계좌번호 ? ");
			String accoNo2 = br.readLine();
			if(accoNo1.equals(accoNo2)) {
				System.out.println("동일한 계좌에는 이체가 불가능 합니다.");
				return;
			}
			
			// 계좌 검증2
			Account acc2 = bank.readAccount(accoNo2);
			if (acc2 == null) {
				System.out.println("존재하지 않는 계좌입니다.");
				return;
			}
			
			// 비밀번호 검증
			System.out.println("송금할 계좌의 비밀번호. ");
			passwordVerify(accoNo1);
			
			System.out.print("송금액 ? ");
			long amo = Long.parseLong(br.readLine());
			if(amo < 10) {
	            System.out.println("10원 이상만 입금 가능합니다.");
	            return;
	         }
			
			TransactionVO t;
			t = bank.accountTransfer(accoNo1, accoNo2, amo);
			
			// 잔액 부족 
			if(t == null) {
				System.out.println("잔액이 부족합니다.");
				return;
			}
			
			System.out.println("계좌이체 결과");
			System.out.println("----------------------------------------------------------");
			System.out.println("계좌번호\t\t거래정보\t구분\t거래액\t잔고\t시각");
			System.out.println(accoNo1 + "\t" + t.getInfo() +"\t" + t.getKind() + 
					"\t" +t.getAmount() + "\t" +t.getBalance() +"\t" + t.getTransaction_date());
			
		} catch (Exception e) {
			System.out.println("숫자만 입력 가능합니다.");
		}
	}

	public void balance() throws Exception {
		
		try {
			long l = 0L;
			System.out.print("계좌번호 ? ");
			String accoNo = br.readLine();
			
			// 계좌 검증
			Account acc = bank.readAccount(accoNo);
			if (acc == null) {
				System.out.println("존재하지 않는 계좌입니다.");
				return;
			}
			// 비밀번호 검증
			passwordVerify(accoNo);
			
			// 소유자 이름 가져오기 위해 계좌호출
			Account a = new Account();
			a = bank.readAccount(accoNo);	
			
			l = bank.balance(accoNo);
			System.out.println("계좌번호\t\t소유자\t잔액");
			System.out.println(accoNo+"\t"+a.getAccountVO().getOwner() +"\t" +l);
			
			
		} catch (Exception e) {
		} finally {
			if (cnt == 3) {
				System.out.println("비밀번호 3회이상 틀림 프로그램이 종료됩니다.");
				cnt = 0;
				System.exit(0);
			}
		}
		
	}

	public void transactionHistory() {
		
		try {
			System.out.print("계좌번호 ? ");
			String accoNo = br.readLine();
			
			// 계좌 검증
			Account acc = bank.readAccount(accoNo);
			if (acc == null) {
				System.out.println("존재하지 않는 계좌입니다.");
				return;
			}
			
			// 비밀번호 검증
			passwordVerify(accoNo);
			
			System.out.println("계좌번호\t\t거래정보\t구분\t거래액\t잔고\t시각");
			for(TransactionVO t : bank.transactionHistory(accoNo)) {
				System.out.println(accoNo + "\t" + t.getInfo() +"\t" + t.getKind() + 
			"\t" +t.getAmount() + "\t" +t.getBalance() +"\t" + t.getTransaction_date());
			}
			System.out.println();

		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public void BankaddAccount() {
		System.out.println("\n[은행-계좌 개설]");
		try {
			System.out.print("이름 ? ");
			String name = br.readLine();

			if(name == null || name.trim().length() == 0) {
				System.out.println("이름을 입력해주세요.");
				return;
			}if(pass == null || pass.trim().length() == 0) {
				System.out.println("비밀번호를 입력해주세요");
				return;
			}
			System.out.print("비밀번호 ? ");
			String pass = br.readLine();

			if(pass == null || pass.trim().length() == 0) {
				System.out.println("비밀번호를 입력해주세요");
				return;
			}
			
			Account nub = bank.addAccount(name, pass);
			AccountVO accVO = nub.getAccountVO();
			System.out.println("계좌번호\t\t이름\t잔액\t개설시각");
			System.out.println
			(accVO.getAccountNo() +"\t" + name + "\t" 
			+nub.getTransactionVO().getBalance() +"\t" + accVO.getLaunch_date());

		} catch (Exception e) {
			
		}
		
	}
	
	public void findByAccountNo() {
		System.out.println("\n[은행-계좌번호조회]");
		try {
			System.out.print("검색할 계좌번호 ? ");
			String accoNo = br.readLine();
			
			Account a = new Account();
			a = bank.readAccount(accoNo);
			
			// 계좌 검증
			if (a == null) {
				System.out.println("존재하지 않는 계좌입니다.");
				return;
			}
			
			System.out.println("계좌번호\t\t소유자\t잔액\t계좌개설일자");
			System.out.println(a.getAccountVO().getAccountNo()+"\t" 
			+a.getAccountVO().getOwner() +"\t" + a.getTransactionVO().getBalance() +"\t" +a.getAccountVO().getLaunch_date());
			
		} catch (Exception e) {
		}
	}

	public void findByOwner() {
		System.out.println("\n[은행-이름검색]");
		
		try {
			System.out.print("검색할 이름 ? ");
			String owner = br.readLine();
			
			// 이름 검증
			List<Account> ownlist = bank.getAccountList(owner);
			if(ownlist.size()==0) {
				System.out.println(owner+"의 계좌가 존재하지 않습니다.");
				return;
			}
			
			System.out.println("계좌번호\t\t소유자\t잔액\t계좌개설일자");
			for(Account a : bank.getAccountList(owner)) {
				System.out.println(a.getAccountVO().getAccountNo()+"\t" 
						+a.getAccountVO().getOwner() +"\t" + a.getTransactionVO().getBalance() 
						+"\t" +a.getAccountVO().getLaunch_date());
			}
			
		} catch (Exception e) {
		}
	}

	public void accountList() {
		System.out.println("\n[은행-계좌전체리스트]");
		
		List<Account> allList= bank.getAccountList();
		System.out.println("계좌번호\t\t소유자\t잔액\t계좌개설일자");
		for(Account a : allList) {
			System.out.println(a.getAccountVO().getAccountNo()+"\t" 
					+a.getAccountVO().getOwner() +"\t" + a.getTransactionVO().getBalance() 
					+"\t" +a.getAccountVO().getLaunch_date());
		}
		
	}
	
	public void exitProgram() {
		System.exit(0);
	}
	
	public Boolean passwordVerify(String accountn) throws Exception {
		int n = 0;
		while(true) {
			do {
				String pp = "";
				try {
					System.out.print("비밀번호 ? ");
					pp = br.readLine();
				} catch (Exception e) {
				}
				
				String passOri = bank.readAccount(accountn).getAccountVO().getPassword();
				if(! passOri.equals(pp)) {
					n++;
				} else {
					return true;
				}
				System.out.println("비밀번호가 틀렸습니다.");
				
			} while(n<3);
			
			System.out.println("비밀번호 3회 입력실패. 종료합니다.");
			System.exit(0);
			return false;
		}
	}
}
