package kr.or.kosta.pl.validate;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import kr.or.kosta.pl.vo.Owner;



public class OwnerValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
	
		return clazz.isAssignableFrom(Owner.class);
	}

	@Override
	//등록/수정 공통 체크.
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ownerId", "required", new Object[]{"점장 ID"}, "필수입력사항입니다.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ownerPassword", "requried", new Object[]{"패스워드"}, "필수입력사항입니다.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ownerName", "requried", new Object[]{"점장 이름"}, "필수입력사항입니다.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ownerPhone", "requried", new Object[]{"휴대폰 번호"}, "필수입력사항입니다.");
	}
	
	

}