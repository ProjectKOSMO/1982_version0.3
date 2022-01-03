package com.javassem.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("visitDAO")
public class VisitDAOImpl implements VisitDAO{
	
	@Autowired
	  private SqlSessionTemplate mybatis;
	

	public int countTotalVisit(){
		return this.mybatis.selectOne("visit.countTotal");
	}
	

}
