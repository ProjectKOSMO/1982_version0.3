package com.javassem.dao;

import java.util.HashMap;
import java.util.List;

import com.javassem.domain.GraphVO;



public interface GraphDAO {

	List<GraphVO> getMatchList();
	List<GraphVO> getReusingList();
	int getJoinTotal();
}
