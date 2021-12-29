package com.javassem.service;


import com.javassem.domain.UserVO;

public interface UserService {
  UserVO idCheck_Login(UserVO paramUserVO);
  
  int userInsert(UserVO paramUserVO);
  
  String userDate(UserVO paramUserVO);
  
  void insertUserInfoView(UserVO paramUserVO);
  
  void updateUserInfoView(UserVO paramUserVO);
  
  void deleteUserInfoView(UserVO paramUserVO);
  
  UserVO getUserInfoView(UserVO paramUserVO);
}
