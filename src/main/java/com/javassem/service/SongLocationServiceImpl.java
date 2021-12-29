package com.javassem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javassem.dao.SongLocationDAO;
import com.javassem.domain.SongLocationVO;

@Service
public class SongLocationServiceImpl implements SongLocationService {
	
	@Autowired
	SongLocationDAO songLocationDAO;

	@Override
	public List<SongLocationVO> getLocationList(SongLocationVO vo) {
		
		return songLocationDAO.getLocationList(vo);
	}

	@Override
	public int getLocationListCount(SongLocationVO vo) {
		System.out.println("service 호출");
		return songLocationDAO.getLocationListCount(vo);
	}

}
