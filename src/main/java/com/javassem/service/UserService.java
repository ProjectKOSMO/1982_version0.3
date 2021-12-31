package com.javassem.service;


import java.util.HashMap;
import java.util.List;

import com.javassem.domain.ShopVO;
import com.javassem.domain.UserVO;

public interface UserService {
	
  // 구직자 회원가입 로그인 서비스
  UserVO idCheck_Login(UserVO paramUserVO);
  
  int userInsert(UserVO paramUserVO);
  
  // 구직자 마이페이지 서비스
  void insertUserInfoView(UserVO paramUserVO);
  
  void updateUserInfoView(UserVO paramUserVO);
  
  void deleteUserInfoView(UserVO paramUserVO);
  
  UserVO getUserInfoView(UserVO paramUserVO);
  
  List<HashMap> getShopList(HashMap paramHashMap);
}
