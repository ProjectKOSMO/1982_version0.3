package com.javassem.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javassem.domain.SongLocationVO;

@Repository
public class SongLocationDAOImpl implements SongLocationDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;

	@Override
	public List<SongLocationVO> getLocationList(SongLocationVO vo) {
		
		return mybatis.selectList("Location.getLocationList",vo);
	}

	@Override
	public void insertLocation(SongLocationVO vo) {
		
		mybatis.insert("Location.insertLocation",vo);
		
	}

	@Override
	public int getLocationListCount(SongLocationVO vo) {
		System.out.println("DAO 호출");
		return mybatis.selectOne("Location.getLocationListCount",vo);
	}

}
