//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//
package com.javassem.controller;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javassem.domain.OwnerBoardVO;
import com.javassem.domain.OwnerVO;
import com.javassem.domain.ShopVO;
import com.javassem.service.MemberSV;
import com.javassem.service.OwnerService;
import com.javassem.service.ShopService;
import com.javassem.service.UserService;
@Controller
@RequestMapping({"owner"})
public class OwnerLoginController {
	
    @Autowired
    public OwnerService ownerService;
    
    @Autowired
    public ShopService shopService;
    
    @Autowired
    public UserService userService;
    
    public OwnerLoginController() {
    }
    
    
    
    @RequestMapping({"{step}.do"})
    public String ownerJoin(@PathVariable String step) {
        return "/owner/" + step;
    }
    
    
    //사업자 회원가입후 첫 로그인시 DB에 데이터가없으면 Mypage로 이동 / 데이터가있으면 ViewPage로 이동하는 컨트롤러
    @RequestMapping({"ownerMypage.do"})
    public String ownerMypage(OwnerVO vo, Model model, HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();
        Integer ownernum = (Integer)session.getAttribute("ownernum");
        vo.setOwnernum(ownernum);
        List<OwnerVO> list = this.ownerService.getList(vo);
        model.addAttribute("shopList", list);
        
      
        if( list.isEmpty() || list == null ){ 
       
        	return "/owner/ownerMypage"; 
        			
        }else{	
        	return "redirect:ownerList.do"; 
        }
    }
    
    //ownerMypage에서 처음 업체정보를 DB 저장하는 컨트롤러
    @RequestMapping({"shopInsert.do"})
    public String shopInsert(OwnerVO vo, Model model) {
        this.ownerService.insertShopInfo(vo);
        List<OwnerVO> list = this.ownerService.getList(vo);
        model.addAttribute("shopList", list);
        return "redirect:ownerList.do";
    }
    
    
    
    //ownerViewPage에서 사업자가 정보 수정하는페이지로 넘어갈때 DB데이터를 가져오는 컨트롤러
    @RequestMapping({"ownerUpdate.do"})
    public String ownerUpdatePage(OwnerVO vo, Model model, HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();
        Integer ownernum = (Integer)session.getAttribute("ownernum");
        vo.setOwnernum(ownernum);
        List<OwnerVO> list = this.ownerService.getList(vo);
        model.addAttribute("shopInfo", list);
        return "/owner/ownerUpdate";
    }
    
    // ownerUpdatePage에서 "수정" 버튼클릭시 기존 내용을 업데이트하는 컨트롤러
    @RequestMapping({"shopUpdate.do"})
    public String shopUpdate(OwnerVO vo, Model model, HttpServletRequest request) throws Exception {
        this.ownerService.updateShopInfo(vo);
        this.ownerService.getList(vo);
        Thread.sleep(5000L);
        return "redirect:ownerList.do";
    }
    
    //사업자 마이페이지에 DB에저장된 데이터를 가지고 보여주기만하는 컨트롤러
    @RequestMapping({"ownerList.do"})
    public String getList(OwnerVO vo,OwnerBoardVO vo1,ShopVO vo2, Model model, HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();
        Integer ownernum = (Integer)session.getAttribute("ownernum");
        String ownerId = (String)session.getAttribute("ownerid");
        
        vo.setOwnernum(ownernum);
        vo1.setOwnernum(ownernum);
        
        List<OwnerVO> list = this.ownerService.getList(vo);
        
        
        List<OwnerBoardVO> list2 = this.ownerService.getOwnerBoardList(vo1);
        System.out.println(list2);
        
        if (list2.isEmpty()){
        	
        	model.addAttribute("shopList", list);
        	
        	return "/owner/ownerViewPage";
        	
        }else {
        	OwnerBoardVO board_seq = list2.get(0);

        	
           
//            map.put("ownerid",ownerId);
//            System.out.println(map);
            
            
            List<HashMap> list5 = ownerService.getUserList(ownerId);
            
            System.out.println(list5);
            
            model.addAttribute("shopList", list);
            model.addAttribute("userInfo",list5);
            
            return "/owner/ownerViewPage"; 
        }
  
    }
    
    //사업자 회원가입 컨트롤러
    @RequestMapping({"ownerInsert.do"})
    public String ownerInsert(OwnerVO vo) {
        this.ownerService.ownerInsert(vo);
        return "redirect:owner_login.do";
    }
    
