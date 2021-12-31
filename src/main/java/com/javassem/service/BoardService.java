package com.javassem.service;

import com.javassem.domain.BoardVO;
import com.javassem.util.PagingVO;
import java.util.HashMap;
import java.util.List;

public interface BoardService {
	
  // 게시판 서비스
  void insertBoard(BoardVO paramBoardVO);
  
  void updateBoard(BoardVO paramBoardVO);
  
  void deleteBoard(BoardVO paramBoardVO);
  
  BoardVO getBoard(BoardVO paramBoardVO);
  
  // 게시판 검색기능 / 페이징처리
  List<BoardVO> getBoardList(HashMap paramHashMap);
  
  int countBoard();
  
  List<BoardVO> selectBoard(PagingVO paramPagingVO);
}
