package kr.or.kosta.pl.dao;

import java.util.List;

import kr.or.kosta.pl.vo.Admin;
import kr.or.kosta.pl.vo.Board;
import kr.or.kosta.pl.vo.Category;
import kr.or.kosta.pl.vo.Product;

//관리자 관리 DAO

public interface AdminDAO {

	// 관리자 등록
	int insertAdmin(Admin admin);

	// 관리자 삭제
	int deleteAdminById(String adminId);

	// 관리자 수정
	int updateAdmin(Admin admin);

	// ID로 관리자 찾기
	Admin selectAdminById(String adminId);

	// 관리자 목록조회
	List<Admin> selectAdmins();

	// 관리자 목록 페이지
	List<Admin> selectAdminsPaging(int pageNo);

	// 이름으로 관리자 찾기
	List<Admin> selectAdminsByName(String adminName);

	// 관리자 수
	int selectCountAdmins();

	//////////////////////////// 물품관리///////////////////////////////////////////////////

	// 물품 추가
	int insertProduct(Product product);

	// 물품 삭제
	int deleteProductByItemId(int itemId);

	// 물품 수정
	int updateProduct(Product product);

	// ITEM ID로 물품 찾기
	Product selectProductByItemId(int itemId);

	// 물품 목록 조회
	List<Product> selectProducts();

	// 물품 목록 페이지
	List<Product> selectProductsPaging(int pageNo);

	// 이름으로 물품 찾기
	List<Product> selectProductsByItemName(String itemName);

	// 물품 수
	int selectCountProducts();
	
	List<Board> selectNotice();

	List<Board> selectBoardsPaging(int pageNo);

	int selectCountBoards();

	Board selectBoardByIndex(int index);

	//////////////////////////// 카테고리관리///////////////////////////////////////////////////

	// 카테고리 추가
	int insertCategory(Category category);

	// Category ID로 물품 찾기
	Category selectCategoryById(int categoryId);

	// 카테고리 삭제
	int deleteCategoryById(int categoryId);

	// 카테고리 목록 조회
	List<Category> selectCategorys();

	// 카테고리 목록 페이지
	List<Category> selectCategorysPaging(int pageNo);

	// 카테고리 수
	int selectCountCategorys();
}
