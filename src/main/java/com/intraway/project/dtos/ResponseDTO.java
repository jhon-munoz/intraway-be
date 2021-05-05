package com.intraway.project.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseDTO {
	private String timestamp;
	private String code;
	private String description;
	private String list;
}
