package com.javassem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javassem.dao.PayDAOImpl;
import com.javassem.domain.Biz_memberVO;
import com.javassem.domain.Payed_listVO;

@Service("paySV")
public class PaySVImpl implements PaySV{
	  @Autowired
	  private PayDAOImpl payDAO;
	  
	@Override
	public int insert_pay(Payed_listVO pvo) {
		
		System.out.println("PayDAO 실행");
	    return payDAO.insertPay(pvo);	
	}

	@Override
	public int updateBiz_pay(Biz_memberVO bvo) {

		return payDAO.updatePay(bvo);
	};

}
