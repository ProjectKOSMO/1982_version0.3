package com.javassem.service;

import com.javassem.dao.ParkownerDAO;
import com.javassem.domain.PagingVO;
import com.javassem.domain.ParkownerVO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("parkownerService")
public class ParkownerServiceImpl implements ParkownerService {
  @Autowired
  private ParkownerDAO parkownerDAO;
  
  public int countBoard() {
    return this.parkownerDAO.countBoard();
  }
  
  public List<ParkownerVO> getOwnerList(PagingVO vo) {
    System.out.println("");
    return this.parkownerDAO.getOwnerList(vo);
  }
}
