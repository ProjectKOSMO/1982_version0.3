package com.javassem.controller;


import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javassem.domain.ShopVO;
import com.javassem.service.OwnerService;
import com.javassem.service.ShopService;
import com.javassem.util.PagingVO;


@Controller
public class ShopController {

	
	@Autowired
	private ShopService shopService;
	
	@Autowired
	private OwnerService ownerService;
	  
	@Autowired
	  private SqlSessionTemplate mybatis;	
	
	// 일자리 찾기 업체 가져오기.
	@RequestMapping(value={"/user/storeClose.do"}, method=RequestMethod.GET)
	public String select(PagingVO vo, Model m, String searchCondition, 
			String searchKeyword,
			@RequestParam(value = "nowPage", required = false) String nowPage, 
			@RequestParam(value = "cntPerPage", required = false) String cntPerPage) {
	   
		HashMap<Object, Object> map = new HashMap<>();
	    int total = this.shopService.countStore();
	    if (nowPage == null && cntPerPage == null){
	    	 nowPage = "1";
	      cntPerPage = "5";
	    } else if (nowPage == null) {
	      nowPage = "1";
	    } else if (cntPerPage == null) {
	      cntPerPage = "5";
	    }
	    
	    vo = new PagingVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
	    System.out.println(vo.getStart());
	    System.out.println(vo.getEnd());
		map.put("searchCondition", searchCondition);
		map.put("searchKeyword", searchKeyword);
		map.put("start", vo.getStart());
		map.put("end", vo.getEnd());
		
		
		
		List<ShopVO> list = this.shopService.getShopList(map);
		m.addAttribute("paging", vo);
		m.addAttribute("ShopList", list);
		return "user/storeClose" ;
	}
	

	@RequestMapping(value = {"/user/userSupport.do"}, method=RequestMethod.GET)
	public void getShop(@RequestParam int board_owner_seq, ShopVO vo, Model m){
		
		vo.setBoard_owner_seq(board_owner_seq);
		
		
		ShopVO result = shopService.getShop(vo);
		
		
		m.addAttribute("shop", result);
	
		
	}
	
	@RequestMapping(value = {"/user/support.do"}, method=RequestMethod.POST)
	public String getShop3(
			
			@RequestParam int board_owner_seq,
			@RequestParam String shopname,
			@RequestParam String normal_emergency,
			@RequestParam String shopaddr,
			@RequestParam String shoppay,
			@RequestParam String jobDate,
			@RequestParam String startTime,
			@RequestParam String endTime,
			@RequestParam String userid,
			
			ShopVO vo, Model m) {
			
			vo.setBoard_owner_seq(board_owner_seq);
			vo.setShopname(shopname);
			vo.setNormal_emergency(normal_emergency);
			vo.setShopaddr(shopaddr);
			vo.setShoppay(shoppay);
			vo.setJobDate(jobDate);
			vo.setJobTime_start(startTime);
			vo.setJobTime_end(endTime);
			vo.setUserid(userid);
			
			
				return "redirect:storeClose.do";
			
		

	}



	// 일자리 찾기 버튼 클릭시 동작하는 코드
    @RequestMapping({"/user/storeClose.do"})
    public void select(ShopVO vo, Model m) {
    	
        List<ShopVO> list = shopService.ShopList(vo);
        m.addAttribute("ShopList", list);
     
        
    }
}
