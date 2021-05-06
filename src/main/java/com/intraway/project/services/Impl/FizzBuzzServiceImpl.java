package com.intraway.project.services.Impl;

import com.intraway.project.constants.Constants;
import com.intraway.project.dtos.ResponseDTO;
import com.intraway.project.exceptions.BadRequestException;
import com.intraway.project.exceptions.errors.ErrorEnum;
import com.intraway.project.services.FizzBuzzService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.LinkedList;
import java.util.List;

@Service
@Slf4j
public class FizzBuzzServiceImpl implements FizzBuzzService {


	@Override
	public ResponseDTO getList(Integer min, Integer max) {
		List<String> list = new LinkedList<>();
		ResponseDTO responseDTO = new ResponseDTO();
		if (min >= max) {
			throw new BadRequestException(ErrorEnum.INCORRECT_PARAMETER);
		} else {
			for (int i = min; i <= max; i++) {
				list.add(i % 3 == 0
						? (i % 5 == 0 ? "FizzBuzz" : "Fizz")
						: (i % 5 == 0) ? "Buzz" : String.valueOf(i));
			}
		}
		buildResponse(list, responseDTO);
		return responseDTO;
	}

	private void buildResponse(List<String> list, ResponseDTO responseDTO) {
		responseDTO.setTimestamp(Timestamp.from(Instant.now()).getTime());
		responseDTO.setDescription(
				list.contains("Fizz")
						? list.contains("Buzz") ? Constants.MULTIPLE_THREE_AND_FIVE
						: list.contains("FizzBuzz") ? Constants.MULTIPLE_THREE_AND_FIVE : Constants.MULTIPLE_THREE
						: list.contains("Buzz") ? Constants.MULTIPLE_FIVE : Constants.NO_MULTIPLE);
		responseDTO.setList(list.toString());

	}

}
