//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.javassem.controller;

import com.javassem.domain.BoardVO;
import com.javassem.service.BoardService;
import com.javassem.util.PagingVO;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping({"admin"})
public class AdminBoardController {
    @Autowired
    private BoardService boardService;

    public AdminBoardController() {
    }

    @RequestMapping({"/saveBoard.do"})
    public String insertBoard(BoardVO vo) throws IOException {
        System.out.println(vo);
        System.out.println(vo.getB_name());
        this.boardService.insertBoard(vo);
        return "redirect:Board.do";
    }

    @RequestMapping(
        value = {"/Board.do"},
        method = {RequestMethod.GET}
    )
    public String select(String searchCondition, String searchKeyword, Model m, PagingVO vo, @RequestParam(value = "nowPage",required = false) String nowPage, @RequestParam(value = "cntPerPage",required = false) String cntPerPage) {
        HashMap map = new HashMap();
        int total = this.boardService.countBoard();
        if (nowPage == null && cntPerPage == null) {
            nowPage = "1";
            cntPerPage = "5";
        } else if (nowPage == null) {
            nowPage = "1";
        } else if (cntPerPage == null) {
            cntPerPage = "5";
        }

        vo = new PagingVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
        map.put("searchCondition", searchCondition);
        map.put("searchKeyword", searchKeyword);
        map.put("start", vo.getStart());
        map.put("end", vo.getEnd());
        List<BoardVO> list = this.boardService.getBoardList(map);
        m.addAttribute("paging", vo);
        m.addAttribute("boardList", list);
        return "admin/Board";
    }

    @RequestMapping({"/getBoard.do"})
    public void getBoard(BoardVO vo, Model m) {
        BoardVO result = this.boardService.getBoard(vo);
        m.addAttribute("board", result);
    }

    @RequestMapping({"/deleteBoard.do"})
    public String delectBoard(BoardVO vo) {
        this.boardService.deleteBoard(vo);
        return "redirect:Board.do";
    }

    @RequestMapping({"/updateBoard.do"})
    public String updateBoard(BoardVO vo) {
        this.boardService.updateBoard(vo);
        return "redirect:Board.do";
    }
}
