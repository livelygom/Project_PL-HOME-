package kr.or.kosta.pl.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import common.util.PagingBean;
import kr.or.kosta.pl.dao.OwnerDAO;
import kr.or.kosta.pl.exception.DuplicatedIdException;
import kr.or.kosta.pl.exception.OwnerNotFoundException;
import kr.or.kosta.pl.vo.Board;
import kr.or.kosta.pl.vo.Owner;
import kr.or.kosta.pl.vo.Product;

@Service("OwnerServiceImpl")
public class OwnerServiceImpl implements OwnerService {
	@Autowired
	private OwnerDAO dao;
	
	public OwnerServiceImpl(){}
	
	@Autowired
	public OwnerServiceImpl(OwnerDAO dao) {
		this.dao = dao;
	}
	
	/**
	 * 점장을 등록하는 메소드.
	 *  - 점장 id (id)는 중복될 수 없다.
	 *  	- 등록하려는 점장의 id와 같은 id의 고객이 이미 등록된 경우 등록 처리 하지 않는다.
	 * @param owner - 등록할 점장 정보를 가진 Owner객체를 받을 매개변수
	 * @throws DuplicatedIdException
	 */
	@Override
	public void addOwner(Owner owner) throws DuplicatedIdException {
		//등록할 점장의 id로 고객조회
		//ID 중복 체크 
		Owner own = dao.selectOwnerById(owner.getOwnerId());
		
		if(own != null){
			//이미 있는 점장id이면 예외발생
			throw new DuplicatedIdException(own.getOwnerId()+"는 이미 등록된 ID입니다.");
			
		}
		//DB에 insert
		dao.insertOwner(owner);
		
	}
	
	
	//점장id로 점장 삭제하는 메소드 
	@Override
	public void removeOwner(String ownerId) throws OwnerNotFoundException {
		Owner own = dao.selectOwnerById(ownerId);
		
		if(own == null){
			throw new OwnerNotFoundException(ownerId+"는 없는 ID입니다.");
		}
		
		dao.deleteOwnerById(ownerId);
		
	}
	
	
	//점장 수정하는 메소드 
	@Override
	public void updateOwner(Owner newOwner) throws OwnerNotFoundException {
		Owner own = dao.selectOwnerById(newOwner.getOwnerId());
		if(own== null){
			throw new OwnerNotFoundException(newOwner.getOwnerId()+"는 없는 ID이므로 수정할 수 없습니다.");
		}
		
		dao.updateOwner(newOwner);
		
	}
	
	
	/**
	 * 점장id로 점장 찾는 메소드 
	 * @param ownerId
	 * @return
	 * @throws OwnerNotFoundException 
	 */
	@Override
	public Owner findOwnerById(String ownerId) {
		Owner own = dao.selectOwnerById(ownerId);
		
		return dao.selectOwnerById(ownerId);
	}
	
	
	//모든 점장 찾는 메소드
	@Override
	public List<Owner> getAllOwners() {
		return dao.selectOwners();
	}
	
	
	//점장이름으로 점장찾는 메소드
	@Override
	public List<Owner> findOwnerByName(String ownerName) {
		
		List<Owner> list = dao.selectOwnersByName(ownerName);
		
		return dao.selectOwnersByName(ownerName);
	}
	
	//점장id로 모든 점장의 수를 리턴하는 메소드
	/**
	 */
	@Override
	public int getAllCountOwners() {
		return dao.selectCountOwners();
	}

	@Override
	public Map getAllProductsPaging(int pageNo,String ownerId) {
		HashMap map = new HashMap();
		map.put("list",dao.selectProductsPaging(pageNo,ownerId));
		PagingBean pagingBean = new PagingBean(dao.selectCountProducts(ownerId), pageNo);
		map.put("pagingBean", pagingBean);
		map.put("ownerId", ownerId);
		return map;
		
		
	}

	//재고검색 - 물품이름으로 검색하는 메소드
	@Override
	public List<Product> findProductByName(String productName,String ownerId) {
		return dao.selectProductByName(productName,ownerId);
	}
	
	@Override
	public List<Board> getNotice() {
		List<Board> list = dao.selectNotice();
		return list;
	}

	@Override
	public Map getAllBoard(int pageNo) {
		HashMap map = new HashMap();
		List<Board> list = dao.selectBoardsPaging(pageNo);
		PagingBean pagingBean = new PagingBean(dao.selectCountBoards(), pageNo);

		map.put("list", list);
		map.put("pagingBean", pagingBean);

		return map;
	}

	@Override
	public Board getBoardInfo(int index) {
		Board board = dao.selectBoardByIndex(index);
		return board;
	}
	
	public Product findOneProductByName(String pName, String ownerId) {
		
		return dao.selectOneProduct(pName,ownerId);
	}

	@Override
	public int updateCountProduct(String ownerId, int resultCount ,int itemId) {
		return dao.updateInputProduct(ownerId,resultCount,itemId);
	}
	
	//주문현황 list 조회 메소드 
	@Override
	public Map getAllOrderListPaging(int pageNo, String ownerId) {
		HashMap map = new HashMap();
		map.put("list",dao.selectOrdersPaging(pageNo,ownerId));
		PagingBean pagingBean = new PagingBean(dao.selectCountOrders(ownerId), pageNo);
		System.out.println("총 주문 개수 : " + dao.selectCountOrders(ownerId));
		map.put("pagingBean", pagingBean);
		map.put("ownerId", ownerId);
		return map;
	}
	
	//고객이름으로 검색한 주문현황 list 조회 메소드 
	@Override
	public Map getOrderListByNamePaging(int pageNo, String ownerId,String cusName) {
		HashMap map = new HashMap();
		map.put("list", dao.selectOrdersByNamePaging(pageNo,ownerId,cusName));
		PagingBean pagingBean = new PagingBean(dao.selectCountOrdersByName(ownerId,cusName), pageNo);
		map.put("pagingBean", pagingBean);
		map.put("ownerId", ownerId);
		map.put("customerName",cusName);
		return map;
		
		//System.out.println("안동신이 주문한 물품 종류 개수 : "+dao.selectCountOrdersByName(ownerId,cusName) );
		
	}
}
