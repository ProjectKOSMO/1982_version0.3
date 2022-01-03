package com.javassem.controller;


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
    public void getuser(UserVO vo, SupportVO vo1, Model m) {
      UserVO result = this.userService.getUserInfoView(vo);
      SupportVO support = this.userService.getSupportView(vo1);
      m.addAttribute("user", result);
      m.addAttribute("support", support);
    }
    
    @PostMapping(value = {"/user/shopInfoView.do"}, produces="application/json")
    @ResponseBody
    public ShopInfoVO getshop(@RequestBody ShopInfoVO vo){
    	ShopInfoVO shop = this.userService.getShopView(vo);
      return shop;
    }
    
    @RequestMapping({"/user/userInfoView.do"})
    public void getuserinfoview(UserVO vo, Model m){
    	UserVO user = this.userService.getUserInfoView(vo);
    	m.addAttribute("infoview", user);
    }
    
//    @RequestMapping({"/user/updateMypage.do"})
//    public String updateBoard(UserVO vo) {
//      this.userService.updateUserInfoView(vo);
//      return "redirect:userMain.do";
//    }
}
