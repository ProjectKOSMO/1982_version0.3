package com.javassem.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javassem.dao.adminBoardDAO;
import com.javassem.domain.admin_positingVO;
import com.javassem.domain.admin_shopInfoVO;
import com.javassem.domain.admin_storeCloseVO;

@Service("adminstoreCloseService")
public class adminBoardServiceImpl implements adminBoardService{
	
	@Autowired
	private adminBoardDAO adminboardDAO;

	public int countSupport() {
		return this.adminboardDAO.countSupport();
	}
	public List<admin_storeCloseVO> supportList(HashMap map) {
		return this.adminboardDAO.supportList(map);
	}
	public int countBoard_owner() {
		return this.adminboardDAO.countBoard_owner();
	}
	public List<admin_positingVO> Board_ownerList(HashMap map) {
		return this.adminboardDAO.Board_ownerList(map);
	}
	public int countshopInfo() {
		return this.adminboardDAO.countshopInfo();
	}
	public List<admin_shopInfoVO> shopInfoList(HashMap map) {
		return this.adminboardDAO.shopInfoList(map);
	}

}
