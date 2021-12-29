package com.javassem.dao;

import com.javassem.domain.OwnerBoardVO;
import com.javassem.domain.OwnerVO;
import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("ownerDAO")
public class OwnerDAOImpl implements OwnerDAO {
  @Autowired
  private SqlSessionTemplate mybatis;
  
  public OwnerVO idCheck(OwnerVO vo) {
    System.out.println("===> OwnerMapper idCheck");
    return (OwnerVO)this.mybatis.selectOne("owner.idCheck", vo);
  }
  
  public int ownerInsert(OwnerVO vo) {
    System.out.println("===>  MemberMapper ownerInsert()");
    return this.mybatis.insert("owner.ownerInsert", vo);
  }
  
  public OwnerVO ownerLogin(OwnerVO vo) {
    System.out.println("===> OwnerMapper idCheck");
    return (OwnerVO)this.mybatis.selectOne("owner.idCheck", vo);
  }
  
  public String ownerDate(OwnerVO vo) {
    return (String)this.mybatis.selectOne("sample.getDate", vo);
  }
  
  public int ownerBoardInsert(OwnerBoardVO vo) {
    System.out.println("===>  OwnerMapper ownerBoardInsert()");
    return this.mybatis.insert("owner.ownerBoardInsert", vo);
  }
  
  public List<OwnerBoardVO> getOwnerBoardList(OwnerBoardVO vo) {
    System.out.println("===> Mybatis getOwnerBoardList()");
    return this.mybatis.selectList("owner.ownerBoardList", vo);
  }
  
  public int shopInsert(OwnerVO vo) {
    System.out.println("===>  MemberMapper ownerInsert()");
    return this.mybatis.insert("owner.shopInsert", vo);
  }
  
  public int shopUpdate(OwnerVO vo) {
    System.out.println("===>  MemberMapper ownerInsert()");
    return this.mybatis.insert("owner.shopUpdate", vo);
  }
  
  public String shopSelect(OwnerVO vo) {
    System.out.println("===>  MemberMapper ownerInsert()");
    return (String)this.mybatis.selectOne("owner.shopSelect", vo);
  }
  
  public List<OwnerVO> getList(OwnerVO vo) {
    System.out.println("===> Mybatis ownerList()");
    return this.mybatis.selectList("owner.getList", vo);
  }
}
