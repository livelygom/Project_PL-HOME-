package kr.or.kosta.pl.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import kr.or.kosta.pl.exception.DuplicatedIdException;
import kr.or.kosta.pl.exception.OwnerNotFoundException;
import kr.or.kosta.pl.vo.Board;
import kr.or.kosta.pl.vo.Owner;
import kr.or.kosta.pl.vo.Product;


public interface OwnerService{
	/**
	 * 점장을 등록하는 메소드.
	 *  - 점장 id (id)는 중복될 수 없다.  
	 *  	- 등록하려는 고객의 id와 같은 id의 고객이 이미 등록된 경우 등록 처리 하지 않는다. 
	 * @param owner 등록할 점장 정보를 가진 Owner객체를 받을 매개변수.
	 * @throws SQLException 
	 * @throws DuplicatedIdException 
	 */
	void addOwner(Owner owner) throws DuplicatedIdException;
	
	
	/**
	 * 매개변수로 받은 ID의 점장을 찾아 삭제 처리
	 *  - 매개변수로 받은 ID의 점장이 없으면 처리를 진행하지 않는다. 
	 * @param id
	 * @throws SQLException 
	 * @throws OwnerNotFoundException 삭제할 점장이 DB에 없으면 발생
	 */
	void removeOwner(String ownerId) throws OwnerNotFoundException;
	
	
	
	/**
	 * 매개변수로 받은 점장과 같은 ID를 가진 점장정보를 찾아 수정 처리.
	 *  - 수정하려는 점장의 ID가 없는 경우 처리를 진행하지 않는다.
	 * @param newOwner 변경할 고객 정보
	 * @throws SQLException 
	 * @throws OwnerNotFoundException 수정할 점장이 DB에 없으면 발생
	 */
	void updateOwner(Owner newOwner) throws OwnerNotFoundException;
	
	
//	조회 메소드들
	/**
	 * id로 점장을 찾는 메소드
	 * @param id 조회할 점장의 ID
	 * @return ownerList에서 조회한 고객객체. 찾는 점장이 없으면 null을 리턴한다.
	 * @throws SQLException 
	 */
	Owner findOwnerById(String ownerId) ;
	

	/**
	 * 전체 점장들을 조회하는 메소드.
	 * @return
	 * @throws SQLException
	 */
	List<Owner> getAllOwners();

	
	/**
	 * 이름으로 점장을 조회하는 메소드
	 * @param name 조회할 점장의 이름
	 * @return ownerList에서 조회된 점장들을 담아 리턴할 ArrayList
	 */
	List<Owner> findOwnerByName(String ownerName) ;
	
	
	/**
	 * 점장 id로 모든 점장의 고객의 수를 조회하는 메소드
	 * @param ownerId
	 * @return
	 */
	int getAllCountOwners();

	
	Map getAllProductsPaging(int pageNo,String ownerId);


	List<Product> findProductByName(String productName,String ownerId);

	Map getAllBoard(int pageNo);
	
	Board getBoardInfo(int index);

	Product findOneProductByName(String pName, String ownerId);

	int updateCountProduct(String ownerId, int resultCount, int itemId);


	List<Board> getNotice();


	Map getAllOrderListPaging(int pageNo, String ownerId);


	Map getOrderListByNamePaging(int pageNo, String ownerId, String cusName);
}
