package com.javassem.controller;

import java.util.Random;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.javassem.domain.OwnerVO;
import com.javassem.domain.UserVO;
import com.javassem.service.OwnerService;
import com.javassem.service.UserService;

@RestController
public class songEmailController {
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private UserService userservice;
	
	@Autowired
	private OwnerService ownerservice;

	@RequestMapping(value="/mailCheck", method=RequestMethod.GET)
	@ResponseBody
	public String mailCheckGET(String email) throws Exception{
		System.out.println(email);
		
		Random random = new Random();
		int checkNum = random.nextInt(888888)+111111;
		System.out.println(checkNum);
		
		/* 이메일 보내기 */
        String setFrom = "kosmopunch@gmail.com";
        String toMail = email;
        String title = "회원가입 인증 이메일 입니다.";
        String content = 
                "홈페이지를 방문해주셔서 감사합니다." +
                "<br><br>" + 
                "인증 번호는 " + checkNum + "입니다." + 
                "<br>" + 
                "해당 인증번호를 인증번호 확인란에 기입하여 주세요.";
        
        	try {
            
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
            helper.setFrom(setFrom);
            helper.setTo(toMail);
            helper.setSubject(title);
            helper.setText(content,true);
            mailSender.send(message);
            
        }catch(Exception e) {
            e.printStackTrace();
        }
        	
        String num = Integer.toString(checkNum);
        return num;
	}
	
	@RequestMapping(value="/passwordSearch", method=RequestMethod.POST)
	@ResponseBody
	public String passwordsearch(@RequestParam("userId") String userId,@RequestParam("userMail") String userMail,UserVO vo) throws Exception{
		vo.setUserid(userId);
		vo.setUsermail(userMail);
		
		System.out.println("vo 값 확인");
		System.out.println(vo.getUsermail());
		
		UserVO result=userservice.idCheck_Login(vo);
		
		
		if(result!=null){
		Random random = new Random();
		int checkNum = random.nextInt(888888)+111111;
		System.out.println(checkNum);
		
		//이메일 보내기 
        String setFrom = "kosmopunch@gmail.com";
        String toMail = userMail;
        String title = "비밀번호 찾기를 위한 인증 이메일 입니다.";
        String content = 
                "비밀번호 찾기를 위한 인증번호를 송신하였습니다." +
                "<br><br>" + 
                "인증 번호는 " + checkNum + "입니다." + 
                "<br>" + 
                "해당 인증번호를 인증번호 확인란에 기입하여 주세요.";
        
        	try {
            
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
            helper.setFrom(setFrom);
            helper.setTo(toMail);
            helper.setSubject(title);
            helper.setText(content,true);
            mailSender.send(message);
            
        }catch(Exception e) {
            e.printStackTrace();
        }
        	
        String num = Integer.toString(checkNum);
        return num;
        }else{
		return "a";
		}
	}
	@RequestMapping(value="/passwordSend", method=RequestMethod.POST,produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String passwordsend(@RequestParam("userId") String userId,@RequestParam("userMail") String userMail,UserVO vo) throws Exception{
		vo.setUserid(userId);
		vo.setUsermail(userMail);
		
		System.out.println("vo 값 확인");
		System.out.println(vo.getUsermail());
		
		UserVO result=userservice.idCheck_Login(vo);
		
		
		if(result!=null){
		
		//이메일 보내기 
        String setFrom = "kosmopunch@gmail.com";
        String toMail = userMail;
        String title = "사용하시는 계정의 비밀번호 이메일 입니다.";
        String content = 
                "사용하시는 계정의 비밀번호를 송신하였습니다." +
                "<br><br>" + 
                "비밀번호는 " + result.getUserpass() + "입니다." + 
                "<br>" + 
                "저희 홈페이지를 이용해주셔서 감사합니다.";
        
        	try {
            
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
            helper.setFrom(setFrom);
            helper.setTo(toMail);
            helper.setSubject(title);
            helper.setText(content,true);
            mailSender.send(message);
            
        }catch(Exception e) {
            e.printStackTrace();
        }
        	
        
        return "비밀번호를 전송하였습니다.";
        }else{
		return "아이디나 이메일이 바뀌었습니다. 다시 확인해 주세요";
		}
	}
	@RequestMapping(value="/OwnpasswordSearch", method=RequestMethod.POST)
	@ResponseBody
	public String Ownpasswordsearch(@RequestParam("userId") String userId,@RequestParam("userMail") String userMail,OwnerVO vo) throws Exception{
		vo.setOwnerid(userId);
		vo.setOwnermail(userMail);
		
		System.out.println("vo 값 확인");
		System.out.println(vo.getOwnermail());
		
		OwnerVO result=ownerservice.idCheck_Login(vo);
		
		
		if(result!=null){
		Random random = new Random();
		int checkNum = random.nextInt(888888)+111111;
		System.out.println(checkNum);
		
		//이메일 보내기 
        String setFrom = "kosmopunch@gmail.com";
        String toMail = userMail;
        String title = "비밀번호 찾기를 위한 인증 이메일 입니다.";
        String content = 
                "비밀번호 찾기를 위한 인증번호를 송신하였습니다." +
                "<br><br>" + 
                "인증 번호는 " + checkNum + "입니다." + 
                "<br>" + 
                "해당 인증번호를 인증번호 확인란에 기입하여 주세요.";
        
        	try {
            
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
            helper.setFrom(setFrom);
            helper.setTo(toMail);
            helper.setSubject(title);
            helper.setText(content,true);
            mailSender.send(message);
            
        }catch(Exception e) {
            e.printStackTrace();
        }
        	
        String num = Integer.toString(checkNum);
        return num;
        }else{
		return "a";
		}
	}
	@RequestMapping(value="/OwnpasswordSend", method=RequestMethod.POST,produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String ownpasswordsend(@RequestParam("userId") String userId,@RequestParam("userMail") String userMail,OwnerVO vo) throws Exception{
		vo.setOwnerid(userId);
		vo.setOwnermail(userMail);
		
		System.out.println("vo 값 확인");
		System.out.println(vo.getOwnermail());
		
		OwnerVO result=ownerservice.idCheck_Login(vo);
		
		
		if(result!=null){
		
		//이메일 보내기 
        String setFrom = "kosmopunch@gmail.com";
        String toMail = userMail;
        String title = "사용하시는 계정의 비밀번호 이메일 입니다.";
        String content = 
                "사용하시는 계정의 비밀번호를 송신하였습니다." +
                "<br><br>" + 
                "비밀번호는 " + result.getOwnerpass() + "입니다." + 
                "<br>" + 
                "저희 홈페이지를 이용해주셔서 감사합니다.";
        
        	try {
            
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
            helper.setFrom(setFrom);
            helper.setTo(toMail);
            helper.setSubject(title);
            helper.setText(content,true);
            mailSender.send(message);
            
        }catch(Exception e) {
            e.printStackTrace();
        }
        	
        
        return "비밀번호를 전송하였습니다.";
        }else{
		return "아이디나 이메일이 바뀌었습니다. 다시 확인해 주세요";
		}
	}
}
