package com.kardex.dto;

public class GenericAnswerDto {
	
	// 0 error; 1 OK
	private String code;
	private String message;
	private Object description;
	
	public GenericAnswerDto() {
		super();
	}
	public GenericAnswerDto(String code, String message, Object description) {
		super();
		this.code = code;
		this.message = message;
		this.description = description;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getDescription() {
		return description;
	}
	public void setDescription(Object description) {
		this.description = description;
	}
}
