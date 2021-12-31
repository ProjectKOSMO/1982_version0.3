package com.javassem.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javassem.domain.GraphVO;

@Repository("graphDAO")
public class GraphDAOImpl implements GraphDAO{
	
	@Autowired
	  private SqlSessionTemplate mybatis;

	
	public List<GraphVO> getMatchList() {
		return this.mybatis.selectList("hold.matching_percent");
	}
	public List<GraphVO> getReusingList() {
		return this.mybatis.selectList("hold.reusePercent");
	}
	public int getJoinTotal(){
		return this.mybatis.selectOne("hold.joinTotal");
	}

}
