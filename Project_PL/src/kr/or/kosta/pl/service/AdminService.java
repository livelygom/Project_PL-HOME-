package kr.or.kosta.pl.service;

import java.util.List;
import java.util.Map;

import kr.or.kosta.pl.exception.AdminNotFoundException;
import kr.or.kosta.pl.exception.DuplicatedIdException;
import kr.or.kosta.pl.vo.Admin;
import kr.or.kosta.pl.vo.Board;
import kr.or.kosta.pl.vo.Category;
import kr.or.kosta.pl.vo.Product;

public interface AdminService {

	void addAdmin(Admin admin) throws DuplicatedIdException;

	List<Admin> getAllAdmins();

	Map getAllAdminsPaging(int pageNo);

	Admin findAdminById(String adminId);

	List<Admin> findAdminByName(String adminName);

	void removeAdmin(String adminId) throws AdminNotFoundException;

	void updateAdmin(Admin newAdmin) throws AdminNotFoundException;

	//////////////////////////// 물품관리///////////////////////////////////////////////////

	void addProduct(Product product) throws DuplicatedIdException;

	List<Product> getAllProducts();

	Map getAllProductsPaging(int pageNo);

	Product findProductByItemId(int itemId);

	List<Product> findProductByItemName(String itemName);

	void removeProduct(int itemId) throws AdminNotFoundException;

	void updateProduct(Product newPro) throws AdminNotFoundException;
	
	//////////////////////////// 게시판 //////////////////////////////////////////////////////

	Map getAllBoard(int pageNo);
	
	List<Board> getNotice();

	Board getBoardInfo(int index);

	//////////////////////////// 케테고리관리///////////////////////////////////////////////////

	void addCategory(Category category) throws DuplicatedIdException;

	Category findCategoryById(int categoryId);

	void removeCategory(int categoryId) throws AdminNotFoundException;

	List<Category> getAllCategorys();

	Map getAllCategorysPaging(int pageNo);
}
