package com.intraway.project.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseDTO {
	private Long timestamp;
	private Long code;
	private String description;
	private String list;
}
