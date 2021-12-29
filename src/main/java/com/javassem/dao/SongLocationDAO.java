package com.javassem.dao;

import java.util.List;

import com.javassem.domain.SongLocationVO;

public interface SongLocationDAO {
	public List<SongLocationVO>  getLocationList(SongLocationVO vo);
	public void insertLocation(SongLocationVO vo);
	public int getLocationListCount(SongLocationVO vo);
}
