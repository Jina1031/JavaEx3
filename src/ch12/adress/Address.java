package ch12.adress;

import java.util.Map;

public interface Address {
	public void insertAddress(String tel, AddressVO vo) throws DuplicationException;
	public AddressVO readAddress(String tel);
	public Map<String, AddressVO> listAdress();
	public Map<String, AddressVO> listAdress(String name);
	public boolean deleteAddress(String tel);
}
