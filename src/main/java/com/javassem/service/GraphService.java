package com.javassem.service;

import java.util.HashMap;
import java.util.List;

import com.javassem.domain.GraphVO;


public interface GraphService {

	List<GraphVO> getMatchList();
	List<GraphVO> getReusingList();
	int getJoinTotal();
}
