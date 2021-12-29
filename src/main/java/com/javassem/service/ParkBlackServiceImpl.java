package com.javassem.service;

import com.javassem.dao.ParkBlackDAO;
import com.javassem.domain.PagingVO;
import com.javassem.domain.ParkBlackVO;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ParkBlackService")
public class ParkBlackServiceImpl implements ParkBlackService {
  @Autowired
  private ParkBlackDAO parkBlackDAO;
  
  public int countBlacklist() {
    return this.parkBlackDAO.countBlacklist();
  }
  
  public List<ParkBlackVO> getBlackList(HashMap map) {
    return this.parkBlackDAO.getBlackList(map);
  }

  public int checkCnt(ParkBlackVO vo) {
	return this.parkBlackDAO.checkCnt(vo);
	}

	public void stopAccount(HashMap map) {
		this.parkBlackDAO.stopAccount(map);
	}
}
