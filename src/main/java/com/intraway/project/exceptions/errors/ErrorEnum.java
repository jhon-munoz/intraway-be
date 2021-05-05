package com.intraway.project.exceptions.errors;

public enum ErrorEnum {

	INCORRECT_PARAMETER("Los parámetros enviados son incorrectos");

	private String message;
	
	private ErrorEnum(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}

}
