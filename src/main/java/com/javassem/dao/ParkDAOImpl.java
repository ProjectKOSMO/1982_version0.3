package com.javassem.dao;

import com.javassem.domain.ParkVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("parkDAO")
public class ParkDAOImpl implements ParkDAO {
  @Autowired
  private SqlSessionTemplate mybatis;
  
  public ParkVO idCheck(ParkVO vo) {
    System.out.println("===> Mybatis idCheck()");
    return (ParkVO)this.mybatis.selectOne("supervisor.idCheck", vo);
  }
}
