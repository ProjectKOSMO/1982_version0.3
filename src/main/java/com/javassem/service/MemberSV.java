package com.javassem.service;

import java.util.List;

import com.javassem.domain.Biz_memberVO;
import com.javassem.domain.Payed_listVO;

public interface MemberSV {
	Biz_memberVO selectBizMember(int ownernum);
	int update_sub(int ownernum); 

}
