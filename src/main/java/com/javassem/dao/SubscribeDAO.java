package com.javassem.dao;

import java.util.HashMap;
import java.util.List;

import com.javassem.domain.SubscribeVO;



public interface SubscribeDAO {
	int countList();
	List<SubscribeVO> getSubscribeList(HashMap map);

}
