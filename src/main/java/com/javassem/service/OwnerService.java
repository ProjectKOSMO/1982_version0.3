package com.javassem.service;

import com.javassem.domain.OwnerBoardVO;
import com.javassem.domain.OwnerVO;
import java.util.List;

public interface OwnerService {
  OwnerVO idCheck_Login(OwnerVO paramOwnerVO);
  
  int ownerInsert(OwnerVO paramOwnerVO);
  
  String ownerDate(OwnerVO paramOwnerVO);
  
  int ownerBoardInsert(OwnerBoardVO paramOwnerBoardVO);
  
  List<OwnerBoardVO> getOwnerBoardList(OwnerBoardVO paramOwnerBoardVO);
  
  int insertShopInfo(OwnerVO paramOwnerVO);
  
  int updateShopInfo(OwnerVO paramOwnerVO);
  
  String selectShopInfo(OwnerVO paramOwnerVO);
  
  List<OwnerVO> getList(OwnerVO paramOwnerVO);
}
