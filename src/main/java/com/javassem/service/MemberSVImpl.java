package com.javassem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javassem.dao.MemberDAOImpl;
import com.javassem.domain.Biz_memberVO;
import com.javassem.domain.OwnerVO;

@Service("memberSV")
public class MemberSVImpl implements MemberSV{

	  @Autowired
	  private MemberDAOImpl memberDAO;
	  
	  
	@Override
	public Biz_memberVO selectBizMember(int ownernum) {
		
		System.out.println("MemberDAO 실행");
	    return memberDAO.selectMember(ownernum);	
	};
	
	@Override
	public int update_sub(int ownernum) {
		System.out.println("MemberDAO ownersub update 실행");
		return memberDAO.updateOwnersub(ownernum);	
	}
	
	@Override
	public String select_pay_date_end(int ownernum) {
		System.out.println("MemberDAO select_pay_date_end 실행");
		return memberDAO.payDateEnd(ownernum);
	}
	
	public int update_coupon_terminated(int ownernum) {
		System.out.println("MemberDAO updateCouponTerminated 실행");
		return memberDAO.updateCouponTerminated(ownernum);	
	}

}
