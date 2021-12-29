package com.javassem.service;

import com.javassem.dao.OwnerDAOImpl;
import com.javassem.domain.OwnerBoardVO;
import com.javassem.domain.OwnerVO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ownerService")
public class OwnerServiceImpl implements OwnerService {
  @Autowired
  private OwnerDAOImpl ownerDAO;
  
  public OwnerVO idCheck_Login(OwnerVO vo) {
    return this.ownerDAO.idCheck(vo);
  }
  
  public int ownerInsert(OwnerVO vo) {
    return this.ownerDAO.ownerInsert(vo);
  }
  
  public String ownerDate(OwnerVO vo) {
    return this.ownerDAO.ownerDate(vo);
  }
  
  public int ownerBoardInsert(OwnerBoardVO vo) {
    return this.ownerDAO.ownerBoardInsert(vo);
  }
  
  public List<OwnerBoardVO> getOwnerBoardList(OwnerBoardVO vo) {
    return this.ownerDAO.getOwnerBoardList(vo);
  }
  
  public int insertShopInfo(OwnerVO vo) {
    return this.ownerDAO.shopInsert(vo);
  }
  
  public int updateShopInfo(OwnerVO vo) {
    return this.ownerDAO.shopUpdate(vo);
  }
  
  public String selectShopInfo(OwnerVO vo) {
    return this.ownerDAO.shopSelect(vo);
  }
  
  public List<OwnerVO> getList(OwnerVO vo) {
    return this.ownerDAO.getList(vo);
  }
}
