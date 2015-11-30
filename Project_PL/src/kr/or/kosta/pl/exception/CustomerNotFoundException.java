package kr.or.kosta.pl.exception;

/**
 * 수정/삭제할 고객을 찾지 못했을때 발생시킬 Exception
 */
public class CustomerNotFoundException extends Exception{
	public CustomerNotFoundException(){}
	public CustomerNotFoundException(String message){
		super(message);
	}
}
