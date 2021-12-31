package com.javassem.dao;

import java.util.HashMap;
import java.util.List;

import com.javassem.domain.ParkBlackVO;

public interface ParkBlackDAO {

  int countBlacklist();
  List<ParkBlackVO> getBlackList(HashMap map);
  int checkCnt(ParkBlackVO vo);
  void stopAccount(HashMap map);

}
