package com.javassem.service;

import com.javassem.domain.PagingVO;
import com.javassem.domain.ParkownerVO;
import java.util.List;

public interface ParkownerService {
  int countBoard();
  
  List<ParkownerVO> getOwnerList(PagingVO paramPagingVO);
}
