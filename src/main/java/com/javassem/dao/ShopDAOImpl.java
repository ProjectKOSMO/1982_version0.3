package com.javassem.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javassem.domain.ShopVO;


	@Repository("shopDAO")
	public class ShopDAOImpl implements ShopDAO {
		
		@Autowired
		private SqlSessionTemplate mybatis;
		
		public List<ShopVO> ShopList(ShopVO vo) {
			System.out.println("===> Mybatis ShopList() 호출");
			return mybatis.selectList("ShopDAO.ShopList", vo);

		}
		
		public List<ShopVO> ShopList1(ShopVO vo) {
			System.out.println("===> Mybatis ShopList() 호출");
			return mybatis.selectList("ShopDAO.ShopList1", vo);

		}
		
		
		public List<ShopVO> getShopList(HashMap map) {
			System.out.println("===> Mybatis getBoardList() 호출");
			return mybatis.selectList("ShopDAO.getShopList", map);
		}
		
		public int countShop(){
			return ((Integer)this.mybatis.selectOne("ShopDAO.countShop")).intValue();
		  
		}
		
		public ShopVO getShop(ShopVO vo){
			System.out.println("===> Mybatis getShop()");
			return (ShopVO)this.mybatis.selectOne("ShopDAO.getShop", vo);
		}
		
		public ShopVO support(ShopVO vo){
		System.out.println("===> Mybatis support()");
		return (ShopVO)this.mybatis.selectList("ShopDAO.support", vo);
		}
}
