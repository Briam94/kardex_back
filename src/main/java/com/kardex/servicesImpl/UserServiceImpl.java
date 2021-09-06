package com.kardex.servicesImpl;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kardex.dao.UsersDao;
import com.kardex.dto.GenericAnswerDto;
import com.kardex.entities.Users;
import com.kardex.services.UserService;
import com.kardex.utils.Constans;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UsersDao userDao;

	@Override
	public GenericAnswerDto createUser(String user) {
		Users users;
		GenericAnswerDto genericAnswer = new GenericAnswerDto();
		try {
			JSONObject obj = new JSONObject(user);
			users = new Users( null,
					obj.getJSONObject("data").getString("userName"),
					obj.getJSONObject("data").getString("userEmail"),
					obj.getJSONObject("data").getString("password"));
			genericAnswer = findUser(users.getUserEmail());
			if(genericAnswer.getCode().equals("0")) {
				genericAnswer = new GenericAnswerDto();
				userDao.update(users);
				genericAnswer.setCode("1");
				genericAnswer.setMessage(Constans.USER_CREATED_SUCCESFULL);				
			}else {
				genericAnswer = new GenericAnswerDto();
				genericAnswer.setCode("0");
				genericAnswer.setMessage(Constans.USER_EXIST_ALREADY);
			}
		} catch (JSONException e) {
			genericAnswer.setCode("0");
			genericAnswer.setMessage(Constans.ERROR_GENERAL);
		}
		return genericAnswer;
	}

	@Override
	public GenericAnswerDto findUser(String userEmail) {
		Users userFound = new Users();
		GenericAnswerDto genericAnswer = new GenericAnswerDto();
		try {
			userFound = userDao.findByEmail(userEmail);
			if(userFound != null) {
				genericAnswer.setCode("1");
				genericAnswer.setMessage(Constans.USER_FOUND_SUCCESFULL);
				genericAnswer.setDescription(userFound);				
			}else {
				genericAnswer.setCode("0");
				genericAnswer.setMessage(Constans.USER_NOT_FOUND);
			}
		} catch (Exception e) {
			genericAnswer.setCode("0");
			genericAnswer.setMessage(Constans.ERROR_GENERAL);
			e.printStackTrace();
		}
		return genericAnswer;
	}
	
	
	public GenericAnswerDto login(String user) {
		Users userFound = new Users();
		GenericAnswerDto genericAnswer = new GenericAnswerDto();
		try {
			JSONObject obj = new JSONObject(user);
			String userEmail = obj.getJSONObject("data").getString("userEmail");
			String password = obj.getJSONObject("data").getString("password");
			userFound = userDao.findByEmail(userEmail);
			if(userFound.getUserPassword().equals(password)) {
				genericAnswer.setCode("1");
				genericAnswer.setMessage(Constans.LOGIN_VALID);
				genericAnswer.setDescription(userFound);	
			}else {
				genericAnswer.setCode("0");
				genericAnswer.setMessage(Constans.LOGIN_INVALID);
			}
		} catch (Exception e) {
			genericAnswer.setCode("0");
			genericAnswer.setMessage(Constans.LOGIN_INVALID);
			e.printStackTrace();
		}
		return genericAnswer;
	}
	

}
