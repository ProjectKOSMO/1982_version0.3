package com.javassem.dao;


import java.util.HashMap;
import java.util.List;

import com.javassem.domain.BoardVO;
import com.javassem.domain.ShopInfoVO;
import com.javassem.domain.SupportVO;
import com.javassem.domain.UserVO;

public interface UserDAO {
	
  UserVO idCheck(UserVO paramUserVO);
  
  int userInsert(UserVO paramUserVO);
  
  UserVO userLogin(UserVO paramUserVO);
  

  void insertUserInfoView(UserVO paramUserVO);
  
  void updateUserInfoView(UserVO paramUserVO);
  
  void updateInfoView(UserVO paramUserVO);
  
  void deleteUserInfoView(UserVO paramUserVO);
  
  UserVO getUserInfoView(UserVO paramUserVO);
  
  List<SupportVO> getSupportView(SupportVO paramSupportVO);
  
  ShopInfoVO getShopView(ShopInfoVO paramShopInfoVO);
}



