package com.javassem.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javassem.dao.GraphDAO;
import com.javassem.domain.GraphVO;

@Service("graphService")
public class GraphServiceImpl implements GraphService {
	
	@Autowired
	private GraphDAO graphDAO;


	public List<GraphVO> getMatchList() {
		return this.graphDAO.getMatchList();
	}
	public List<GraphVO> getReusingList() {
		return this.graphDAO.getReusingList();
	}
	public int getJoinTotal(){
		return this.graphDAO.getJoinTotal();
	}
}
