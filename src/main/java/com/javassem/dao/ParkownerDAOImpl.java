package com.javassem.dao;

import com.javassem.domain.PagingVO;
import com.javassem.domain.ParkownerVO;
import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("ParkownerDAO")
public class ParkownerDAOImpl implements ParkownerDAO {
  @Autowired
  private SqlSessionTemplate mybatis;
  
  public int countBoard() {
    return ((Integer)this.mybatis.selectOne("depositlist.countdepositList")).intValue();
  }
  
  public List<ParkownerVO> getOwnerList(PagingVO vo) {
    System.out.println("===> Mybatis getdepositlist()");
    return this.mybatis.selectList("depositlist.getdepositlist");
  }
}
