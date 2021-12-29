package com.javassem.service;

import com.javassem.dao.BoardDAOImpl;
import com.javassem.domain.BoardVO;
import com.javassem.util.PagingVO;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
  @Autowired
  private BoardDAOImpl boardDAO;
  
  public void insertBoard(BoardVO vo) {
    this.boardDAO.insertBoard(vo);
  }
  
  public void updateBoard(BoardVO vo) {
    this.boardDAO.updateBoard(vo);
  }
  
  public void deleteBoard(BoardVO vo) {
    this.boardDAO.deleteBoard(vo);
  }
  
  public BoardVO getBoard(BoardVO vo) {
    return this.boardDAO.getBoard(vo);
  }
  
  public List<BoardVO> getBoardList(HashMap map) {
    return this.boardDAO.getBoardList(map);
  }
  
  public int countBoard() {
    return this.boardDAO.countBoard();
  }
  
  public List<BoardVO> selectBoard(PagingVO vo) {
    return this.boardDAO.selectBoard(vo);
  }
}
