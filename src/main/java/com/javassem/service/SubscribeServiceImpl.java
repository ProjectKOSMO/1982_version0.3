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

	
	public int countList() {
		System.out.println("카운트 서비스");
	    return this.subscribeDAO.countList();
	}

	public List<SubscribeVO> getSubscribeList(HashMap map) {
		System.out.println("리스트 서비스");
	    return this.subscribeDAO.getSubscribeList(map);
	}
	public List<SubscribeVO> getTotalList() {
		return this.subscribeDAO.getTotalList();
	}
	public int getType5(){
		return this.subscribeDAO.getType5();
	}
	public int getType4(){
		return this.subscribeDAO.getType4();
	}
	public int getType3(){
		return this.subscribeDAO.getType3();
	}
	public int getType2(){
		return this.subscribeDAO.getType2();
	}
	public int getType1(){
		return this.subscribeDAO.getType1();
	}

}
