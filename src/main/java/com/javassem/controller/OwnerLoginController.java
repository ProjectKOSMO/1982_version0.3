//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//
package com.javassem.controller;
import java.util.ArrayList;
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
import com.javassem.domain.UserVO;
import com.javassem.service.MemberSV;
import com.javassem.service.OwnerService;
import com.javassem.service.ParkBlackService;
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
    
    @Autowired
    public ParkBlackService parkBlackService;
    
    public OwnerLoginController() {
    }
    
    
    
    @RequestMapping({"{step}.do"})
    public String ownerJoin(@PathVariable String step) {
        return "/owner/" + step;
    }
    
    // 비밀번호 찾기, 아이디 찾기
    @RequestMapping(value = {"findId.do"})
    public String findId(OwnerVO  vo, Model m, HttpServletRequest request){
    	List<OwnerVO> list = this.ownerService.findId(vo);
    	System.out.println(vo.getOwnername());
    	System.out.println(vo.getOwnermail());
    	System.out.println(vo.getOwnerpn());
    	System.out.println(list);
    	
    	m.addAttribute("msg", "가입하신 아이디가 존재하지 않습니다");
    	m.addAttribute("url", "missId.do");
    	if(list.isEmpty()){
    		return "owner/errorPage";
    	}
    	else{
    		m.addAttribute("ownerfindid", list);
    		return "owner/findUserId";
    	}
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
    
	// 사업자 마이페이지에 DB에저장된 데이터를 가지고 보여주기만하는 컨트롤러
	@RequestMapping({ "ownerList.do" })
	public String getList(OwnerVO vo, OwnerBoardVO vo1, ShopVO vo2, UserVO vo3, Model model, HttpServletRequest request)
			throws Exception {

		HttpSession session = request.getSession();
		Integer ownernum = (Integer) session.getAttribute("ownernum");
		String ownerId = (String) session.getAttribute("ownerid");

		vo.setOwnernum(ownernum);
		vo1.setOwnernum(ownernum);

		List<OwnerVO> list = this.ownerService.getList(vo);
		List<OwnerBoardVO> list2 = this.ownerService.getOwnerBoardList(vo1);

		List<HashMap> list5 = ownerService.getUserList(ownerId);
		List<HashMap> list6 = ownerService.machingList(ownerId);
		List<HashMap> list7 = ownerService.endList(ownerId);
		List<HashMap> black;
		List<HashMap> black2;
		List<HashMap> black_list = null;
		boolean bool ;
		
//		// 회원들의 전체 정보 중 구직자넘버
//		for (int i = 0; i < result.size(); i++) {
//			System.out.println(result.get(i).getUsernum());
//
//		}

		HashMap hashmap3 = new HashMap();
		hashmap3.put("ownerNum", ownernum);
		black2 = mybatis.selectList("owner.blackList2", hashmap3);
		
		
		/*for (int i2 = 0; i2 < list5.size(); i2++) {
				
			String at = (String) list5.get(i2).get("userid");
			
			System.out.println(at);
			
			for (int j = 0; j < black2.size(); j++) {
			String s2 = (String)black2.get(j).get("userId");
			
			
			 bool = at.equals(s2);*/
		
		
// 현재 대기중인 구직자 넘버
		for (int i = 0; i < list5.size(); i++) {
			System.out.println(list5.get(i).get("userNum"));
			String test2 = list5.get(i).get("userNum").toString();
		}
		
		
		// 사업자가 구인공고를 등록한게 없을경우
		
		for (int i2 = 0; i2 < list5.size(); i2++) {
			
			String at = (String) list5.get(i2).get("userid");
			
			System.out.println(at);
			
			for (int j = 0; j < black2.size(); j++) {
			String s2 = (String)black2.get(j).get("userId");
			
			
			bool = at.equals(s2);
			System.out.println(bool);
			}
			
		}
		
		
		
		
		if (list2.isEmpty() || list2 == null  ) {
		

			model.addAttribute("shopList", list);

			return "/owner/ownerViewPage";

			// 대기중인 지원자가 없을 경우
		}
		
		
		

		//-------------------------------------------------------------------------------------
		
		if (list5.isEmpty() || list5 == null  ) {
			
			System.out.println("대기중인 지원자가 없습니다.");

		HashMap hashmap2 = new HashMap();

		List userNum_List = new ArrayList();
		userNum_List.add("00");
		// List<HashMap> list5_new = list5;
		for (int i = 0; i < list7.size(); i++) {
			System.out.println(list7.get(i).get("userNum"));
			String test = list7.get(i).get("userNum").toString();

			hashmap2.put("ownerNum", ownernum);
			hashmap2.put("userNum", test);
			

			black = mybatis.selectList("owner.blackList", hashmap2);

			int flag = 0;
			
			for (int k = 0; k < userNum_List.size(); k++){
				if (userNum_List.get(k).equals(test))
					flag = 1;
			}
			userNum_List.add(test);
			System.out.println(userNum_List);

			if (flag == 0){
				if (i == 0)
					black_list = black;
				else
					black_list.addAll(black);
			}
					
			
			

		} 

		model.addAttribute("shopList", list);
		// model.addAttribute("userInfo",list5);
		// model.addAttribute("userInfo",list5);
		model.addAttribute("machingList", list6);
		model.addAttribute("endList", list7);
		model.addAttribute("blackList", black_list);

		return "/owner/ownerViewPage";
	}
			
			 
	 // 대기중인 지원자가 없을 경우
			// 조건식 결과가 참인경우
		
		//-------------------------------------------------------------------------------------
		else {
			
			 
			// 조건식 결과가 true인 경우
			// 대기중인 지원자가 없을 경우
			System.out.println("대기중인 지원자가 있는 경우");

			//==================================================================================
			HashMap hashmap1 = new HashMap();			
			List userNum_List = new ArrayList();
			userNum_List.add("00");			
			// 종료된 아이디 블랙리스트 게시판에 추가 =========================================================
			for (int i = 0; i < list7.size(); i++) {
				System.out.println(list7.get(i).get("userNum"));
				String test = list7.get(i).get("userNum").toString();

				hashmap1.put("ownerNum", ownernum);
				hashmap1.put("userNum", test);
				

				black = mybatis.selectList("owner.blackList", hashmap1);

				int flag = 0;
				
				for (int k = 0; k < userNum_List.size(); k++){
					if (userNum_List.get(k).equals(test))
						flag = 1;
				}
				userNum_List.add(test);
				System.out.println(userNum_List);

				if (flag == 0){
					if (i == 0)
						black_list = black;
					else
						black_list.addAll(black);
				}
				System.out.println(black_list);
			} 
			
			// =========================================================

			
			
			HashMap hashmap2 = new HashMap();
			List<HashMap> list5_new = list5;
			for (int i = 0; i < list5.size(); i++) {
				System.out.println(list5.get(i).get("userNum"));
				String test = list5.get(i).get("userNum").toString();

				hashmap2.put("ownerNum", ownernum);
				hashmap2.put("userNum", test);

				
				black = mybatis.selectList("owner.blackList", hashmap2);
				
				
				// =================================================
				userNum_List.add(test);
				System.out.println(userNum_List);
				
				int flag = 0;
				
				for (int k = 0; k < userNum_List.size(); k++){
					if (userNum_List.get(k).equals(test))
						flag = 1;
				}
				// =================================================
				
				
				
				if (black == null || black.isEmpty()) {
					System.out.println("black null");
					
					model.addAttribute("shopList", list);
					model.addAttribute("userInfo",list5);
//					model.addAttribute("userInfo", list5_new);
					model.addAttribute("machingList", list6);
					model.addAttribute("endList", list7);
					model.addAttribute("blackList", black_list);

					return "/owner/ownerViewPage";

				} else {
					if (i == 0) {
						
						if (flag == 0)
							black_list.addAll(black);
						
						System.out.println("if 안쪽");
						System.out.println(black);
						
						if (black == null || black.isEmpty()) {

							model.addAttribute("shopList", list);
							// model.addAttribute("userInfo",list5);
							model.addAttribute("userInfo", list5_new);
							model.addAttribute("machingList", list6);
							model.addAttribute("endList", list7);
							// model.addAttribute("blackList", black_list);

						} else {

							for (int j2 = 0; j2 < black.size(); j2++) {
								System.out.println(list5_new.get(i).get("userNum") );
								System.out.println(black.get(j2).get("userNum"));
								
								System.out.println("//==============================================");
								
								//=========================================
								int it =  (Integer)list5_new.get(i).get("userNum");
								String a1 = Integer.toString(it);
								String a2 = (String)black.get(j2).get("userNum");
								//=========================================
								if (a1.equals(a2))
									list5_new.remove(i);
							}
							model.addAttribute("shopList", list);
							// model.addAttribute("userInfo",list5);
							model.addAttribute("userInfo", list5_new);
							model.addAttribute("machingList", list6);
							model.addAttribute("endList", list7);

						}
					} else {
						
						if (flag == 0)
							black_list.addAll(black);
						
						System.out.println("else 안쪽");
						System.out.println(black);

						if (black == null || black.isEmpty()) {

							model.addAttribute("shopList", list);
							// model.addAttribute("userInfo",list5);
							model.addAttribute("userInfo", list5_new);
							model.addAttribute("machingList", list6);
							model.addAttribute("endList", list7);
							// model.addAttribute("blackList", black_list);

						} else {

							for (int j3 = 0; j3 < black.size(); j3++) {
								System.out.println(list5_new.get(i).get("userNum") );
								System.out.println(black.get(j3).get("userNum"));
								//=========================================
								int it =  (Integer)list5_new.get(i).get("userNum");
								String a1 = Integer.toString(it);
								String a2 = (String)black.get(j3).get("userNum");
								//=========================================
								if (a1.equals(a2))
									list5_new.remove(i);
									
							}
							model.addAttribute("shopList", list);
							// model.addAttribute("userInfo",list5);
							model.addAttribute("userInfo", list5_new);
							model.addAttribute("machingList", list6);
							model.addAttribute("endList", list7);

						}

					}

				}

			}
			model.addAttribute("shopList", list);
			model.addAttribute("userInfo",list5);
			// model.addAttribute("userInfo", list5_new);
			model.addAttribute("machingList", list6);
			model.addAttribute("endList", list7);
			model.addAttribute("blackList", black_list);

			return "/owner/ownerViewPage";

		
		}// 지원자가 있는 케이스-------------------------------------------------------------------------------------

	}
		

//		model.addAttribute("shopList", list);
//		// model.addAttribute("userInfo",list5);
//		model.addAttribute("userInfo", list5_new);
//		model.addAttribute("machingList", list6);
//		model.addAttribute("endList", list7);
//		model.addAttribute("blackList", black_list);


            
    
  

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
	
    @RequestMapping({"accept.do"})
    public String owner_accept(@RequestParam int info_board_seq, @RequestParam String info_userId){
    	
    	int seq = info_board_seq;
    	String id = info_userId;
    	
    	
    	HashMap hashmap= new HashMap();
    	hashmap.put("info_board_seq",seq);
    	hashmap.put("info_userId",id);
    	
    	mybatis.update("owner.ownerAccept",hashmap);
    	return "redirect:ownerList.do";
    }
    
    
    @RequestMapping({"sorry.do"})
    public String owner_sorry(@RequestParam int info_board_seq, @RequestParam String info_userId){
    	
    	int seq = info_board_seq;
    	String id = info_userId;
    	
    	
    	HashMap hashmap= new HashMap();
    	hashmap.put("info_board_seq",seq);
    	hashmap.put("info_userId",id);
    	
    	mybatis.update("owner.ownerSorry",hashmap);
    	return "redirect:ownerList.do";
    }
    
    
    @RequestMapping({"ownerEnd.do"})
    public String ownerEnd(@RequestParam int info_board_seq, @RequestParam String info_userId){
    	
    	int seq = info_board_seq;
    	String id = info_userId;
    	
    	
    	HashMap hashmap= new HashMap();
    	hashmap.put("info_board_seq",seq);
    	hashmap.put("info_userId",id);
    	
    	mybatis.update("owner.ownerEnd",hashmap);
    	return "redirect:ownerList.do";
    }
    
    
	//사업자측 차단 버튼 클릭시 blacklist에 데이터 insert
    @RequestMapping({"black.do"})
    public String ownerblack(OwnerBoardVO vo,
    		
    		@RequestParam String reason,
    		@RequestParam String userName,
    		@RequestParam String userId,
    		@RequestParam String userNum,
    		@RequestParam String ownerNum

    		){
    
    	
    	
    	String rea= reason;
    	String un= userName;
    	String ui= userId;
    	String usern= userNum;
    	String on= ownerNum;
    	
    	HashMap hashmap= new HashMap();
    	hashmap.put("reason",rea);
    	hashmap.put("userName",un);
    	hashmap.put("userId",ui);
    	hashmap.put("userNum",usern);
    	hashmap.put("ownerNum",on);
    	

        HashMap dd = mybatis.selectOne("owner.blackCnt", hashmap);
    	
        if (dd == null || dd.isEmpty()){
        	
        	mybatis.insert("owner.black", hashmap);
        		
        	return "redirect:ownerList.do";
        	
        }else{
        	mybatis.insert("owner.black2", hashmap);
        	
        	
        	return "redirect:ownerList.do";
        }
        
        
/*  hashmap.put("warnCnt",dd.get("warnCnt"));*/
        
    	
    	
    	
    	
        
    }
    
    
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
