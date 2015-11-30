package kr.or.kosta.pl.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.kosta.pl.exception.AdminNotFoundException;
import kr.or.kosta.pl.exception.DuplicatedIdException;
import kr.or.kosta.pl.service.AdminService;
import kr.or.kosta.pl.validate.AdminValidator;
import kr.or.kosta.pl.validate.CategoryValidator;
import kr.or.kosta.pl.validate.ProductValidator;
import kr.or.kosta.pl.vo.Admin;
import kr.or.kosta.pl.vo.Board;
import kr.or.kosta.pl.vo.Category;
import kr.or.kosta.pl.vo.Product;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService service;

	// ID로 관리자 조회
	@RequestMapping("/findById")
	public String findById(@RequestParam String adminId, ModelMap model) {
		Admin admin = service.findAdminById(adminId);
		model.addAttribute("admin", admin);
		return "test1/admin_info.tiles";
	}

	// 관리자 List 조회처리 Handler
	@RequestMapping("list")
	public String list(@RequestParam(defaultValue = "1") String pageNo, ModelMap model) {
		int page = 1;
		try {
			page = Integer.parseInt(pageNo); // null일 경우 예외처리를 통해 page를 1로
												// 처리한다..
		} catch (NumberFormatException e) {
		}
		Map attributes = service.getAllAdminsPaging(page);
		model.addAllAttributes(attributes);
		return "test1/list.tiles";
	}

	// 관리자 등록
	@RequestMapping("add")
	public String add(@ModelAttribute Admin admin, Errors errors, ModelMap model) throws DuplicatedIdException {
		new AdminValidator().validate(admin, errors);
		if (errors.hasErrors()) {
			return "test1/register_form.tiles";
		}

		service.addAdmin(admin);
		model.addAttribute("adminId", admin.getAdminId());
		return "redirect:/admin/registerSuccess.do";
	}

	// 등록 후 성공페이지로 이동 처리.
	@RequestMapping("registerSuccess")
	public String registerSuccess(@RequestParam String adminId, ModelMap model) {

		model.addAttribute("admin", service.findAdminById(adminId));
		return "test1/register_success.tiles";
	}

	// 수정폼 조회
	@RequestMapping("modifyForm")
	public String modifyForm(@RequestParam(defaultValue = "") String adminId, ModelMap model) throws Exception {
		// 요청파라미터 검증
		if (adminId.trim().length() == 0) {
			throw new Exception("수정할 관리자의 아이디가 없습니다.");
		}

		model.addAttribute("admin", service.findAdminById(adminId));

		return "test1/modify_form.tiles";
	}

	// 수정 처리
	@RequestMapping("/modify")
	public String modify(@ModelAttribute Admin admin, HttpSession session) throws AdminNotFoundException {
		service.updateAdmin(admin);
		Admin newAdmin = service.findAdminById(admin.getAdminId());
		session.setAttribute("sessionUser", newAdmin);
		return "redirect:/admin/adminMypageForm.do";
	}

	// 관리자 삭제 처리 HandlerattributeValue
	@RequestMapping("remove.do")
	public String remove(@RequestParam(defaultValue = "") String adminId,
			@RequestParam(defaultValue = "1") String pageNo, ModelMap model) throws Exception {

		if (adminId.trim().length() == 0) {
			throw new Exception("삭제할 관리자의 아이디가 없습니다.");
		}
		// 비지니스 로직 - 삭제처리(removeCustomer())
		service.removeAdmin(adminId);
		model.addAttribute("pageNo", pageNo);
		return "redirect:/admin/list.do";
	}

	@RequestMapping("idDuplicatedCheck")
	@ResponseBody
	public String idDuplicatedCheck(@RequestParam String adminId) {
		Admin ad = service.findAdminById(adminId);
		return String.valueOf(ad != null); // 중복인 경우 "true" 리턴
	}

	//////////////////////////// 물품관리///////////////////////////////////////////////////

	// ID로 물품 조회
	@RequestMapping("/findByItemId")
	public String findByItemId(@RequestParam int itemId, ModelMap model) {
		Product product = service.findProductByItemId(itemId);
		model.addAttribute("product", product);
		return "/WEB-INF/admin/item_management/product_info.jsp";
	}

	// 품명으로 물품조회
	@RequestMapping("/productsByItemName")
	public String ProductsByItemName(@RequestParam String searchValue, ModelMap model) {
		/*
		 * Product product = service.findProductByItemName(itemName);
		 * model.addAttribute("product", product); return
		 * "test2/product_info.tiles";
		 */

		String resultValue = "";
		List<Product> product = null;

		resultValue = searchValue;
		product = service.findProductByItemName(resultValue);
		model.addAttribute("product", product);
		return "/WEB-INF/admin/item_management/itemSearch_result.jsp";

	}

	// 물품 List 조회
	@RequestMapping("/itemList")
	public String itemList(@RequestParam(defaultValue = "1") String pageNo, ModelMap model) {
		int page = 1;
		try {
			page = Integer.parseInt(pageNo); // null일 경우 예외처리를 통해 page를 1로
												// 처리한다..
		} catch (NumberFormatException e) {
		}
		Map attributes = service.getAllProductsPaging(page);
		model.addAllAttributes(attributes);
		return "/WEB-INF/admin/item_management/itemList.jsp";
	}

	// 물품 등록
	@RequestMapping("/itemAdd")
	public String itemAdd(@ModelAttribute Product product, Errors errors, ModelMap model) throws DuplicatedIdException {
		new ProductValidator().validate(product, errors);
		if (errors.hasErrors()) {
			return "/WEB-INF/admin/item_management/itemRegister_form.jsp";
		}
		service.addProduct(product);
		model.addAttribute("itemId", product.getItemId());
		return "redirect:/admin/itemRegisterSuccess.do";
	}

	// 물품 등록 후 성공페이지로 이동 처리.
	@RequestMapping("/itemRegisterSuccess")
	public String itemRegisterSuccess(@RequestParam int itemId, ModelMap model) {

		model.addAttribute("product", service.findProductByItemId(itemId));
		return "/WEB-INF/admin/item_management/itemRegister_success.jsp";
	}

	// 물품 수정폼 조회
	@RequestMapping("/itemModifyForm")
	public String itemModifyForm(@RequestParam(defaultValue = "") int itemId, ModelMap model) throws Exception {
		// 요청파라미터 검증
		String item = Integer.toString(itemId);
		if (item.trim().length() == 0) {
			throw new Exception("수정할 물품의 아이디가 없습니다.");
		}

		model.addAttribute("product", service.findProductByItemId(itemId));

		return "/WEB-INF/admin/item_management/itemModify_form.jsp";
	}

	// 수정 처리
	@RequestMapping("/itemModify")
	public String itemModify(@ModelAttribute Product product, Errors errors,
			@RequestParam(defaultValue = "1") String pageNo, ModelMap model) throws Exception {
		new ProductValidator().validate(product, errors);

		if (errors.hasErrors()) {
			return "test2/itemModify_form.tiles";
		}
		service.updateProduct(product);
		model.addAttribute("itemId", product.getItemId());
		model.addAttribute("pageNo", pageNo);
		return "redirect:/admin/findByItemId.do";
	}

	// 삭제 처리 HandlerattributeValue
	@RequestMapping("/itemRemove.do")
	public String itemRemove(@RequestParam(defaultValue = "") int itemId,
			@RequestParam(defaultValue = "1") String pageNo, ModelMap model) throws Exception {
		String item = Integer.toString(itemId);
		if (item.trim().length() == 0) {
			throw new Exception("삭제할 물품의 아이디가 없습니다.");
		}
		// 비지니스 로직 - 삭제처리(removeCustomer())
		service.removeProduct(itemId);
		model.addAttribute("pageNo", pageNo);
		return "redirect:/admin/itemList.do";
	}

	@RequestMapping("/idDuplicatedCheck2")
	@ResponseBody
	public String idDuplicatedCheck2(@RequestParam int itemId) {
		Product pro = service.findProductByItemId(itemId);
		return String.valueOf(pro != null); // 중복인 경우 "true" 리턴
	}

	@RequestMapping("/adminMypageForm")
	public String ownerMypageForm() {
		return "/WEB-INF/mypage/admin/mypage_admin.jsp";
	}

	@RequestMapping("/boardList")
	public String boardList(@RequestParam(defaultValue = "1") String pageNo, ModelMap model) {
		int page = Integer.parseInt(pageNo);
		System.out.println("pageNo = " + page);
		List<Board> notice = service.getNotice();
		Map map = service.getAllBoard(page);

		model.addAttribute("notice", notice);
		model.addAttribute("list", map.get("list"));
		model.addAttribute("pagingBean", map.get("pagingBean"));
		return "/WEB-INF/board/board_admin.jsp";
	}

	@RequestMapping("/boardInfo")
	public String boardInfo(@RequestParam String boardIndex, ModelMap model) {
		int index = Integer.parseInt(boardIndex);
		Board board = service.getBoardInfo(index);

		System.out.println("--asdfasdf");

		model.addAttribute("board", board);
		return "/WEB-INF/board/board_info_admin.jsp";
	}
	// 2차커밋

	//////////////////////////// 카테고리//////////////////////////// 
	// 카테고리 등록
	@RequestMapping("/categoryAdd")
	public String categoryAdd(@ModelAttribute Category category, Errors errors, ModelMap model)
			throws DuplicatedIdException {

		new CategoryValidator().validate(category, errors);
		if (errors.hasErrors()) {
			return "/WEB-INF/admin/item_management/categoryRegister_form.jsp";
		}

		service.addCategory(category);
		model.addAttribute("categoryId", category.getCategoryId());
		return "redirect:/admin/categoryRegisterSuccess.do";

	}

	// 카테고리 등록 후 성공페이지로 이동 처리.
	@RequestMapping("/categoryRegisterSuccess")
	public String categoryRegisterSuccess(@RequestParam int categoryId, ModelMap model) {

		model.addAttribute("category", service.findCategoryById(categoryId));
		return "/WEB-INF/admin/item_management/categoryRegister_success.jsp";
	}

	// ID로 카테고리 조회
	@RequestMapping("/findByCategoryId")
	public String findByCategoryId(@RequestParam int categoryId, ModelMap model) {
		Category category = service.findCategoryById(categoryId);
		model.addAttribute("category", category);
		return "/WEB-INF/admin/item_management/category_info.jsp";
	}

	// 삭제 처리 HandlerattributeValue
	@RequestMapping("/categoryRemove.do")
	public String categoryRemove(@RequestParam(defaultValue = "") int categoryId,
			@RequestParam(defaultValue = "1") String pageNo, ModelMap model) throws Exception {
		String category = Integer.toString(categoryId);
		if (category.trim().length() == 0) {
			throw new Exception("삭제할 카테고리의 아이디가 없습니다.");
		}
		// 비지니스 로직 - 삭제처리()
		service.removeCategory(categoryId);
		model.addAttribute("pageNo", pageNo);
		return "redirect:/admin/categoryList.do";
	}

	// 카테고리 List 조회
	@RequestMapping("/categoryList")
	public String categoryList(@RequestParam(defaultValue = "1") String pageNo, ModelMap model) {
		int page = 1;
		try {
			page = Integer.parseInt(pageNo); // null일 경우 예외처리를 통해 page를 1로
			// 처리한다..
		} catch (NumberFormatException e) {
		}
		Map attributes = service.getAllCategorysPaging(page);
		model.addAllAttributes(attributes);
		return "/WEB-INF/admin/item_management/categoryList.jsp";
	}

	@RequestMapping("/idDuplicatedCheck3")
	@ResponseBody
	public String idDuplicatedCheck3(@RequestParam int categoryId) {
		Category cate = service.findCategoryById(categoryId);
		return String.valueOf(cate != null); // 중복인 경우 "true" 리턴
	}
}
