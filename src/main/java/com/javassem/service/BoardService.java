package com.javassem.service;

import com.javassem.domain.BoardVO;
import com.javassem.util.PagingVO;
import java.util.HashMap;
import java.util.List;

public interface BoardService {
  void insertBoard(BoardVO paramBoardVO);
  
  void updateBoard(BoardVO paramBoardVO);
  
  void deleteBoard(BoardVO paramBoardVO);
  
  BoardVO getBoard(BoardVO paramBoardVO);
  
  List<BoardVO> getBoardList(HashMap paramHashMap);
  
  int countBoard();
  
  List<BoardVO> selectBoard(PagingVO paramPagingVO);
}
