package kr.or.kosta.pl.exception;

/**
 * 수정/삭제할 관리자를 찾지 못했을때 발생시킬 Exception
 */
public class AdminNotFoundException extends Exception{
	public AdminNotFoundException(){}
	public AdminNotFoundException(String message){
		super(message);
	}
}
