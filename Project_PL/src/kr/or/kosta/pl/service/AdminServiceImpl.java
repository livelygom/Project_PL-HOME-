package kr.or.kosta.pl.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import common.util.PagingBean;
import kr.or.kosta.pl.dao.AdminDAO;
import kr.or.kosta.pl.exception.AdminNotFoundException;
import kr.or.kosta.pl.exception.DuplicatedIdException;
import kr.or.kosta.pl.vo.Admin;
import kr.or.kosta.pl.vo.Board;
import kr.or.kosta.pl.vo.Category;
import kr.or.kosta.pl.vo.Product;

@Service("adminService")
public class AdminServiceImpl implements AdminService {

	private AdminDAO dao;

	@Autowired
	public AdminServiceImpl(AdminDAO dao) {
		this.dao = dao;
	}

	public AdminServiceImpl() {
	}

	@Override
	public void addAdmin(Admin admin) throws DuplicatedIdException {
		Admin ad = dao.selectAdminById(admin.getAdminId());
		if (ad != null) {
			throw new DuplicatedIdException(admin.getAdminId() + "는 이미 등록된 ID입니다");
		}
		// insert
		dao.insertAdmin(admin);

	}

	@Override
	public List<Admin> getAllAdmins() {
		// TODO Auto-generated method stub
		return dao.selectAdmins();
	}

	@Override
	public Map getAllAdminsPaging(int pageNo) {
		HashMap map = new HashMap();
		map.put("list", dao.selectAdminsPaging(pageNo));
		PagingBean pagingBean = new PagingBean(dao.selectCountAdmins(), pageNo);
		map.put("pagingBean", pagingBean);
		return map;
	}

	@Override
	public Admin findAdminById(String adminId) {
		// TODO Auto-generated method stub
		return dao.selectAdminById(adminId);
	}

	@Override
	public List<Admin> findAdminByName(String adminName) {
		// TODO Auto-generated method stub
		return dao.selectAdminsByName(adminName);
	}

	@Override
	public void removeAdmin(String adminId) throws AdminNotFoundException {
		// TODO Auto-generated method stub
		Admin ad = dao.selectAdminById(adminId);
		if (ad == null) {
			throw new AdminNotFoundException(adminId + "는 없는 ID이므로 삭제할 수 없습니다.");
		}
		dao.deleteAdminById(adminId);
	}

	@Override
	public void updateAdmin(Admin newAd) throws AdminNotFoundException {
		// TODO Auto-generated method stub
		Admin ad = dao.selectAdminById(newAd.getAdminId());
		if (ad == null) {
			throw new AdminNotFoundException(newAd.getAdminId() + "는 없는 ID이므로 수정할 수 없습니다.");
		}
		dao.updateAdmin(newAd);
	}

	//////////////////////////// 물품관리///////////////////////////////////////////////////
	@Override
	public void addProduct(Product product) throws DuplicatedIdException {
		Product pro = dao.selectProductByItemId(product.getItemId());
		if (pro != null) {
			throw new DuplicatedIdException(product.getItemId() + "는 이미 등록된 ID입니다");
		}
		// insert
		dao.insertProduct(product);

	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return dao.selectProducts();
	}

	@Override
	public Map getAllProductsPaging(int pageNo) {
		HashMap map = new HashMap();
		map.put("list", dao.selectProductsPaging(pageNo));
		PagingBean pagingBean = new PagingBean(dao.selectCountProducts(), pageNo);
		map.put("pagingBean", pagingBean);
		return map;
	}

	@Override
	public Product findProductByItemId(int itemId) {
		// TODO Auto-generated method stub
		return dao.selectProductByItemId(itemId);
	}

	@Override
	public List<Product> findProductByItemName(String itemName) {
		// TODO Auto-generated method stub
		return dao.selectProductsByItemName(itemName);
	}

	@Override
	public void removeProduct(int itemId) throws AdminNotFoundException {
		Product pro = dao.selectProductByItemId(itemId);
		if (pro == null) {
			throw new AdminNotFoundException(itemId + "는 없는 ID이므로 삭제할 수 없습니다.");
		}
		dao.deleteProductByItemId(itemId);

	}

	@Override
	public void updateProduct(Product newPro) throws AdminNotFoundException {
		// TODO Auto-generated method stub
		Product pro = dao.selectProductByItemId(newPro.getItemId());
		if (pro == null) {
			throw new AdminNotFoundException(newPro.getItemId() + "는 없는 ID이므로 수정할 수 없습니다.");
		}
		dao.updateProduct(newPro);

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

	//////////////////////////// 케테고리관리///////////////////////////////////////////////////

	@Override
	public void addCategory(Category category) throws DuplicatedIdException {
		Category cate = dao.selectCategoryById(category.getCategoryId());
		if (cate != null) {
			throw new DuplicatedIdException(category.getCategoryId() + "는 이미 등록된 ID입니다");
		}
		// insert
		dao.insertCategory(category);

	}

	@Override
	public void removeCategory(int categoryId) throws AdminNotFoundException {
		Category cate = dao.selectCategoryById(categoryId);
		if (cate == null) {
			throw new AdminNotFoundException(categoryId + "는 없는 ID이므로 삭제할 수 없습니다.");
		}
		dao.deleteCategoryById(categoryId);

	}

	@Override
	public Category findCategoryById(int categoryId) {
		// TODO Auto-generated method stub
		return dao.selectCategoryById(categoryId);
	}

	@Override
	public List<Category> getAllCategorys() {
		// TODO Auto-generated method stub
		return dao.selectCategorys();
	}

	@Override
	public Map getAllCategorysPaging(int pageNo) {
		HashMap map = new HashMap();
		map.put("list", dao.selectCategorysPaging(pageNo));
		PagingBean pagingBean = new PagingBean(dao.selectCountCategorys(), pageNo);
		map.put("pagingBean", pagingBean);
		return map;
	}

}
