package com.javassem.controller;


import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javassem.domain.ShopVO;
import com.javassem.domain.UserVO;
import com.javassem.service.UserService;


@Controller
public class UserController {
	
    @Autowired // 의존성 주입
    public UserService userService;
    
    @RequestMapping({"/user/userMypage.do"})
    public void getuser(UserVO vo, Model m, HttpServletRequest request) {
      HttpSession session = request.getSession();
      
      UserVO result = this.userService.getUserInfoView(vo);
	  HashMap<String,String> map = new HashMap();
	  map.put("userid", (String)session.getAttribute("userId"));
	  List<HashMap> list = userService.getShopList(map);
	  m.addAttribute("support", list);
      m.addAttribute("user", result);
    }
    
    @RequestMapping({"/user/updateMypage.do"})
    public String updateBoard(UserVO vo) {
      this.userService.updateUserInfoView(vo);
      return "redirect:userMypage.do";
    }
}
