package com.javassem.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javassem.domain.PagingVO;
import com.javassem.domain.ParkBlackVO;
import com.javassem.domain.SubscribeVO;
import com.javassem.service.ParkBlackService;
import com.javassem.service.SubscribeService;


@Controller
public class SubscribeController {
	
	@Autowired
	public SubscribeService subscribeService;

	@RequestMapping("admin/adminPage2.do")
	public String moveSubscribe(SubscribeVO vo, Model m, PagingVO vo1
			,@RequestParam(value="nowPage", required=false)String nowPage
			, @RequestParam(value="cntPerPage", required=false)String cntPerPage){
		
		HashMap<Object, Object> map = new HashMap<>();
		int total_subscribe = subscribeService.countList();
		System.out.println(total_subscribe);
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "5";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) { 
			cntPerPage = "5";
		}
		
		vo1 = new PagingVO(total_subscribe, Integer.parseInt(nowPage), 5);
		
		map.put("start", vo1.getStart());
		map.put("end", vo1.getEnd());
		
		List<SubscribeVO> list = subscribeService.getSubscribeList(map);
		m.addAttribute("subscribelist",list);
		m.addAttribute("paging", vo1);
		
	
		int Type5 = subscribeService.getType5();
		int Type4 = subscribeService.getType4();
		int Type3 = subscribeService.getType3();
		int Type2 = subscribeService.getType2();
		int Type1 = subscribeService.getType1();

		m.addAttribute("Type5", Type5);
		m.addAttribute("Type4", Type4);
		m.addAttribute("Type3", Type3);
		m.addAttribute("Type2", Type2);
		m.addAttribute("Type1", Type1);
		
		return "admin/adminPage2";
	}
}