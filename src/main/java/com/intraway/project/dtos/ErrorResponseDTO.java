package com.intraway.project.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.Instant;

@Data
@NoArgsConstructor
public class ErrorResponseDTO {
	private Long timestamp;
	private Integer status;
	private String error;
	private String exception;
	private String message;
	private String path;

	public static ErrorResponseDTO build(Integer status, String error,String exception, String message, String path) {
		ErrorResponseDTO dto = new ErrorResponseDTO();
		dto.setTimestamp(Timestamp.from(Instant.now()).getTime());
		dto.setStatus(status);
		dto.setError(error);
		dto.setException(exception);
		dto.setMessage(message);
		dto.setPath(path);
		return dto;
	}

}
