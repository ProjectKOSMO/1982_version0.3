package com.javassem.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import com.javassem.domain.BoardVO;
import com.javassem.domain.UserVO;
import com.javassem.service.UserService;


@Controller
public class UserController {
	
    @Autowired // 의존성 주입
    public UserService userService;
    
    @RequestMapping({"/user/userMypage.do"})
    public void getuser(UserVO vo, Model m) {
      UserVO result = this.userService.getUserInfoView(vo);
      m.addAttribute("user", result);
    }
    
    @RequestMapping({"/user/updateMypage.do"})
    public String updateBoard(UserVO vo) {
      this.userService.updateUserInfoView(vo);
      return "redirect:userMypage.do";
    }
}
