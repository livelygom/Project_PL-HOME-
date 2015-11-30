package kr.or.kosta.pl.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.kosta.pl.vo.Board;
import kr.or.kosta.pl.vo.Cart;
import kr.or.kosta.pl.vo.Customer;
import kr.or.kosta.pl.vo.Order;
import kr.or.kosta.pl.vo.Product;
import kr.or.kosta.pl.vo.Store;

@Repository
public class CustomerDAOImpl implements CustomerDAO{
	
	
	private SqlSessionTemplate session;
	
	@Autowired
	public CustomerDAOImpl(SqlSessionTemplate session){
		this.session = session;
	}
	public CustomerDAOImpl(){}
	/*-------------------------------회원 조회--------------------------------------------*/
	//회원 가입
	@Override
	public int insertCustomer(Customer customer) {

		return session.insert("customerMapper.insertCustomer", customer);
	}
	//회원 아이디로 조회
	@Override
	public Customer selectCustomerById(String customerId) {
		return session.selectOne("customerMapper.selectCustomerById", customerId);
		
		
	}
	
	/*회원정보 변경 11월25일 추가 (효균)*/
	@Override
	public int updateCustomer(Customer customer) {
		return session.update("customerMapper.updateCustomer",customer);
	}
	/*-------------------------------물품 조회--------------------------------------------*/
	//메인 페이지 12개 랜덤 조회(젠체 물품 중)
	@Override
	public List<Product> selectItemList() {
		
		List<Product> list = new ArrayList();
		int[] result = new int[12];

		for (int i = 0; i < 12; i++) {
			result[i] = (int) ((Math.random() * 120) + 1);
			for (int k = 0; k < i; k++) {
				if (result[i] == result[k]) {
					result[i] = (int) ((Math.random() * 120) + 1);
					k = 0;
				}
			}
		}
		for(int i =0; i<12; i++){
			Product pd = session.selectOne("customerMapper.selectItemList", result[i]);		
			list.add(pd);		
		}	
		return list;
	}
	//물품 이름으로 물건 1개 조회
	@Override
	public Product selectItemByName(String itemName) {

		Product pd =session.selectOne("customerMapper.selectItemByName", itemName);

		return session.selectOne("customerMapper.selectItemByName", itemName);
	}
	//카테고리별 페이지 12개 랜덤 조회(카테고리 단위로)
	@Override
	public List<Product> selectItemListByCategory(int categoryId) {
		
		List<Product> list = new ArrayList();
		//mapper에서 카테고리 개수만큼 찾아와야함
		list = session.selectList("customerMapper.selectItemListByCategory", categoryId);
		
//		for(int i =0; i<12; i++){
//			Product pd = session.selectOne("customerMapper.selectItemListByCategory", categoryId);
//			
//			list.add(pd);		
//		}	
		return list;
	}
	//물품 이름으로 전체 조회
	@Override
	public List<Product> selectItemByNameMany(String itemName) {
		List<Product> list = new ArrayList();
		list =session.selectList("customerMapper.selectItemByNameMany", itemName);
		return list;
	}
	/*-------------------------------매장 검색--------------------------------------------*/
	//매장 아이디로 찾기 1개
		@Override
	public Store selectStoreById(int storeId) {
		
		return session.selectOne("customerMapper.selectStoreById", storeId);
	}
	//매장 이름으로 찾기 list
	@Override
	public List<Store> selectStoreName(String storeName) {
		return session.selectList("customerMapper.findStoreName",storeName);
	}
	//어떤 물건이 0개이상 존재하는 매장만 출력 (물건으로 검색시 매장 선택 select창)
	@Override
	public List<Store> selectStoreNameByCount(String itemName) {
		List<Store> list = new ArrayList();
		list = session.selectList("customerMapper.selectStoreByCount", itemName);
		return list;
	}
	
	/*-------------------------------장바구니 처리--------------------------------------------*/
	//장바구니 추가
	@Override
	public int insertCart(String customerId, int storeId, int itemId, int countItem) {
		// TODO 중복 검사 해 주어야 함
		HashMap parameter = new HashMap();
		parameter.put("customerId", customerId);
		parameter.put("storeId", storeId);
		parameter.put("itemId", itemId);
		parameter.put("countItem", countItem);
		
		return session.insert("customerMapper.insertCart", parameter);
	}
	//고객 아이디로 장바구니 검색 
	@Override
	public List<Cart> selectCartByCustomerId(String customerId) {
	
		return session.selectList("customerMapper.selectCartByCustomerId", customerId);
	}
	//장바구니 내용 삭제
	@Override
	public int deleteCart(String customerId, int storeId, int itemId) {
		
		HashMap parameter = new HashMap();
		
		parameter.put("customerId", customerId);
		parameter.put("storeId", storeId);
		parameter.put("itemId", itemId);

		return session.delete("customerMapper.deleteCart", parameter);
	}
	/*-------------------------------주문 처리--------------------------------------------*/
	//주문 삽입
	@Override
	public int insertOrder(String customerId, int storeId, int itemId, int orderCount, int orderStatus) {
		
		HashMap parameter =new HashMap();
		parameter.put("cusotmerId", customerId);
		parameter.put("storeId", storeId);
		parameter.put("itemId", itemId);
		parameter.put("orderCount", orderCount);
		parameter.put("orderStatus", orderStatus);
		
		System.out.println(customerId);
				
		return session.insert("customerMapper.insertOrder", parameter);
	}
	//주문 조회
	@Override
	public List<Order> selectOrderByCustomerId(String customerId) {
		
		return session.selectList("customerMapper.selectOrderByCustomerId", customerId);
	
	}
	/*-------------------------------게시판 처리--------------------------------------------*/
	//게시판 페이지
	@Override
	public List<Board> selectBoardsPaging(int pageNo) {
		return session.selectList("customerMapper.selectBoardsPaging", pageNo);
	}
	//게시판 개수
	@Override
	public int selectCountBoards() {
		return session.selectOne("customerMapper.selectBoardCount");
	}
	//게시판 선택
	@Override
	public Board selectBoardByIndex(int index) {
		return session.selectOne("customerMapper.selectBoardInfo", index);
	}

	@Override
	public List<Board> selectNotice() {
		return session.selectList("customerMapper.selectNotice");
	}
	@Override
	public Store selectStoreKey(String storeName) {
		System.out.println(storeName + "DAO");
		return session.selectOne("customerMapper.findStoreKey", storeName);
	}
	
	@Override
	public Store selectStoreTime(String storeName) {
		System.out.println(storeName + "DAO");
		return session.selectOne("customerMapper.findStoreTime", storeName);
	}
	
	
}
