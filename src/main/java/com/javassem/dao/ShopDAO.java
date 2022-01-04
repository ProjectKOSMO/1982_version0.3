package com.javassem.dao;

import java.util.HashMap;
import java.util.List;

import com.javassem.domain.ShopVO;

public interface ShopDAO {

	List<ShopVO> ShopList(ShopVO paramShopVO);
	
	List<ShopVO> getShopList(HashMap map);
	
	ShopVO getShop(ShopVO paramShopVO);

	ShopVO support(ShopVO paramShopVO);
	
	int countStore();
	

}