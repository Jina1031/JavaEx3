package ch12.adress;

import java.util.LinkedHashMap;
import java.util.Map;

public class AddressImpl implements Address{
	private Map<String, AddressVO> map = new LinkedHashMap<>(); //등록 순서 유지

	@Override //전화번호 등록
	public void insertAddress(String tel, AddressVO vo) throws DuplicationException {
		if(map.containsKey(tel)) {
			throw new DuplicationException("등록된 전화번호 입니다.");
		} //map 은 key가 동일하면 데이터를 덮어버림
		  //기존에 있는 데이터 덮으면 안되기 때문에 에러를 발생시켜 처리를 못하도록 함
		
		map.put(tel, vo); //map에 저장
	}

	@Override //전화번호로 검색
	public AddressVO readAddress(String tel) {
		return map.get(tel);
	}

	public Map<String, AddressVO> listAdress() {
		return map;
	}
	
	@Override //이름으로 검색
	public Map<String, AddressVO> listAdress(String name) {
		Map<String, AddressVO> finds = new LinkedHashMap<>();
		
		for(String tel : map.keySet()) {
			AddressVO vo = map.get(tel);
			if(vo.getName().indexOf(name)>=0) {
				finds.put(tel, vo);
			}
		}
		return finds;
	}

	@Override
	public boolean deleteAddress(String tel) {
		//map.remove(tel) : 삭제된 데이터 반환
		return map.remove(tel) != null; // null이 아니라는 말은 지워졌다는 뜻.
		                                // 지워진 객체 = 반환 => 지워졌어요
                                 		// 지워진 객체 = null => 지울 게 없어요 or 아무것도 안 지워졌어요
	}



}
