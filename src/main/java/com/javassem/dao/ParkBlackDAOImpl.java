package com.javassem.dao;

import com.javassem.domain.PagingVO;
import com.javassem.domain.ParkBlackVO;

import java.util.HashMap;
import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("ParkBlackDAO")
public class ParkBlackDAOImpl implements ParkBlackDAO {
	
  @Autowired
  private SqlSessionTemplate mybatis1;
  
  public int countBlacklist() {
    return this.mybatis1.selectOne("blacklistBoard.countBlackList");
  }
  
  public List<ParkBlackVO> getBlackList(HashMap map) {
    System.out.println("===> Mybatis getBlackList()");
    return this.mybatis1.selectList("blacklistBoard.getBlackList", map);
  }

	@Override
	public int checkCnt(ParkBlackVO vo) {
		System.out.println("===> Mybatis checkCnt()");
		return this.mybatis1.selectOne("blacklistBoard.checkCnt",vo);
	}
	public void stopAccount(HashMap map){
		System.out.println("===> Mybatis stopaccount()");
		this.mybatis1.insert("blacklistBoard.stopaccount",map);
	}
	  
}
