package com.intraway.project.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Constants {
	public static final String BAD_REQUEST = "Bad Request";
	public static final String INTERNAL_ERROR = "Internal Server Error";
	public static final String MULTIPLE_THREE = "Se encontraron múltiplos de 3";
	public static final String MULTIPLE_FIVE = "Se encontraron múltiplos de 5";
	public static final String MULTIPLE_THREE_AND_FIVE = "Se encontraron múltiplos de 3 y de 5";
	public static final String NO_MULTIPLE = "No se encontraron múltiplos de 3 ni de 5";
}
