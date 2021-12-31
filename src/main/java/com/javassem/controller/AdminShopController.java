package com.javassem.controller;

import com.javassem.domain.ShopVO;
import com.javassem.service.ShopService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"admin"})
public class AdminShopController {
	
  @Autowired
  private ShopService shopService;
  
  @RequestMapping({"storeClose.do"})
  public void select(ShopVO vo, Model m) {
    List<ShopVO> list = this.shopService.ShopList(vo);
    m.addAttribute("ShopList", list);
  }
}
