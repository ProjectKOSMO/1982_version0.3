package com.javassem.controller;

import com.javassem.domain.GraphVO;
import com.javassem.domain.PagingVO;
import com.javassem.domain.ParkBlackVO;
import com.javassem.domain.ParkVO;
import com.javassem.service.GraphService;
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
    public GraphService graphService;
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
		
		//매칭률
		List<GraphVO> matching= graphService.getMatchList();
		m.addAttribute("matching", matching.get(0).getMatching());
		m.addAttribute("wholeApply", matching.get(0).getWhole_apply());
		m.addAttribute("matching_success", matching.get(0).getMatching_success());
		
		//재이용률
		List<GraphVO> reusing= graphService.getReusingList();
		m.addAttribute("reusing", reusing.get(0).getReusing());
		m.addAttribute("whole_use", reusing.get(0).getWhole_use());
		m.addAttribute("reusing_ratio", reusing.get(0).getReusing_ratio());
		
		//회원가입자 수
		
		List<GraphVO> experiment = mybatis.selectList("hold.joinDate");
		
		int total = graphService.getJoinTotal();
		int joinToday= experiment.get(0).getToday();
		int joinYesterday1 =experiment.get(0).getBefore1();
		int joinYesterday2 =experiment.get(0).getBefore2();
		int joinYesterday3 =experiment.get(0).getBefore3();
		int joinYesterday4 =experiment.get(0).getBefore4();
		
		m.addAttribute("joinToday",experiment.get(0).getToday());
		m.addAttribute("joinYesterday1",experiment.get(0).getBefore1());
		m.addAttribute("joinYesterday2",experiment.get(0).getBefore2());
		m.addAttribute("joinYesterday3",experiment.get(0).getBefore3());
		m.addAttribute("joinYesterday4",experiment.get(0).getBefore4());
		
		// 누적 가입자 수
		
		m.addAttribute("cumulToday", total);
		m.addAttribute("cumulYesterday1", total-joinToday);
		m.addAttribute("cumulYesterday2", total-joinToday-joinYesterday1);
		m.addAttribute("cumulYesterday3", total-joinToday-joinYesterday1-joinYesterday2);
		m.addAttribute("cumulYesterday4", total-joinToday-joinYesterday1-joinYesterday2-joinYesterday3);
		
		return "admin/adminPage";
    }

    @RequestMapping("checkCnt.do")
    public String checkCnt(ParkBlackVO vo, @RequestParam("userId") String userId,
    		@RequestParam("warnCnt") int warnCnt,
    		@RequestParam("userName") String userName,
    		@RequestParam("warnDate") String warnDate,
    		@RequestParam("reason") String reason,
    		Model m, HttpServletResponse response,RedirectAttributes redirect) throws Exception{
    	vo.setReason(reason);
    	vo.setUserId(userId);
    	vo.setUserName(userName);
    	vo.setWarnDate(warnDate);
    	vo.setWarnCnt(warnCnt);
    	
    	int cnt=parkBlackService.checkCnt(vo);
    	redirect.addAttribute("reason",vo.getReason());
    	redirect.addAttribute("userId",vo.getUserId());
    	redirect.addAttribute("userName",vo.getUserName());
    	redirect.addAttribute("warnDate",vo.getWarnDate());
    	redirect.addAttribute("warnCnt",vo.getWarnCnt());
    	
    	if(cnt==3){
            return "redirect:adminMain.do";
    	}else {
    		return "redirect:stopAccount.do";
    	}
    	
    }
    
    @RequestMapping("stopAccount.do")
    public String stopAccount(ParkBlackVO vo, @RequestParam("warnCnt") int warnCnt,
    		@RequestParam("userId") String userId,
    		@RequestParam("userName") String userName,
    		@RequestParam("warnDate") String warnDate,
    		@RequestParam("reason") String reason){
   
    	vo.setReason(reason);
    	vo.setUserId(userId);
    	vo.setUserName(userName);
    	vo.setWarnDate(warnDate);
    	vo.setWarnCnt(warnCnt);
    	
    	HashMap<Object, Object> map = new HashMap<>();
    	map.put("userId",vo.getUserId());
    	map.put("warnDate",vo.getWarnDate());
    	map.put("userName",vo.getUserName());
    	map.put("warnCnt",vo.getWarnCnt());
    	map.put("reason",vo.getReason());
    	
    	parkBlackService.stopAccount(map);
    	return "redirect:adminMain.do";
    }
}
