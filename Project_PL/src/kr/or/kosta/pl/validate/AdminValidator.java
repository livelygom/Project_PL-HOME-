package kr.or.kosta.pl.validate;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import kr.or.kosta.pl.vo.Admin;




public class AdminValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return clazz.isAssignableFrom(Admin.class);
	}

	@Override
	//등록/수정 공통 체크.
	public void validate(Object target, Errors errors) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "adminId", "required", new Object[]{"관리자 ID"}, "필수입력사항입니다.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "adminPassword", "requried", new Object[]{"패스워드"}, "필수입력사항입니다.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "adminName", "requried", new Object[]{"관리자 이름"}, "필수입력사항입니다.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "adminPhone", "requried", new Object[]{"핸드폰번호"}, "필수입력사항입니다.");
	}

}
