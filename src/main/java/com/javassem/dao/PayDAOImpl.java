package com.javassem.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javassem.domain.Biz_memberVO;
import com.javassem.domain.Payed_listVO;
import com.javassem.util.PagingVO;

@Repository("payDAO")
public class PayDAOImpl implements PayDAO {
	
  @Autowired
  private SqlSessionTemplate mybatis;
  
  public int insertPay(Payed_listVO vo) {
    System.out.println("===> Mybatis insertPay()");
    int result = mybatis.insert("PayDAO.insertPay", vo);
    System.out.println(result);
    
    return result;
  }
  
	  
  
  public int updatePay(Biz_memberVO vo) {
    System.out.println("===> Mybatis updateBiz_pay");
    return this.mybatis.update("PayDAO.updateBiz_pay", vo);
  }
  
  public void deletePay(Payed_listVO vo) {
    System.out.println("===> Mybatis deletePay()");
    this.mybatis.delete("PayDAO.deletePay", vo);
  }
  
  public Payed_listVO getPay(Payed_listVO vo) {
    System.out.println("===> Mybatis getPay()");
    return (Payed_listVO)this.mybatis.selectOne("PayDAO.getPay", vo);
  }
  
  public List<Payed_listVO> getPayList(String biz_email) {
    System.out.println("===> Mybatis getPayList()");
    return mybatis.selectList("PayDAO.getPayList", biz_email);
  }
  
  public int countPay() {
    return ((Integer)this.mybatis.selectOne("PayDAO.countPay")).intValue();
  }
  
  public List<Payed_listVO> selectPay(PagingVO vo) {
    List<Payed_listVO> result = this.mybatis.selectList("PayDAO.selectPay", vo);
    return result;
  }

@Override
public void updatePay(Payed_listVO vo) {
	// TODO Auto-generated method stub
	
}


}
