package com.javassem.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javassem.domain.Biz_memberVO;
import com.javassem.domain.OwnerVO;

@Repository("memberDAO")
public class MemberDAOImpl implements MemberDAO {
	
  @Autowired
  private SqlSessionTemplate mybatis;

  
  public Biz_memberVO selectMember(int ownernum) {
    System.out.println("===> Mybatis getMember()");
    return mybatis.selectOne("MemberDAO.getMember", ownernum);
  }
  
  public int updateOwnersub(int ownernum) {
	  System.out.println("===> Mybatis updateOwnersub()");
	  return mybatis.update("MemberDAO.update_sub",ownernum);
  }

  //  
//  public void updateMember(Biz_memberVO vo) {
//    System.out.println("===> Mybatis updateMember()");
//    this.mybatis.update("MemberDAO.updateMember", vo);
//  }
//  
//  public void deleteMember(Biz_memberVO vo) {
//    System.out.println("===> Mybatis deleteMember()");
//    this.mybatis.delete("MemberDAO.deleteMember", vo);
//  }
//  
//  public Biz_memberVO getMember(String biz_email) {
//    System.out.println("===> Mybatis getMember()");
//    return (Biz_memberVO)this.mybatis.selectOne("MemberDAO.getMember", biz_email);
//  }
//  
//  
//  
//  public List<Biz_memberVO> getMemberList(String biz_email) {
//    System.out.println("===> Mybatis getMemberList()");
//    return this.mybatis.selectList("MemberDAO.getMemberList", biz_email);
//  }
//  
//  public int countMember() {
//    return ((Integer)this.mybatis.selectOne("MemberDAO.countMember")).intValue();
//  }
//  
//  public List<Biz_memberVO> selectMember(PagingVO vo) {
//    List<Biz_memberVO> result = this.mybatis.selectList("MemberDAO.selectMember", vo);
//    return result;
//  }

}
