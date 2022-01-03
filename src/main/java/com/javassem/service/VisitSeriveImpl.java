package com.javassem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javassem.dao.GraphDAO;
import com.javassem.dao.VisitDAO;

@Service("visitService")
public class VisitSeriveImpl implements VisitService{

	@Autowired
	private VisitDAO visitDAO;

	
	public int countTotalVisit(){
		return this.visitDAO.countTotalVisit();
	}
}
