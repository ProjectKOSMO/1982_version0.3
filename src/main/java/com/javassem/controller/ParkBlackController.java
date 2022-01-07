package com.javassem.controller;

import com.javassem.domain.GraphVO;
import com.javassem.domain.PagingVO;
import com.javassem.domain.ParkBlackVO;
import com.javassem.domain.ParkVO;
import com.javassem.domain.VisitorVO;
import com.javassem.service.GraphService;
import com.javassem.service.ParkBlackService;
import com.javassem.service.VisitService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
    public GraphService graphService;
    @Autowired
	private SqlSessionTemplate mybatis;
	@Autowired
	public VisitService visitService;
	
	
    @RequestMapping("checkCnt.do")
    public String checkCnt(ParkBlackVO vo, @RequestParam("userId") String userId,HttpServletRequest request,
    		@RequestParam("warnCnt") int warnCnt,
    		@RequestParam("userName") String userName,
    		@RequestParam("warnDate") String warnDate,
    		@RequestParam("reason") String reason,
    		@RequestParam("userNum") String userNum,
    		@RequestParam("ownerNum") String ownerNum,
    		Model m, HttpServletResponse response,RedirectAttributes redirect) throws Exception{
    	vo.setReason(reason);
    	vo.setUserId(userId);
    	vo.setUserName(userName);
    	vo.setWarnDate(warnDate);
    	vo.setWarnCnt(warnCnt);
    	vo.setUserNum(userNum);
    	vo.setOwnerNum(ownerNum);
    	
    	int cnt=parkBlackService.checkCnt(vo);
    	redirect.addAttribute("reason",vo.getReason());
    	redirect.addAttribute("userId",vo.getUserId());
    	redirect.addAttribute("userName",vo.getUserName());
    	redirect.addAttribute("warnDate",vo.getWarnDate());
    	redirect.addAttribute("warnCnt",vo.getWarnCnt());
    	redirect.addAttribute("userNum",vo.getUserNum());
    	redirect.addAttribute("ownerNum",vo.getOwnerNum());
    	
    	if(cnt==3){
    		response.setContentType("text/html; charset=UTF-8"); 
    		PrintWriter writer = response.getWriter();
    		writer.println("<script>alert('이미 경고횟수가 3입니다.');"); 
    		writer.println("location.href='admin/adminPage.do';"); 
    		writer.println("</script>"); 
    		writer.close();
            return "redirect:admin/adminPage.do";
    	}else {
    		return "redirect:stopAccount.do";
    	}
    	
    }
    
    @RequestMapping("stopAccount.do")
    public String stopAccount(ParkBlackVO vo, @RequestParam("warnCnt") int warnCnt,
    		@RequestParam("userId") String userId,
    		@RequestParam("userName") String userName,
    		@RequestParam("warnDate") String warnDate,
    		@RequestParam("reason") String reason,
    		@RequestParam("userNum") String userNum,
    		@RequestParam("ownerNum") String ownerNum){
   
    	vo.setReason(reason);
    	vo.setUserId(userId);
    	vo.setUserName(userName);
    	vo.setWarnDate(warnDate);
    	vo.setWarnCnt(warnCnt);
    	vo.setUserNum(userNum);
    	vo.setOwnerNum(ownerNum);
    	
    	HashMap<Object, Object> map = new HashMap<>();
    	
    	map.put("userId", userId);
    	map.put("userName", userName);
    	map.put("warnDate", warnDate);
    	map.put("warnCnt", warnCnt);
    	map.put("reason", reason);
    	map.put("userNum", userNum);
    	map.put("ownerNum", ownerNum);
    	
    	
    	parkBlackService.stopAccount(map);
    	return "redirect:admin/adminPage.do";
    }
}
