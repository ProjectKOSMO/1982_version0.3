package com.javassem.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javassem.domain.admin_positingVO;
import com.javassem.domain.admin_shopInfoVO;
import com.javassem.domain.admin_storeCloseVO;

@Repository("adminstoreCloseDAO")
public class adminBoardDAOImpl implements adminBoardDAO{

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public int countSupport() {
		return this.mybatis.selectOne("adminboard.countsupport");
	}
	public List<admin_storeCloseVO> supportList(HashMap map) {
		return this.mybatis.selectList("adminboard.supportList",map);
	}
	public int countBoard_owner(){
		return this.mybatis.selectOne("adminboard.countboard_owner");
	}
	public List<admin_positingVO> Board_ownerList(HashMap map){
		return this.mybatis.selectList("adminboard.board_ownerList",map);
	}
	public int countshopInfo() {
		return this.mybatis.selectOne("adminboard.countshopInfo");
	}
	public List<admin_shopInfoVO> shopInfoList(HashMap map) {
		return this.mybatis.selectList("adminboard.shopInfoList",map);
	}
	
	

}