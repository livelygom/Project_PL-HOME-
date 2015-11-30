package kr.or.kosta.pl.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import common.util.PagingBean;
import kr.or.kosta.pl.vo.Admin;
import kr.or.kosta.pl.vo.Board;
import kr.or.kosta.pl.vo.Category;
import kr.or.kosta.pl.vo.Product;

//Admin테이블과 연동하는 DAO클래스

@Repository
public class AdminDAOImpl implements AdminDAO {

	private SqlSessionTemplate session; // spring mybatis연동을 위한

	@Autowired
	public AdminDAOImpl(SqlSessionTemplate session) {
		this.session = session;
	}

	public AdminDAOImpl() {
	}

	@Override
	public int insertAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return session.insert("adminMapper.insertAdmin", admin);
	}

	@Override
	public int deleteAdminById(String adminId) {
		// TODO Auto-generated method stub
		return session.delete("adminMapper.deleteAdminById", adminId);
	}

	@Override
	public int updateAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return session.update("adminMapper.updateAdmin", admin);
	}

	@Override
	public Admin selectAdminById(String adminId) {
		// TODO Auto-generated method stub
		return session.selectOne("adminMapper.selectAdminById", adminId);
	}

	@Override
	public List<Admin> selectAdmins() {
		// TODO Auto-generated method stub
		return session.selectList("adminMapper.selectAdmins");
	}

	@Override
	public List<Admin> selectAdminsPaging(int pageNo) {
		HashMap map = new HashMap();
		map.put("contentsPerPage", PagingBean.CONTENTS_PER_PAGE);
		map.put("pageNo", pageNo);
		List<Admin> list = session.selectList("adminMapper.selectAdminsPaging", map);
		return list;
	}

	@Override
	public List<Admin> selectAdminsByName(String adminName) {
		// TODO Auto-generated method stub
		return session.selectList("adminMapper.selectAdminsByName", adminName);
	}

	@Override
	public int selectCountAdmins() {
		// TODO Auto-generated method stub
		return session.selectOne("adminMapper.selectCountAdmins");
	}

	//////////////////////////// 물품관리///////////////////////////////////////////////////

	@Override
	public int insertProduct(Product product) {
		// TODO Auto-generated method stub
		return session.insert("adminMapper.insertProduct", product);
	}

	@Override
	public int updateProduct(Product product) {
		// TODO Auto-generated method stub
		return session.update("adminMapper.updateProduct", product);
	}

	@Override
	public int deleteProductByItemId(int itemId) {
		// TODO Auto-generated method stub
		return session.delete("adminMapper.deleteProductByItemId", itemId);
	}

	@Override
	public Product selectProductByItemId(int itemId) {
		// TODO Auto-generated method stub
		return session.selectOne("adminMapper.selectProductByItemId", itemId);
	}

	@Override
	public List<Product> selectProducts() {
		// TODO Auto-generated method stub
		return session.selectList("adminMapper.selectProducts");
	}

	@Override
	public List<Product> selectProductsPaging(int pageNo) {
		HashMap map = new HashMap();
		map.put("contentsPerPage", PagingBean.CONTENTS_PER_PAGE);
		map.put("pageNo", pageNo);
		List<Product> list = session.selectList("adminMapper.selectProductsPaging", map);
		return list;
	}

	@Override
	public List<Product> selectProductsByItemName(String itemName) {
		HashMap map = new HashMap();
		map.put("itemName", itemName);
		return session.selectList("adminMapper.selectProductsByItemName", map);
	}

	@Override
	public int selectCountProducts() {
		// TODO Auto-generated method stub
		return session.selectOne("adminMapper.selectCountProducts");
	}

	@Override
	public List<Board> selectNotice() {
		return session.selectList("adminMapper.selectNotice");
	}
	
	@Override
	public List<Board> selectBoardsPaging(int pageNo) {
		return session.selectList("adminMapper.selectBoardsPaging", pageNo);
	}

	@Override
	public int selectCountBoards() {
		return session.selectOne("adminMapper.selectBoardCount");
	}

	@Override
	public Board selectBoardByIndex(int index) {
		return session.selectOne("adminMapper.selectBoardInfo", index);
	}

	//////////////////////////// 카테고리관리///////////////////////////////////////////////////

	@Override
	public int insertCategory(Category category) {
		// TODO Auto-generated method stub
		return session.insert("adminMapper.insertCategory", category);
	}

	@Override
	public int deleteCategoryById(int categoryId) {
		// TODO Auto-generated method stub
		return session.delete("adminMapper.deleteCategoryById", categoryId);
	}

	@Override
	public Category selectCategoryById(int categoryId) {
		// TODO Auto-generated method stub
		return session.selectOne("adminMapper.selectCategoryById", categoryId);
	}

	@Override
	public List<Category> selectCategorys() {
		// TODO Auto-generated method stub
		return session.selectList("adminMapper.selectCategorys");
	}

	@Override
	public List<Category> selectCategorysPaging(int pageNo) {
		HashMap map = new HashMap();
		map.put("contentsPerPage", PagingBean.CONTENTS_PER_PAGE);
		map.put("pageNo", pageNo);
		List<Category> list = session.selectList("adminMapper.selectCategorysPaging", map);
		return list;
	}

	@Override
	public int selectCountCategorys() {
		// TODO Auto-generated method stub
		return session.selectOne("adminMapper.selectCountCategorys");
	}

}
