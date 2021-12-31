package com.javassem.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javassem.domain.SubscribeVO;

@Repository("SubscribeDAO")
public class SubscribeDAOImpl implements SubscribeDAO{
	
	@Autowired
	private SqlSessionTemplate mybatis;

	@Override
	public int countList() {
	    return this.mybatis.selectOne("subscribePage.countSubscribeList");
	}

	@Override
	public List<SubscribeVO> getSubscribeList(HashMap map) {
	    return this.mybatis.selectList("subscribePage.getSubscribeList", map);
	}
	public List<SubscribeVO> getTotalList() {
	    return this.mybatis.selectList("subscribePage.TotalList");
	}
	public int getType5(){
		return this.mybatis.selectOne("subscribePage.type5");
	}
	public int getType4(){
		return this.mybatis.selectOne("subscribePage.type4");
	}

	public int getType3(){
		return this.mybatis.selectOne("subscribePage.type3");
	}

	public int getType2(){
		return this.mybatis.selectOne("subscribePage.type2");
	}

	public int getType1(){
		return this.mybatis.selectOne("subscribePage.type1");
	}
}
