package com.javassem.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javassem.dao.UserDAOImpl;
import com.javassem.domain.ShopVO;
import com.javassem.domain.UserVO;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAOImpl userDAO;
	
	// 구직자 로그인 회원가입 서비스단
	public UserVO idCheck_Login(UserVO vo) {
	  return this.userDAO.idCheck(vo);
	}
	  
	public int userInsert(UserVO vo) {
	  return this.userDAO.userInsert(vo);
	}
	  
	// 구직자 마이페이지 서비스단
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

	public List<HashMap> getShopList(HashMap map) {
		return this.userDAO.getShopList(map);
	}
}
