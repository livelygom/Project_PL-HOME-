package kr.or.kosta.pl.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.*;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import kr.or.kosta.pl.exception.DuplicatedIdException;
import kr.or.kosta.pl.service.CustomerService;
import kr.or.kosta.pl.validate.CustomerValidator;
import kr.or.kosta.pl.vo.Board;
import kr.or.kosta.pl.vo.Cart;
import kr.or.kosta.pl.vo.Customer;
import kr.or.kosta.pl.vo.Order;
import kr.or.kosta.pl.vo.Store;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService service;

	/*-------------------------------위쪽 페이지 이동---------------------------------------*/
	// 마이페이지
	@RequestMapping("/mypage")
	public String mypage(HttpSession session, ModelMap model) {

		Customer customer = (Customer) session.getAttribute("sessionUser");
		List<Order> order = service.findOrderByCusotmerId(customer.getCustomerId());

		model.addAttribute("order", order);

		return "/WEB-INF/mypage/customer/mypage_customer.jsp";
	}

	// 장바구니
	@RequestMapping("/cartpage")
	public String cartPage(HttpSession session, ModelMap model) {

		// if (session.getAttribute("sessionUser").getClass() == Customer.class)
		// 세션에서 어떤 유저인지를 검사 하려면!!!
		Customer customer = (Customer) session.getAttribute("sessionUser");

		List<Cart> cart = service.findCartByCusotmerId(customer.getCustomerId());

		model.addAttribute("cart", cart);

		return "/WEB-INF/customer/cart/cart_form.jsp";
	}

	/*-----------------------------------회원 가입------------------------------------------------*/
	@RequestMapping("/add.do")
	public String add(@ModelAttribute Customer customer, Errors errors, ModelMap model) throws DuplicatedIdException {

		CustomerValidator validate = new CustomerValidator();
		validate.validate(customer, errors);
		System.out.println(errors);
		System.out.println("총 검증 실패 개수 :" + errors.getErrorCount());

		if (errors.hasErrors()) {

			return "/WEB-INF/register/register_form_customer.jsp";
		}

		service.addCustomer(customer);
		model.addAttribute("customerId", customer.getCustomerId());
		return "redirect:/customer/registerSuccess.do";

	}
	
	@RequestMapping("findByIdJson.do")
	@ResponseBody
	public String findByIdJson(@RequestParam String customerId){
		System.out.println("JSP에서 받은 값 :" + customerId);
		System.out.println("컨트롤러에서 JSP에값을 받아 조회한 값 : " + service.findCustomerById(customerId));
		Customer customer = service.findCustomerById(customerId);
		String chk = customer.getCustomerId();
			return chk;
		}
	
	@RequestMapping("findStoreMap/do")
	@ResponseBody
	public List<Store> findStoreMap(@RequestParam String storeName, ModelMap model){
		List<Store> map = service.findStoreName(storeName);
		return map;
	}

	@RequestMapping("registerSuccess")
	public String registerSuccess(@RequestParam String customerId, ModelMap model) {

		model.addAttribute("customer", service.findCustomerById(customerId));
		return "/WEB-INF/register/register_success_customer.jsp";

	}
	

	/*----------------------물품 검색 페이지 이동 (좌측 메뉴)-----------------------------------*/
	// 카테고리-식품
	@RequestMapping("/form_food.do")
	public String formFood(@RequestParam int categoryId, ModelMap model) {
		model.addAttribute("list", service.findItemListByCategoryMain(categoryId));
		return "/WEB-INF/customer/item_list/item_list_each/item_list_food.jsp";
	}

	// 카테고리-음료
	@RequestMapping("/form_beverage.do")
	public String formBeverage(@RequestParam int categoryId, ModelMap model) {
		model.addAttribute("list", service.findItemListByCategoryMain(categoryId));
		return "/WEB-INF/customer/item_list/item_list_each/item_list_beverage.jsp";
	}

	// 카테고리-과자
	@RequestMapping("/form_snack.do")
	public String formSnack(@RequestParam int categoryId, ModelMap model) {
		model.addAttribute("list", service.findItemListByCategoryMain(categoryId));
		return "/WEB-INF/customer/item_list/item_list_each/item_list_snack.jsp";
	}

	// 카테고리-아이스크림
	@RequestMapping("/form_icecream.do")
	public String formIcecream(@RequestParam int categoryId, ModelMap model) {
		model.addAttribute("list", service.findItemListByCategoryMain(categoryId));
		return "/WEB-INF/customer/item_list/item_list_each/item_list_icecream.jsp";
	}

	// 카테고리-생활용품
	@RequestMapping("/form_daily.do")
	public String formDaily(@RequestParam int categoryId, ModelMap model) {
		model.addAttribute("list", service.findItemListByCategoryMain(categoryId));
		return "/WEB-INF/customer/item_list/item_list_each/item_list_daily.jsp";
	}

	/*----------------------매장검색 페이지 이동 (좌측 메뉴)-----------------------------------*/

	@RequestMapping("find_store_name_form.do")
	public String findStore() {
		return "/WEB-INF/customer/find_store/find_store_name.jsp";
	}

	@RequestMapping("/find_store_location_form.do")
	public String findStorelocation(ModelMap model){

		return "/WEB-INF/customer/find_store/find_store_location.jsp";
	}
	
	

	/*------------------------------------물품 다중 조회------------------------------------------*/
	@RequestMapping("/search_item")
	public String searchItem(@RequestParam String itemName, ModelMap model) {

		model.addAttribute("item", service.findItemByNameMany(itemName));
		model.addAttribute("itemName", itemName);
		return "/WEB-INF/customer/item_list/search_item.jsp";
	}

	/*---------------------------------매장검색 시 사용되는 controller---------------------------------------*/
	// 매장 이름 조회
	@RequestMapping("find_store_name.do")
	public String findStore(@RequestParam String storeName, Store store, ModelMap model) { 
		List<Store> list = service.findStoreName(storeName);

		if (list.size() < 1) {
			model.addAttribute("errorMessage", "찾으시는 매장이 없습니다.");
			return "/WEB-INF/customer/find_store/find_store_name.jsp";

		} else if (storeName.equals("")) {
			model.addAttribute("errorMessage", "찾으실 매장을 입력해주세요");
			return "/WEB-INF/customer/find_store/find_store_name.jsp";
			
		} else if (storeName.trim().length() <2 ) {
			model.addAttribute("errorMessage", "찾으실 매장의 단어를 두글자 이상입력해주세요");
			return "/WEB-INF/customer/find_store/find_store_name.jsp";
		}
		model.addAttribute("findstore", list);
		return "/WEB-INF/customer/find_store/find_store_name_success.jsp";

	}
	
	
	@RequestMapping("find_store_location.do")
	public String findStore2(@RequestParam String storeName, Store store, ModelMap model) { // 모델어트리뷰트
		System.out.println(storeName);
		Store key = service.findStoreKey(storeName);
		Store time = service.findStoreTime(storeName);
		System.out.println(time);
		
		System.out.println(key);
		model.addAttribute("map",key);
		model.addAttribute("time",time);
		
//		
		return "/WEB-INF/customer/find_store/find_store_location_success.jsp";

	}
	
	/*
	 * 1 resultMap - timeStpam, key추가 - findStoreName sql문 변경
	 * 
	 * 2. Store VO - timeStpam, key추가
	 * 
	 * 3.
	 * 
	 * 가능할까요???
	 * 
	 * 1. jsp상에서 ajax형식으로 컨트롤러에다가 요청하면 컨트롤러상에서는 
	 * 	객체형태로 원하는 매장을 찾고 찾은 객체를 리턴해준다
	 * 
	 * 2. 2. jps상에서 
	 */

	// 카테고리 페이지로 이동 (매장 이름 으로 조회 후)
	@RequestMapping("find_store_categoryPage")
	public String findStoreCategoryPage(@RequestParam int categoryId, int storeId, ModelMap model) {
		model.addAttribute("list", service.findItemListByCategoryMain(categoryId));
		model.addAttribute("storeId", storeId);

		if (categoryId == 1) {
			return "/WEB-INF/customer/item_list/item_list_each/item_list_food.jsp";
		} else if (categoryId == 2) {
			return "/WEB-INF/customer/item_list/item_list_each/item_list_beverage.jsp";
		} else if (categoryId == 3) {
			return "/WEB-INF/customer/item_list/item_list_each/item_list_snack.jsp";
		} else if (categoryId == 4) {
			return "/WEB-INF/customer/item_list/item_list_each/item_list_icecream.jsp";
		} else if (categoryId == 5) {
			return "/WEB-INF/customer/item_list/item_list_each/item_list_daily.jsp";
		} else {
			return "redirect:/customer/find_store_name.do"; // else 때문에 그냥 함
		}
	}

	/*---------------------------------물품 상세 정보 페이지---------------------------------------*/

	@RequestMapping("/item.do")
	public String itemPage(@RequestParam(value = "itemName") String itemName, @RequestParam int categoryId,
			@RequestParam(defaultValue = "0") int storeId, ModelMap model) {

		// 물품검색으로 왔을 경우, 매장이름 검색으로 왔을 경우 공통
		model.addAttribute("item", service.findItemById(itemName));

		model.addAttribute("list", service.findItemListByCategorySmallRecommand(categoryId));

		model.addAttribute("store", service.findStoreNameByCount(itemName));

		if (storeId != 0) { // 매장이름 검색으로 왔을 경우
			model.addAttribute("storeId", service.findStoreById(storeId));
		}
		return "/WEB-INF/customer/item_list/item.jsp";
	}

	/*------------------------------------장바구니------------------------------------------*/
	// 장바구니 추가
	@RequestMapping("/cart")
	public String cart(@RequestParam String storeId, @RequestParam String itemId, @RequestParam String countItem,
			HttpSession session) { // 장바구니 페이지 이동 flag필요
		Customer customer = (Customer) session.getAttribute("sessionUser");

		String customerId = customer.getCustomerId();
		int storeIdd = Integer.parseInt(storeId);
		int itemIdd = Integer.parseInt(itemId); // 내용들 숫자 변환
		int countItemm = Integer.parseInt(countItem);

		service.addCart(customerId, storeIdd, itemIdd, countItemm);

		return "redirect:/customer/cartpage.do"; // 장바구니 페이지
	}

	// 장바구니 삭제
	@RequestMapping("/deleteCart")
	public String deleteCart(@RequestParam String customerId, @RequestParam int storeId, @RequestParam int itemId) {

		service.deleteCart(customerId, storeId, itemId);

		return "redirect:/customer/cartpage.do";
	}

	/*------------------------------------주문------------------------------------------*/
	@RequestMapping("/order")
	public String order(@RequestParam String[] customerId, @RequestParam int[] storeId, @RequestParam int[] itemId,
			@RequestParam int[] orderCount, @RequestParam int[] orderStatus) {
		for (int i = 0; i < customerId.length; i++) {
			service.addOrder(customerId[i], storeId[i], itemId[i], orderCount[i], orderStatus[i]);
		}

		for (int i = 0; i < customerId.length; i++) {
			service.deleteCart(customerId[i], storeId[i], itemId[i]);
		}
		return "redirect:/basic/item_list.do";
	}

	/*------------------------------------게시판 조회------------------------------------------*/
	@RequestMapping("/boardList")
	public String boardList(@RequestParam(defaultValue = "1") String pageNo, ModelMap model) {
		int page = Integer.parseInt(pageNo);
		System.out.println("pageNo = " + page);
		List<Board> notice = service.getNotice();
		Map map = service.getAllBoard(page);

		model.addAttribute("notice", notice);
		model.addAttribute("list", map.get("list"));
		model.addAttribute("pagingBean", map.get("pagingBean"));
		return "/WEB-INF/board/board_customer.jsp";
	}

	@RequestMapping("/boardInfo")
	public String boardInfo(@RequestParam String boardIndex, ModelMap model) {
		int index = Integer.parseInt(boardIndex);
		Board board = service.getBoardInfo(index);

		System.out.println("--asdfasdf");

		model.addAttribute("board", board);
		return "/WEB-INF/board/board_info_customer.jsp";
	}

	/* 마이페이지이동 11월25일 추가 (효균) */
	@RequestMapping("/form_myPage.do")
	public String formMain() {
		return "/WEB-INF/mypage/customer/mypage_customer.jsp";
	}

}
