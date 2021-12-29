package com.javassem.dao;

import com.javassem.domain.BoardVO;
import java.util.HashMap;
import java.util.List;

public interface BoardDAO {
  void insertBoard(BoardVO paramBoardVO);
  
  void updateBoard(BoardVO paramBoardVO);
  
  void deleteBoard(BoardVO paramBoardVO);
  
  BoardVO getBoard(BoardVO paramBoardVO);
  
  List<BoardVO> getBoardList(HashMap paramHashMap);
  
  int countBoard();
}
