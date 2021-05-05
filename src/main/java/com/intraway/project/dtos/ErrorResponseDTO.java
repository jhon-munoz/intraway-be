package com.intraway.project.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ErrorResponseDTO<T> {
	private String timestamp;
	private Integer status;
	private String error;
	private String exception;
	private String message;
	private String path;

	public static ErrorResponseDTO build(Integer status, String error, String message) {
		ErrorResponseDTO dto = new ErrorResponseDTO();
		dto.setStatus(status);
		dto.setError(error);
		dto.setMessage(message);
		return dto;
	}

}
