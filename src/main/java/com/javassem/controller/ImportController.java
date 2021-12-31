package com.javassem.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.javassem.domain.Biz_memberVO;
import com.javassem.domain.Payed_listVO;
import com.javassem.service.MemberSV;
import com.javassem.service.PaySV;

@RestController
public class ImportController {
	
	@Autowired
	MemberSV memberSV;
	@Autowired
	PaySV paySV;
	
	@RequestMapping("insertPayCoupon.do")
	@ResponseBody
	public int pay(@RequestBody Payed_listVO pvo, Model m, HttpServletRequest request) {
		System.out.println("pvo.getMerchant_uid : " + pvo.getMerchant_uid());
		
		HttpSession session = request.getSession();
		
		pvo.setOwnernum((int) session.getAttribute("ownernum"));
		int res = paySV.insert_pay(pvo);
//		int res = 1;
		if(res == 1) {
//			Biz_memberVO bvo = memberSV.selectBizMember(pvo.getOwnernum());
			
			
//			Biz_memberVO bvo = memberSV.selectBizMember(pvo.getㅐ());
//			bvo.setPay_coupon(bvo.getPay_coupon()+5);
			
			System.out.println((int) session.getAttribute("ownernum"));
			memberSV.update_sub((int) session.getAttribute("ownernum"));
			
			

//			System.out.println("paycoupon: " + bvo.getPay_coupon());
//			res = paySV.updateBiz_pay(bvo);
			if(res == 1)
				System.out.println("biz_member pay coupon insert complete");
		}
		
		return res;
	}
	
}
