package com.javassem.dao;

import com.javassem.domain.BoardVO;
import com.javassem.util.PagingVO;
import java.util.HashMap;
import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("boardDAO")
public class BoardDAOImpl implements BoardDAO {
  @Autowired
  private SqlSessionTemplate mybatis;
  
  public void insertBoard(BoardVO vo) {
    System.out.println("===> Mybatis insertBoard()");
    this.mybatis.insert("BoardDAO.insertBoard", vo);
  }
  
  public void updateBoard(BoardVO vo) {
    System.out.println("===> Mybatis updateBoard()");
    this.mybatis.update("BoardDAO.updateBoard", vo);
  }
  
  public void deleteBoard(BoardVO vo) {
    System.out.println("===> Mybatis deleteBoard()");
    this.mybatis.delete("BoardDAO.deleteBoard", vo);
  }
  
  public BoardVO getBoard(BoardVO vo) {
    System.out.println("===> Mybatis getBoard()");
    return (BoardVO)this.mybatis.selectOne("BoardDAO.getBoard", vo);
  }
  
  public List<BoardVO> getBoardList(HashMap map) {
    System.out.println("===> Mybatis getBoardList()");
    return this.mybatis.selectList("BoardDAO.getBoardList", map);
  }
  
  public int countBoard() {
    return ((Integer)this.mybatis.selectOne("BoardDAO.countboard")).intValue();
  }
  
  public List<BoardVO> selectBoard(PagingVO vo) {
    List<BoardVO> result = this.mybatis.selectList("BoardDAO.selectBoard", vo);
    return result;
  }
}
