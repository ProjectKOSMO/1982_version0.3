package com.javassem.service;

import com.javassem.dao.ParkDAO;
import com.javassem.domain.ParkVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("parkService")
public class ParkServiceImpl implements ParkService {
  @Autowired
  private ParkDAO parkDAO;
  
  public ParkVO idCheck_Login(ParkVO vo) {
    return this.parkDAO.idCheck(vo);
  }
}
