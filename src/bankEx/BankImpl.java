package bankEx;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BankImpl implements Bank {
	private List<Account> accountList; // 계좌 정보
    private Account account;
	
	public String datetime() {
		return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now());
	}
    
    public BankImpl() {
    	accountList = new ArrayList<>();
    }
    
    public BankImpl(Account account) {
    	this.account = account;
    }
    
    // 계좌 번호 만들기
	protected String generateAccountNo() {
	    String s = "020-08-0000000";
	    if(accountList.size() > 0) {
	    	s = accountList.get(accountList.size()-1).getAccountVO().getAccountNo();
	    }
	    
	    String s1 = s.substring(0, s.lastIndexOf("-"));
	    String s2 = s.substring(s.lastIndexOf("-")+1);
			
	    int n = Integer.parseInt(s2)+1;
			
	    s=s1 + "-" + String.format("%07d", n);
	    
	    return s;
	}
    
	@Override
    public Account addAccount(String owner, String pass) {
		// 계좌 등록 (계좌번호, 이름, 잔액, 계좌개설시간)
		
		
		Account nub = new Account();
		nub.getAccountVO().setAccountNo(generateAccountNo());
		nub.getAccountVO().setOwner(owner);
		nub.getAccountVO().setPassword(pass);
		nub.getAccountVO().setLaunch_date(datetime());
		accountList.add(nub);
		
		TransactionVO tran = new TransactionVO();
		tran.setBalance(0L);
		tran.setAmount(0L);
		tran.setInfo("계좌생성");
		tran.setKind("");
		tran.setTransaction_date(datetime());
		nub.addTransaction(tran);
		
		return nub;
    }

	@Override
    public TransactionVO deposit(String accountNo, long amount) {
    	// 입금
		Account acco = null;
		for(Account vo : accountList) {
			if(vo.getAccountVO().getAccountNo().equals(accountNo)) {
				acco = vo;
			}
		}
		
		long lastbal = acco.getLastTransaction().getBalance();
		
		TransactionVO tran = new TransactionVO();
		tran.setAmount(amount);
		tran.setBalance(lastbal+amount);
		tran.setInfo("입/출금");
		tran.setKind("입금");
		tran.setTransaction_date(datetime());
		acco.addTransaction(tran);
    	
    	return tran;
    }

	@Override
    public TransactionVO withdraw(String accountNo, long amount) {
    	// 출금
		Account acco = null;
		for(Account vo : accountList) {
			if(vo.getAccountVO().getAccountNo().equals(accountNo)) {
				acco = vo;
			} 
		}
		
		long lastbal = acco.getLastTransaction().getBalance();
		if(lastbal - amount < 0) {
			return null;
		}
		
		TransactionVO tran = new TransactionVO();
		tran.setAmount(amount);
		tran.setBalance(lastbal-amount);
		tran.setInfo("입/출금");
		tran.setKind("출금");
		tran.setTransaction_date(datetime());
		acco.addTransaction(tran);
    	
    	return tran;
    }
    
	@Override
	public TransactionVO accountTransfer(String fromAccountNo, String toAccountNo, long amount) {
    	// 계좌이체
		Account from = null;
		Account to = null;
		for(Account vo : accountList) {
			if(vo.getAccountVO().getAccountNo().equals(fromAccountNo)) {
				from = vo;
			} else if (vo.getAccountVO().getAccountNo().equals(toAccountNo)) {
				to = vo;
			} else {
				return null;
			}
		}
		
		TransactionVO fromTran = new TransactionVO();
		TransactionVO toTran = new TransactionVO();
		
		// 송금하는 쪽
		long lastbalFrom = from.getLastTransaction().getBalance();
		if(lastbalFrom - amount < 0) {
			return null;
		}
		
		fromTran.setAmount(amount);
		fromTran.setBalance(lastbalFrom - amount);
		fromTran.setInfo("계좌이체");
		fromTran.setKind("출금");
		fromTran.setTransaction_date(datetime());
		from.addTransaction(fromTran);
		
		// 송금받는 쪽
		long lastbalTo = to.getLastTransaction().getBalance();
		toTran.setAmount(amount);
		toTran.setBalance(lastbalTo + amount);
		toTran.setInfo("계좌이체");
		toTran.setKind("입금");
		toTran.setTransaction_date(datetime());
		to.addTransaction(toTran);

		
    	return fromTran;
    }

	@Override
    public long balance(String accountNo) {
    	// 잔액조회
		for(Account vo : accountList) {
			if(vo.getAccountVO().getAccountNo().equals(accountNo)) {
				return vo.getLastTransaction().getBalance();
			}
		}
			
    	return 0L;
    }

	@Override
    public List<TransactionVO> transactionHistory(String accountNo) {
    	// 거래내역조회
		for(Account a : accountList) {
			if(a.getAccountVO().getAccountNo().equals(accountNo)) {
				return a.getTransactionList();
			}
		}
    	
    	return null;
    }

	@Override
    public Account readAccount(String accountNo) {
    	// 계좌-번호검색
		for(Account vo : accountList) {
			if(vo.getAccountVO().getAccountNo().equals(accountNo)) {
				return vo;
			}
		}
		
    	return null;
    }

	@Override
    public List<Account> getAccountList(String owner) {
    	// 계좌-이름검색
		List<Account> nameList = new ArrayList<>();
		for(Account vo : accountList) {
			if(vo.getAccountVO().getOwner().equals(owner)) {
				nameList.add(vo);
			}
		}
    	
    	return nameList;
    }

	@Override
	public List<Account> getAccountList(){
		// 계좌-전체리스트
		
		return accountList;
	}
}
