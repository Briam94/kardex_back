package com.kardex.services;

import com.kardex.dto.GenericAnswerDto;

public interface UserService {
	
	public GenericAnswerDto createUser(String user);
	public GenericAnswerDto findUser(String user);
	public GenericAnswerDto login(String user);

}
