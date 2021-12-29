//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//
package com.javassem.controller;
import com.javassem.domain.OwnerBoardVO;
import com.javassem.domain.OwnerVO;
import com.javassem.service.OwnerService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
@RequestMapping({"owner"})
public class OwnerLoginController {
    @Autowired
    public OwnerService ownerService;
    public OwnerLoginController() {
    }
    @RequestMapping({"{step}.do"})
    public String ownerJoin(@PathVariable String step) {
        return "/owner/" + step;
    }
    @RequestMapping({"ownerMypage.do"})
    public String ownerMypage(OwnerVO vo, Model model, HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();
        Integer ownernum = (Integer)session.getAttribute("ownernum");
        vo.setOwnernum(ownernum);
        List<OwnerVO> list = this.ownerService.getList(vo);
        model.addAttribute("shopList", list);
        System.out.println(list);
        return list.isEmpty() ? "/owner/ownerMypage" : "/owner/ownerViewPage";
    }
    @RequestMapping({"shopInsert.do"})
    public String shopInsert(OwnerVO vo, Model model) {
        this.ownerService.insertShopInfo(vo);
        List<OwnerVO> list = this.ownerService.getList(vo);
        model.addAttribute("shopList", list);
        return "redirect:ownerList.do";
    }
    @RequestMapping({"ownerUpdate.do"})
    public String ownerUpdatePage(OwnerVO vo, Model model, HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();
        Integer ownernum = (Integer)session.getAttribute("ownernum");
        vo.setOwnernum(ownernum);
        List<OwnerVO> list = this.ownerService.getList(vo);
        model.addAttribute("shopInfo", list);
        return "/owner/ownerUpdate";
    }
    @RequestMapping({"shopUpdate.do"})
    public String shopUpdate(OwnerVO vo, Model model, HttpServletRequest request) throws Exception {
        this.ownerService.updateShopInfo(vo);
        this.ownerService.getList(vo);
        Thread.sleep(5000L);
        return "redirect:ownerList.do";
    }
    @RequestMapping({"ownerList.do"})
    public String getList(OwnerVO vo, Model model, HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();
        Integer ownernum = (Integer)session.getAttribute("ownernum");
        vo.setOwnernum(ownernum);
        List<OwnerVO> list = this.ownerService.getList(vo);
        model.addAttribute("shopList", list);
        return "/owner/ownerViewPage";
    }
    @RequestMapping({"ownerInsert.do"})
    public String ownerInsert(OwnerVO vo) {
        this.ownerService.ownerInsert(vo);
        return "redirect:owner_login.do";
    }
    @RequestMapping({"ownerBoardInsert.do"})
    public String ownerBoardInsert(OwnerBoardVO vo, Model m) {
    	
        String jobDate = vo.getJobDate();
        
        System.out.println(vo.getOwnernum());
        ownerService.ownerBoardInsert(vo);
        List<OwnerBoardVO> list = ownerService.getOwnerBoardList(vo);
        m.addAttribute("ownerBoardList", list);
        
       
        return "redirect:job_positing.do";
    }

    @RequestMapping({"job_positing.do"})
    public String job_list(OwnerVO vo,OwnerBoardVO vo1, Model m, HttpServletRequest request) throws Exception {
    	//현재 Ownernum 가져오기---------------------------------------------------------------
    	HttpSession session = request.getSession();
        Integer ownernum = (Integer)session.getAttribute("ownernum");
        vo.setOwnernum(ownernum);
        vo1.setOwnernum(ownernum);
        System.out.println(ownernum);
        //---------------------------------------------------------------

        List<OwnerVO> list = ownerService.getList(vo);
        List<OwnerBoardVO> list1= ownerService.getOwnerBoardList(vo1);
        m.addAttribute("ownerList", list);
        m.addAttribute("ownerBoardList",list1);
     
        
       	OwnerVO vosub = list.get(0);
       	
       	
       	
       	if(  Integer.parseInt(vosub.getOwnersub()) == 0 || vosub.getOwnersub() == null  ){
 
       		System.out.println("널값입니다.");
       		
       		return "/owner/owner_sub";
       		
       	}else{
       		
       		System.out.println("이사람은 구독해써요");
       		
       		return "/owner/job_positing";
       	}


//        list.forEach(System.out::println);


    }





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
