package com.javassem.dao;


import com.javassem.domain.ShopInfoVO;
import com.javassem.domain.SupportVO;
import com.javassem.domain.UserVO;

public interface UserDAO {
	
  UserVO idCheck(UserVO paramUserVO);
  
  int userInsert(UserVO paramUserVO);
  
  UserVO userLogin(UserVO paramUserVO);
  

  void insertUserInfoView(UserVO paramUserVO);
  
  void updateUserInfoView(UserVO paramUserVO);
  
  void deleteUserInfoView(UserVO paramUserVO);
  
  UserVO getUserInfoView(UserVO paramUserVO);
  
  SupportVO getSupportView(SupportVO paramSupportVO);
  
  ShopInfoVO getShopView(ShopInfoVO paramShopInfoVO);
}



