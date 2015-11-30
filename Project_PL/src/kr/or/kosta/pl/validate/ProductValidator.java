package kr.or.kosta.pl.validate;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import kr.or.kosta.pl.vo.Product;

public class ProductValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return clazz.isAssignableFrom(Product.class);
	}

	@Override
	//등록/수정 공통 체크.
	public void validate(Object target, Errors errors) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "itemId", "requried2", new Object[]{"물품 ID"}, "필수입력사항입니다.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "itemName", "requried2", new Object[]{"물품 이름"}, "필수입력사항입니다.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "itemPrice", "requried2", new Object[]{"물품 가격"}, "필수입력사항입니다.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "categoryId", "requried2", new Object[]{"물품 카테고리"}, "필수입력사항입니다.");
		
	}
}