    // 구인공고 페이지에서 공고글을 올리는 컨트롤러
    @RequestMapping({"ownerBoardInsert.do"})
    public String ownerBoardInsert(OwnerBoardVO vo, Model m) {
    	
        String jobDate = vo.getJobDate();
        
        System.out.println(vo.getOwnernum());
        ownerService.ownerBoardInsert(vo);
        List<OwnerBoardVO> list = ownerService.getOwnerBoardList(vo);
        m.addAttribute("ownerBoardList", list);
        
       
        return "redirect:job_positing.do";
    }
    
    // 한세호 =======================================================
	@Autowired
	private SqlSessionTemplate mybatis;
	
    // 구인공고페이지 취소 클릭 시 공고 게시판 삭제
    @RequestMapping({"cancel_job.do"})
    public String job_cancel(@RequestParam int board_seq){
    	
    	mybatis.update("owner.ownerBoardCancel",board_seq);
    	return "redirect:job_positing.do";
    }
    // =======================================================
	
	
    //구인공고페이지 클릭시  구독권을 구매한경우 구인공고페이지로 아닐경우 구독권 구매페이지로 이동
    @RequestMapping({"job_positing.do"})
    public String job_list(OwnerVO vo,OwnerBoardVO vo1,ShopVO vo2, Model m, HttpServletRequest request) throws Exception {
    	//현재 Ownernum 가져오기---------------------------------------------------------------
    	HttpSession session = request.getSession();
        Integer ownernum = (Integer)session.getAttribute("ownernum");
        vo.setOwnernum(ownernum);
        vo1.setOwnernum(ownernum);
        vo2.setOwnernum(ownernum);
    
        //---------------------------------------------------------------

        List<OwnerVO> list = ownerService.getList(vo);
        List<OwnerBoardVO> list1= ownerService.getOwnerBoardList(vo1);


        List<ShopVO> list2=shopService.ShopList1(vo2);
        
        m.addAttribute("ownerList", list);
        m.addAttribute("ownerBoardList",list1);
        m.addAttribute("shopList",list2);
      
        
       	OwnerVO vosub = list.get(0);
       	
       	
       	
       	if(  Integer.parseInt(vosub.getOwnersub()) == 0 || vosub.getOwnersub() == null  ){
 
       		
       		
       		return "/owner/owner_sub";
       		
       	}else{
       		
       		
       		return "/owner/job_positing";
       	}



    }
    
    
  // 한세호 ====================================
    @Autowired
    public MemberSV memberSV;
    // ====================================


    // 사업자 로그인 컨트롤러 로그인실패시 다시 로그인창 로그인 성공시 사업자 마이페이지로 이동
    @RequestMapping({"login.do"})
    public String ownerLogin(OwnerVO vo, OwnerBoardVO boardVo, Model m, HttpServletRequest request) throws Exception {
        OwnerVO result = this.ownerService.idCheck_Login(vo);
        if (result == null) {
            return "/owner/owner_login";
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("ownernum", result.getOwnernum());
            session.setAttribute("ownerid", result.getOwnerid());
			List<OwnerBoardVO> list = this.ownerService.getOwnerBoardList(boardVo);
           
			
            // 한세호 =========================================================================================================
//            String ownerPayEnd = memberSV.select_pay_date_end((int) session.getAttribute("ownernum"));
    
            
//          System.out.println(Long.parseLong((String) ownerPayEnd));  //구독권 끝나는 시간
//          long now = new Date().getTime(); // 현재시간
//          System.out.println(now);
//          
//          if (Long.parseLong((String) ownerPayEnd) < now){
//          	System.out.println("현재 구독권 끝나는 시간과 현재 시간 비교 성공??");
//          	System.out.println("구독권 끝난 사람 지우기");
//          	memberSV.update_coupon_terminated((int) session.getAttribute("ownernum"));
//          }
        //=========================================================================================================
			
		   m.addAttribute("ownerBoardList", list);
            return "redirect:ownerMypage.do";
        }
    }
    
    @RequestMapping(
        value = {"idCheck.do"},
        produces = {"application/text; charset=UTF-8"}
    )
    @ResponseBody
    public String idCheck(OwnerVO vo) {
        OwnerVO result = this.ownerService.idCheck_Login(vo);
        String message = "사용가능한 아이디 입니다.";
        if (result != null) {
            message = "이미 사용중인 아이디 입니다.";
        }
        return message;
    }
}
