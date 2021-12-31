package com.javassem.dao;

import java.util.HashMap;
import java.util.List;

import com.javassem.domain.OwnerBoardVO;
import com.javassem.domain.OwnerVO;

public interface OwnerDAO {
  OwnerVO idCheck(OwnerVO paramOwnerVO);
  
  int ownerInsert(OwnerVO paramOwnerVO);
  
  OwnerVO ownerLogin(OwnerVO paramOwnerVO);
  
  int ownerBoardInsert(OwnerBoardVO paramOwnerBoardVO);
  
  List<OwnerBoardVO> getOwnerBoardList(OwnerBoardVO paramOwnerBoardVO);
  
  int shopInsert(OwnerVO paramOwnerVO);
  
  List<OwnerVO> getList(OwnerVO paramOwnerVO);
  
  String shopSelect(OwnerVO paramOwnerVO);
  
  List<HashMap> getUserList(String ownerId);
	
	
}
