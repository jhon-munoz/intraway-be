package com.intraway.project.services.Impl;

import com.intraway.project.dtos.ResponseDTO;
import com.intraway.project.exceptions.BadRequestException;
import com.intraway.project.exceptions.errors.ErrorEnum;
import com.intraway.project.services.FizzBuzzService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FizzBuzzServiceImpl implements FizzBuzzService {


	@Override
	public ResponseDTO getList(Integer min, Integer max) {
		if(min>=max){
			throw new BadRequestException(ErrorEnum.INCORRECT_PARAMETER);
		}
		return new ResponseDTO();
	}

}
