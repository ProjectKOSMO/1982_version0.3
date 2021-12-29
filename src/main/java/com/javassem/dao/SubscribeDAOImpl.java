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
		System.out.println("다오 카운트");
	    return this.mybatis.selectOne("subscribePage.countSubscribeList");
	}

	@Override
	public List<SubscribeVO> getSubscribeList(HashMap map) {
		System.out.println("다오 리스트");
	    System.out.println("===> Mybatis getBlackList()");
	    return this.mybatis.selectList("subscribePage.getSubscribeList", map);
	}

}
