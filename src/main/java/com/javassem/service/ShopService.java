package com.javassem.service;
import java.util.HashMap;
import java.util.List;

import com.javassem.domain.PagingVO;
import com.javassem.domain.ShopVO;

public interface ShopService {
  List<ShopVO> ShopList(ShopVO paramShopVO);
  
  List<ShopVO> ShopList1(ShopVO paramShopVO);
	// 글 목록 조회
/*	List<ShopVO> ShopList(ShopVO vo);*/

	List<ShopVO> getShopList(HashMap map);
	
	ShopVO getShop(ShopVO paramShopVO);
	
	ShopVO support(ShopVO paramShopVO);
	
	int countStore();
	
	List<ShopVO> selectStore(com.javassem.util.PagingVO vo);
}
