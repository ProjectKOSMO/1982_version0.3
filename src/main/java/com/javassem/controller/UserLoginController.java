package com.javassem.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javassem.domain.UserVO;
import com.javassem.service.UserService;

/*
 * 작성일자 : 2021. 12. 25.
 * 최신화 일자 : 2021. 12. 25.
 * 작성자 : 이혁철, 고성훈, 송현석
 * 내용 : 구직자 로그인, 회원가입 컨트롤러
 * 변경 사항 있으면 아래에 자세히 작성 바랍니다..
 * ex) idcheck 보안사항 추가, 맵핑 추가 등등
 * 
 * 
 */

@Controller
@RequestMapping({"user"})
public class UserLoginController {
	
    @Autowired
    public UserService userService;

    public UserLoginController() {
    }

    @RequestMapping({"{step.do}"})
    public String userJoin(@PathVariable String step) {
        return "/user/" + step;
    }

    @RequestMapping({"userInsert.do"})
    public String userinsert(UserVO vo) {
        this.userService.userInsert(vo);
        return "redirect:user_login.do";
    }

    @RequestMapping({"login.do"})
    public String userLogin(UserVO vo, Model m, HttpServletRequest request) throws Exception  {
        UserVO result = this.userService.idCheck_Login(vo);
        if(result==null){
        	return "redirect:user_login.do";
        }else{
        	HttpSession session = request.getSession();
        	session.setAttribute("userNum", result.getUsernum());
        	session.setAttribute("userId", result.getUserid());
        	session.setAttribute("userPass", result.getUserpass());
/*        	session.setAttribute("userImg", result.getUserimg());
        	session.setAttribute("userSelf", result.getUserself());*/
        	System.out.println(result.getUserid());
        	return "user/userMain";
        }
    }

    @RequestMapping(
        value = {"idCheck.do"},
        produces = {"application/text; charset=UTF-8"}
    )
    @ResponseBody
    public String idCheck(UserVO vo) {
        UserVO result = this.userService.idCheck_Login(vo);
        String message = "사용가능한 아이디 입니다.";
        if (result != null) {
            message = "이미 사용중인 아이디 입니다.";
        }

        return message;
    }
}
