package com.javassem.controller;


import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javassem.domain.ShopInfoVO;
import com.javassem.domain.SupportVO;
import com.javassem.domain.UserVO;
import com.javassem.service.UserService;


@Controller
public class UserController {
	
    @Autowired // 의존성 주입
    public UserService userService;
    
    @RequestMapping({"/user/userMypage.do"})
    public void getuser(UserVO vo, String searchCondition, String searchKeyword, Model m) {
      UserVO result = this.userService.getUserInfoView(vo);
      
      HashMap map = new HashMap();
      map.put("searchCondition", searchCondition);
      map.put("searchKeyword", searchKeyword);
      map.put("userid", vo.getUserid());
      
      
      List<SupportVO> support = this.userService.getSupportView(map);
      System.out.println(support.indexOf(support));
      m.addAttribute("user", result);
      m.addAttribute("support", support);
    }
    
    @PostMapping(value = {"/user/shopInfoView.do"}, produces="application/json")
    @ResponseBody
    public ShopInfoVO getshop(@RequestBody ShopInfoVO vo){
    	System.out.println("구직자 마이페이지 ajax 실행");
    	System.out.println(vo.getShopName());
    	ShopInfoVO shop = this.userService.getShopView(vo);
      return shop;
    }
    
    @RequestMapping({"/user/userInfoView.do"})
    public void getuserinfoview(UserVO vo, Model m){
    	UserVO user = this.userService.getUserInfoView(vo);
    	m.addAttribute("infoview", user);
    }
    
    @RequestMapping({"/user/updateInfoView.do"})
    public void updateinfoview(UserVO vo){
    	System.out.println(vo.getUserbirth());
    	this.userService.updateInfoView(vo);
    }
    
    @RequestMapping({"/user/updateMypage.do"})
    public String updateBoard(UserVO vo) {
      this.userService.updateUserInfoView(vo);
      return "redirect:userMain.do";
    }
}
