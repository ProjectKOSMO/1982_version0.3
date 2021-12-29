package com.javassem.controller;

import com.javassem.domain.PagingVO;
import com.javassem.domain.ParkBlackVO;
import com.javassem.domain.ParkVO;
import com.javassem.service.ParkBlackService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ParkBlackController {
	
    @Autowired
    public ParkBlackService parkBlackService;
    @Autowired
	private SqlSessionTemplate mybatis;
    
    @RequestMapping("adminMain.do")
    public String main(Model m,Model m2,PagingVO vo1
			,@RequestParam(value="nowPage", required=false)String nowPage
			, @RequestParam(value="cntPerPage", required=false)String cntPerPage){
    	HashMap<Object, Object> map = new HashMap<>();
		int total_black = parkBlackService.countBlacklist();
		
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "5";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) { 
			cntPerPage = "5";
		}
		
		vo1 = new PagingVO(total_black, Integer.parseInt(nowPage), 5);
		
		map.put("start", vo1.getStart());
		map.put("end", vo1.getEnd());
		
		List<ParkBlackVO> list = parkBlackService.getBlackList(map);
		m.addAttribute("blacklist",list);
		m.addAttribute("paging", vo1);
		
		//그래프관련
		int matching = mybatis.selectOne("hold.matching");
		int whole = mybatis.selectOne("hold.wholeApply");
		int matchingPercent = mybatis.selectOne("hold.matching_percent");
		
		int reusing = mybatis.selectOne("hold.reusing");
		int whole2 = mybatis.selectOne("hold.wholeUse");
		int reusePercent = mybatis.selectOne("hold.reusePercent");
		
		int joinToday = mybatis.selectOne("hold.joinToday");
		int joinYesterday1 = mybatis.selectOne("hold.joinYesterday1");
		int joinYesterday2 = mybatis.selectOne("hold.joinYesterday2");
		int joinYesterday3 = mybatis.selectOne("hold.joinYesterday3");
		int joinYesterday4 = mybatis.selectOne("hold.joinYesterday4");
		
		int cumulToday = mybatis.selectOne("hold.cumulateToday");
		int cumulYesterday1 = mybatis.selectOne("hold.cumulateYesterday1");
		int cumulYesterday2 = mybatis.selectOne("hold.cumulateYesterday2");
		int cumulYesterday3 = mybatis.selectOne("hold.cumulateYesterday3");
		int cumulYesterday4 = mybatis.selectOne("hold.cumulateYesterday4");
		
		
		m.addAttribute("matching", matching);
		m.addAttribute("wholeApply", whole);
		m.addAttribute("matchingPercent", matchingPercent);
		
		m.addAttribute("reusing", reusing);
		m.addAttribute("wholeUse", whole2);
		m.addAttribute("reusePercent", reusePercent);
		
		m.addAttribute("joinToday", joinToday);
		m.addAttribute("joinYesterday1", joinYesterday1);
		m.addAttribute("joinYesterday2", joinYesterday2);
		m.addAttribute("joinYesterday3", joinYesterday3);
		m.addAttribute("joinYesterday4", joinYesterday4);
		
		m.addAttribute("cumulToday", cumulToday);
		m.addAttribute("cumulYesterday1", cumulYesterday1);
		m.addAttribute("cumulYesterday2", cumulYesterday2);
		m.addAttribute("cumulYesterday3", cumulYesterday3);
		m.addAttribute("cumulYesterday4", cumulYesterday4);
		return "admin/adminPage";
    }

    @RequestMapping("checkCnt.do")
    public String checkCnt(ParkBlackVO vo, @RequestParam("userID") String userID,
    		@RequestParam("warnCnt") int warnCnt,
    		@RequestParam("userName") String userName,
    		@RequestParam("userPN") String userPN,
    		@RequestParam("reason") String reason,
    		Model m, HttpServletResponse response,RedirectAttributes redirect) throws Exception{
    	vo.setReason(reason);
    	vo.setUserID(userID);
    	vo.setUserName(userName);
    	vo.setUserPN(userPN);
    	vo.setWarnCnt(warnCnt);
    	
    	int cnt=parkBlackService.checkCnt(vo);
    	redirect.addAttribute("reason",vo.getReason());
    	redirect.addAttribute("userID",vo.getUserID());
    	redirect.addAttribute("userName",vo.getUserName());
    	redirect.addAttribute("userPN",vo.getUserPN());
    	redirect.addAttribute("warnCnt",vo.getWarnCnt());
    	
    	if(cnt==3){
            return "redirect:adminMain.do";
    	}else {
    		return "redirect:stopAccount.do";
    	}
    	
    }
    
    @RequestMapping("stopAccount.do")
    public String stopAccount(ParkBlackVO vo, @RequestParam("warnCnt") int warnCnt,
    		@RequestParam("userID") String userID,
    		@RequestParam("userName") String userName,
    		@RequestParam("userPN") String userPN,
    		@RequestParam("reason") String reason){
   
    	vo.setReason(reason);
    	vo.setUserID(userID);
    	vo.setUserName(userName);
    	vo.setUserPN(userPN);
    	vo.setWarnCnt(warnCnt);
    	
    	HashMap<Object, Object> map = new HashMap<>();
    	map.put("userID",vo.getUserID());
    	map.put("userPN",vo.getUserPN());
    	map.put("userName",vo.getUserName());
    	map.put("warnCnt",vo.getWarnCnt());
    	map.put("reason",vo.getReason());
    	
    	parkBlackService.stopAccount(map);
    	return "redirect:adminMain.do";
    }
}
