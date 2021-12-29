package com.javassem.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javassem.dao.SubscribeDAO;
import com.javassem.domain.SubscribeVO;

@Service("SubscribeService")
public class SubscribeServiceImpl implements SubscribeService{
	
	@Autowired
	  private SubscribeDAO subscribeDAO;

	@Override
	public int countList() {
		System.out.println("카운트 서비스");
	    return this.subscribeDAO.countList();
	}

	@Override
	public List<SubscribeVO> getSubscribeList(HashMap map) {
		System.out.println("리스트 서비스");
	    return this.subscribeDAO.getSubscribeList(map);
	}

}
