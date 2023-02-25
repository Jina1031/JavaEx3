package bankEx;

import java.util.List;

public interface Bank {
	// 계좌 등록
    public Account addAccount(String owner, String pass);
    
    // 입금
    public TransactionVO deposit(String accountNo, long amount);
    
    // 출금
    public TransactionVO withdraw(String accountNo, long amount);
    
    // 계좌이체
    public TransactionVO accountTransfer(String fromAccountNo, String toAccountNo, long amount);
    
    // 잔액조회
    public long balance(String accountNo);
    
    // 거래내역조회
    public List<TransactionVO> transactionHistory(String accountNo);
    
    // 계좌-번호검색
    public Account readAccount(String accountNo);
    
    // 계좌-이름검색
    public List<Account> getAccountList(String owner);
    
    // 계좌-전체리스트
	public List<Account> getAccountList();
	
}
