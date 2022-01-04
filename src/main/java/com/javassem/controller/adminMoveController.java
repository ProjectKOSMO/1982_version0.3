package com.javassem.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javassem.domain.PagingVO;
import com.javassem.domain.admin_positingVO;
import com.javassem.domain.admin_shopInfoVO;
import com.javassem.domain.admin_storeCloseVO;
import com.javassem.service.adminBoardService;

@Controller
public class adminMoveController {
	
	@Autowired
	public adminBoardService adminboardService;
	
	@RequestMapping("admin/admin_storeClose.do")
	public String toshopClose(PagingVO vo, Model m
			,@RequestParam(value="nowPage", required=false)String nowPage
			, @RequestParam(value="cntPerPage", required=false)String cntPerPage){
		
		HashMap<Object, Object> map = new HashMap<>();
		int countSupport = adminboardService.countSupport();
		
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "5";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) { 
			cntPerPage = "5";
		}
		
		vo = new PagingVO(countSupport, Integer.parseInt(nowPage), 10);
		map.put("start", vo.getStart());
		map.put("end", vo.getEnd());
		
		List<admin_storeCloseVO> list =adminboardService.supportList(map);
		m.addAttribute("supportList",list);
		m.addAttribute("paging",vo);
		
		return "admin/admin_storeClose";
	}
	
	@RequestMapping("admin/admin_positing.do")
	public String toPositing(PagingVO vo, Model m
			,@RequestParam(value="nowPage", required=false)String nowPage
			, @RequestParam(value="cntPerPage", required=false)String cntPerPage){
		
		HashMap<Object, Object> map = new HashMap<>();
		int countBoard_owner = adminboardService.countBoard_owner();
		
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "5";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) { 
			cntPerPage = "5";
		}
		
		vo = new PagingVO(countBoard_owner, Integer.parseInt(nowPage), 10);
		map.put("start", vo.getStart());
		map.put("end", vo.getEnd());
		
		List<admin_positingVO> list =adminboardService.Board_ownerList(map);
		m.addAttribute("board_ownerList",list);
		m.addAttribute("paging",vo);
		return "admin/admin_positing";
	}
	
	@RequestMapping("admin/admin_shopInfo.do")
	public String toShopInfo(PagingVO vo, Model m
			,@RequestParam(value="nowPage", required=false)String nowPage
			, @RequestParam(value="cntPerPage", required=false)String cntPerPage){
		
		HashMap<Object, Object> map = new HashMap<>();
		int countshopInfo = adminboardService.countshopInfo();
		
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "5";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) { 
			cntPerPage = "5";
		}
		
		vo = new PagingVO(countshopInfo, Integer.parseInt(nowPage), 10);
		map.put("start", vo.getStart());
		map.put("end", vo.getEnd());
		
		List<admin_shopInfoVO> list =adminboardService.shopInfoList(map);
		m.addAttribute("shopInfoList",list);
		m.addAttribute("paging",vo);
		
		return "admin/admin_shopInfo";
	}

}
