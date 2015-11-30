package kr.or.kosta.pl.service;

import java.util.List;
import java.util.Map;

import kr.or.kosta.pl.exception.*;
import kr.or.kosta.pl.vo.Board;
import kr.or.kosta.pl.vo.Cart;
import kr.or.kosta.pl.vo.Customer;
import kr.or.kosta.pl.vo.Order;
import kr.or.kosta.pl.vo.Product;
import kr.or.kosta.pl.vo.Store;

public interface CustomerService {
	
	/*-------------------------------회원 조회--------------------------------------------*/
	void addCustomer(Customer customer) throws DuplicatedIdException;	//회원 가입
	
	Customer findCustomerById(String customerId);	//회원 아이디로 조회
	
	void modifyCustomoer(Customer customer) throws CustomerNotFoundException; //회원정보 변경
	
	/*-------------------------------물품 조회--------------------------------------------*/
	List<Product> findItemList();	//메인 페이지 12개 랜덤 조회(젠체 물품 중)
	
	Product findItemById(String itemName);	//물품 이름(아이디 대체)으로 물건 1개 조회
	
	List<Product> findItemListByCategorySmallRecommand(int categoryId);	//물품 상세 정보 페이지 내 관련물품 사진 작은거 9개
	
	List<Product> findItemListByCategoryMain(int categoryId);	//카테고리별 페이지 12개 랜덤 조회(카테고리 단위로)

	List<Product> findItemByNameMany(String itemName);	//물품 이름으로 전체 조회
	
	/*-------------------------------매장 검색--------------------------------------------*/
	Store findStoreById(int storeId);	//매장 아이디로 찾기 1개
	
	List<Store> findStoreName(String storeName);	//매장 이름으로 찾기 list
	
	List<Store> findStoreNameByCount(String itemName);	//어떤 물건이 0개이상 존재하는 매장만 출력 (물건으로 검색시 매장 선택 select창)
	
	/*-------------------------------장바구니 처리--------------------------------------------*/
	void addCart(String customerId, int storeId, int itemId, int countItem);	//장바구니 추가
	
	List<Cart> findCartByCusotmerId(String customerId);	//고객 아이디로 장바구니 검색 
	
	void deleteCart(String customerId, int storeId, int itemId);	//장바구니 내용 삭제
	
	/*-------------------------------주문 처리--------------------------------------------*/
	void addOrder(String customerId, int storeId, int itemId, int orderCount, int orderStatus);	//주문 삽입

	List<Order> findOrderByCusotmerId (String customerId);	//주문 조회
	
	/*-------------------------------게시판 처리--------------------------------------------*/
	Map getAllBoard(int pageNo);	//게시판 전체
	
	Board getBoardInfo(int index);	//게시판 정보

	List<Board> getNotice();
	
	Store findStoreKey(String storeName);
	 Store findStoreTime(String storeName);
}
