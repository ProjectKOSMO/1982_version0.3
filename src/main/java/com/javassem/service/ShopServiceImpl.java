package com.javassem.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javassem.dao.ShopDAOImpl;
import com.javassem.domain.ShopVO;

@Service("shopService")
public class ShopServiceImpl implements ShopService {

  @Autowired
  private ShopDAOImpl shopDAO;
  
  public List<ShopVO> ShopList(ShopVO vo) {
    return this.shopDAO.ShopList(vo);
  }		
		/*public List<ShopVO> ShopList(ShopVO vo) {
			return shopDAO.ShopList(vo);
		}*/
		
		public List<ShopVO> getShopList(HashMap map) {
			return shopDAO.getShopList(map);
		}
		
		public int countShop(){
			return shopDAO.countShop();
		}
		
		public ShopVO getShop(ShopVO vo){
			return this.shopDAO.getShop(vo);
		}
		
		public ShopVO support(ShopVO vo){
			return this.shopDAO.support(vo);
		
		}
}
