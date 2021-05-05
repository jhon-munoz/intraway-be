package com.intraway.project.services;

import com.intraway.project.dtos.ResponseDTO;

public interface FizzBuzzService {

	ResponseDTO getList(Integer min, Integer max);
}
