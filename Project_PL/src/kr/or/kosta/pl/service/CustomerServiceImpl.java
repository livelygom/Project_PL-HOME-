package kr.or.kosta.pl.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import common.util.PagingBean;
import kr.or.kosta.pl.dao.CustomerDAO;
import kr.or.kosta.pl.exception.*;
import kr.or.kosta.pl.vo.Board;
import kr.or.kosta.pl.vo.Cart;
import kr.or.kosta.pl.vo.Customer;
import kr.or.kosta.pl.vo.Order;
import kr.or.kosta.pl.vo.Product;
import kr.or.kosta.pl.vo.Store;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService{

	private CustomerDAO dao;
	
	public CustomerServiceImpl() {}
	
	@Autowired
	public CustomerServiceImpl(CustomerDAO dao){
		this.dao = dao;		
	}
	
	/*-------------------------------회원 조회--------------------------------------------*/
	//회원 가입
	@Override
	public void addCustomer(Customer customer) throws DuplicatedIdException{

		//입력된 객체의 아이디를 통해 db를 검색
		Customer cust = dao.selectCustomerById(customer.getCustomerId());
		
		if(cust != null){	//중복검사 같은 아이디가 있을 경우 에러 출력
			throw new DuplicatedIdException(customer.getCustomerId()+"는 이미 존재하는 아이디입니다.");
		}
		//비어있을 경우 insert
		dao.insertCustomer(customer);
	}
	//회원 아이디로 조회
	@Override
	public Customer findCustomerById(String customerId) {
		
		Customer customer = dao.selectCustomerById(customerId);
		
		return customer;
	}
	
	/*회원정보변경하는 메소드 서비스임플 11월25일추가 (효균)*/
	@Override
	public void modifyCustomoer(Customer customer) throws CustomerNotFoundException {
		dao.updateCustomer(customer);
	}

	/*-------------------------------물품 조회--------------------------------------------*/
	//메인 페이지 12개 랜덤 조회(젠체 물품 중)
	@Override
	public List<Product> findItemList() {
		return dao.selectItemList();
	}
	//물품 이름(아이디 대체)으로 물건 1개 조회
	@Override
	public Product findItemById(String itemName) {
		return dao.selectItemByName(itemName);
	}
	//물품 상세 정보 페이지 내 관련물품 사진 작은거 9개
	@Override
	public List<Product> findItemListByCategorySmallRecommand(int categoryId) {
		
		List<Product> list = new ArrayList();
		List<Product> list2 = dao.selectItemListByCategory(categoryId);
		//9개만 사용
		int[] result = new int[9];

		for (int i = 0; i < 9; i++) {
			result[i] = (int) ((Math.random() * (dao.selectItemListByCategory(categoryId).size()-1)) );
			for (int k = 0; k < i; k++) {
				if (result[i] == result[k]) {
					result[i] = (int) ((Math.random() * (dao.selectItemListByCategory(categoryId).size()-1)));
					k = 0;
				}
			}
		}
		for(int i =0; i<9; i++){
			list.add(list2.get(result[i]));	
		}
		return list;
	}
	//카테고리별 페이지 12개 랜덤 조회(카테고리 단위로)
	@Override
	public List<Product> findItemListByCategoryMain(int categoryId) {
		
		List<Product> list = new ArrayList();
		List<Product> list2 = dao.selectItemListByCategory(categoryId);
		//9개만 사용
		int[] result = new int[12];

		for (int i = 0; i < 12; i++) {
			result[i] = (int) ((Math.random() * (dao.selectItemListByCategory(categoryId).size()-1)) );
			for (int k = 0; k < i; k++) {
				if (result[i] == result[k]) {
					result[i] = (int) ((Math.random() * (dao.selectItemListByCategory(categoryId).size()-1)));
					k = 0;
				}
			}
		}
		for(int i =0; i<12; i++){
			list.add(list2.get(result[i]));	
		}
		return list;
	}
	//물품 이름으로 전체 조회
	@Override
	public List<Product> findItemByNameMany(String itemName) {
	
		return dao.selectItemByNameMany(itemName);
	}
	
	/*-------------------------------매장 검색--------------------------------------------*/
	//매장 아이디로 찾기 1개
	@Override
	public Store findStoreById(int storeId) {
		
		return dao.selectStoreById(storeId);
	}
	//매장 이름으로 찾기 list
	@Override
	public List<Store> findStoreName(String storeName) {
		return dao.selectStoreName(storeName);
	}
	//어떤 물건이 0개이상 존재하는 매장만 출력 (물건으로 검색시 매장 선택 select창)
	@Override
	public List<Store> findStoreNameByCount(String itemName) {
		
		return dao.selectStoreNameByCount(itemName);
	}
	
	/*-------------------------------장바구니 처리--------------------------------------------*/
	//장바구니 추가
	@Override
	public void addCart(String customerId, int storeId, int itemId, int countItem) {
		dao.insertCart(customerId, storeId, itemId, countItem);
	}
	//고객 아이디로 장바구니 검색
	@Override
	public List<Cart> findCartByCusotmerId(String customerId) {
		return dao.selectCartByCustomerId(customerId);
	}
	//장바구니 내용 삭제
	@Override
	public void deleteCart(String customerId, int storeId, int itemId) {
		dao.deleteCart(customerId, storeId, itemId);
	}
	
	/*-------------------------------주문 처리--------------------------------------------*/
	//주문 삽입
	@Override
	public void addOrder(String customerId, int storeId, int itemId, int orderCount, int orderStatus) {
		dao.insertOrder(customerId, storeId, itemId, orderCount, orderStatus);
	}
	//주문 조회
	@Override
	public List<Order> findOrderByCusotmerId(String customerId) {
		
		return dao.selectOrderByCustomerId(customerId);
	}
	
	/*-------------------------------게시판 처리--------------------------------------------*/
	//게시판 전체
	@Override
	public Map getAllBoard(int pageNo) {
		HashMap map = new HashMap();
		List<Board> list = dao.selectBoardsPaging(pageNo);
		PagingBean pagingBean = new PagingBean(dao.selectCountBoards(), pageNo);
		
		map.put("list", list);
		map.put("pagingBean", pagingBean);

		return map;
	}
	//게시판 정보
	@Override
	public Board getBoardInfo(int index) {
		Board board = dao.selectBoardByIndex(index);
		return board;
	}

	@Override
	public List<Board> getNotice() {
		List<Board> list = dao.selectNotice();
		return list;
	}
	
	@Override
	public Store findStoreKey(String storeName) {
		System.out.println(storeName + "서비스");
		return dao.selectStoreKey(storeName);
	}
	
	@Override
	public Store findStoreTime(String storeName) {
		System.out.println(storeName + "서비스");
		return dao.selectStoreTime(storeName);
	}

}
