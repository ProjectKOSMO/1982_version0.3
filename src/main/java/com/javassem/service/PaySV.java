package com.javassem.service;


import com.javassem.domain.Biz_memberVO;
import com.javassem.domain.Payed_listVO;

public interface PaySV {
	int insert_pay(Payed_listVO pvo);
	int updateBiz_pay(Biz_memberVO bvo);

}
