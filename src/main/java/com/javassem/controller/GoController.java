package com.javassem.controller;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javassem.domain.ShopVO;

@RestController
@RequestMapping("Go")
public class GoController {
	
	@Autowired
	  private SqlSessionTemplate mybatis;
	
	@GetMapping(value="/supportInsert2", produces="text/plain;charset=UTF-8")
	public String Test(ShopVO vo){
		
		String a="이미 지원한 업체 입니다.";
		ShopVO y = mybatis.selectOne("ShopDAO.getSupport", vo);
		if(y == null){	
			mybatis.insert("ShopDAO.getShop2", vo);
			a="지원 완료하였습니다.";
		}else{
						
		}
		
		return a;
	}

}
