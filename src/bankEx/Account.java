package bankEx;

import java.util.ArrayList;
import java.util.List;

// 계좌 정보 및 계좌 거래 내역 정보
public class Account {
	private AccountVO accountVO;  // 계좌정보
	private List<TransactionVO> transactionList; // 계좌별거래내역
	
	public Account() {
		accountVO = new AccountVO();
		transactionList = new ArrayList<>();
	}
	
	public TransactionVO getTransactionVO() {
		
		return transactionList.get(transactionList.size()-1);
	}
	
	public AccountVO getAccountVO() {
		return accountVO;
	}
	
	public List<TransactionVO> getTransactionList() {
		// 전체 거래 리스트
		return transactionList;
	}
	
	public boolean addTransaction(TransactionVO vo) {
		// 거래 내역 등록
		
		transactionList.add(vo);
		
		return false;
	}
	
	public TransactionVO getLastTransaction() {
		// 마지막 거래 내역
		
		return transactionList.get(transactionList.size()-1);
	}
}
