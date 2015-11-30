package kr.or.kosta.pl.validate;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import kr.or.kosta.pl.vo.Category;


public class CategoryValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return clazz.isAssignableFrom(Category.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "categoryId", "required", new Object[]{" ID"}, "필수입력사항입니다.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "categoryName", "requried", new Object[]{"이름"}, "필수입력사항입니다.");
		
	}

}
