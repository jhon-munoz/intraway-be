package com.intraway.project.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
public class ResponseDTO {
	private Long timestamp;
	private String code;
	private String description;
	private String list;
}
