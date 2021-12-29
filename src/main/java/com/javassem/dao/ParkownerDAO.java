package com.javassem.dao;

import com.javassem.domain.PagingVO;
import com.javassem.domain.ParkownerVO;
import java.util.List;

public interface ParkownerDAO {
  List<ParkownerVO> getOwnerList(PagingVO paramPagingVO);
  
  int countBoard();
}
