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
	
	public int update_sub(int ownernum) {
		System.out.println("MemberDAO ownersub update 실행");
		return memberDAO.updateOwnersub(ownernum);	
	}

}
