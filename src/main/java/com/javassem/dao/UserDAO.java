package com.javassem.dao;


import java.util.HashMap;
import java.util.List;

import com.javassem.domain.ShopVO;
import com.javassem.domain.UserVO;

public interface UserDAO {
	
  UserVO idCheck(UserVO paramUserVO);
  
  int userInsert(UserVO paramUserVO);
  
  UserVO userLogin(UserVO paramUserVO);
  

  void insertUserInfoView(UserVO paramUserVO);
  
  void updateUserInfoView(UserVO paramUserVO);
  
  void deleteUserInfoView(UserVO paramUserVO);
  
  UserVO getUserInfoView(UserVO paramUserVO);
  
  List<HashMap> getShopList(HashMap paramHashMap);
}



