package com.javassem.dao;

import com.javassem.domain.Payed_listVO;
import com.javassem.util.PagingVO;

import java.util.List;

interface PayDAO {
	int insertPay(Payed_listVO vo);
	  
	  void updatePay(Payed_listVO vo);
	  void deletePay(Payed_listVO vo);
	  
	  Payed_listVO getPay(Payed_listVO vo);
	  
	  List<Payed_listVO> getPayList(String biz_email);
	  
	  int countPay();
	  
	  List<Payed_listVO> selectPay(PagingVO vo);
  
}
