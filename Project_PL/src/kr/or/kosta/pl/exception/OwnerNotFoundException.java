package kr.or.kosta.pl.exception;

public class OwnerNotFoundException extends Exception {
	public OwnerNotFoundException(){}
	
	public OwnerNotFoundException(String message){
		super(message);
	}
}
