package kr.or.kosta.pl.validate;

import org.springframework.validation.*;

import kr.or.kosta.pl.vo.Customer;

public class CustomerValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {

		return clazz.isAssignableFrom(Customer.class);
	}

	@Override
	public void validate(Object target, Errors error) {

		if (!supports(target.getClass())) {
			error.reject("notsupport", "검증할수 없는 객체입니다.");
			return;
		}

		Customer customer = (Customer) target;
		

		if (customer.getCustomerId().equals("")) {
			error.rejectValue("customerId", "required",new Object[]{"아이디는"}, "validationCustomerIdDefault");
		} 
		else if (customer.getCustomerId().trim().length() < 6) {
			error.rejectValue("customerId", "required1",new Object[]{"비밀번호는"}, "ID 는 6자 이상 입력해 주세요.");
		}
		else if (customer.getCustomerPassword().equals("")|| customer.getCustomerPassword().trim().isEmpty()) {
			error.rejectValue("customerPassword", "required",new Object[]{"비밀번호는"}, "비밀번호를 입력해 주세요.");
		}
		else if (customer.getCustomerName().equals("")) {
			error.rejectValue("customerName", "required",new Object[]{"이름은"}, "예쁜 이름을 적어주세요.");
		}
		else if (customer.getCustomerAddress().equals("")) {
			error.rejectValue("customerAddress", "required", new Object[]{"주소는"}, "주소를 적어주세요.");
		}
			
		else if(customer.getCustomerBirth().equals("") ){		//date가 아닌 숫자 상태. 8자리를 맞추기 위함
			error.rejectValue("customerBirth", "required", new Object[]{"생일"}, "생일 형식을 정확히 입렵해 주세요.");
		}
		else if(customer.getCustomerGender() == 3){
			error.rejectValue("customerGender", "nosex", new Object[]{"성별은"}, "성별을 체크해주세요.");
		}
		else if(!(customer.getCustomerPhone().length() == 11)){
			error.rejectValue("customerPhone", "required",new Object[]{"핸드폰번호는"}, "핸드폰 번호를 형식에 맞게 입력하세요");
		}
		else if(customer.getCustomerEmail().equals("")){
			error.rejectValue("customerEmail", "required",new Object[]{"이메일은"}, "이메일을 입력하세요");
		}	
		
//		ValidationUtils.rejectIfEmpty(error, "name", "required",new Object[]{"이름"},"이름을은 필수입력사항입니다.");
//		ValidationUtils.rejectIfEmpty(error, "email", "required",new Object[]{"이메일"},"이메일을 넣으세요.");
	}
}
