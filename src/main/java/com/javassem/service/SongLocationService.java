package com.javassem.service;

import java.util.List;

import com.javassem.domain.SongLocationVO;

public interface SongLocationService {
	List<SongLocationVO> getLocationList(SongLocationVO vo);
	int getLocationListCount(SongLocationVO vo);
}
