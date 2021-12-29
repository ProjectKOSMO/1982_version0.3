package com.javassem.service;

import com.javassem.dao.UserDAOImpl;
import com.javassem.domain.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAOImpl userDAO;
	  
	public UserVO idCheck_Login(UserVO vo) {
	  return this.userDAO.idCheck(vo);
	}
	  
	public int userInsert(UserVO vo) {
	  return this.userDAO.userInsert(vo);
	}
	  
	public String userDate(UserVO vo) {
	  return this.userDAO.userDate(vo);
	}

	public void insertUserInfoView(UserVO vo) {
		this.userDAO.insertUserInfoView(vo);
	}
	
	
	public void updateUserInfoView(UserVO vo) {
		this.userDAO.updateUserInfoView(vo);
	}
	

	public void deleteUserInfoView(UserVO vo) {
		this.userDAO.deleteUserInfoView(vo);
	}
	

	public UserVO getUserInfoView(UserVO vo){
		return this.userDAO.getUserInfoView(vo);
	}

}
