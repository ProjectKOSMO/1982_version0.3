package com.javassem.service;

import java.util.HashMap;
import java.util.List;

import com.javassem.domain.admin_positingVO;
import com.javassem.domain.admin_shopInfoVO;
import com.javassem.domain.admin_storeCloseVO;

public interface adminBoardService {
	
	int countSupport();
	List<admin_storeCloseVO> supportList(HashMap map);
	int countBoard_owner();
	List<admin_positingVO> Board_ownerList(HashMap map);
	int countshopInfo();
	List<admin_shopInfoVO> shopInfoList(HashMap map);
}
