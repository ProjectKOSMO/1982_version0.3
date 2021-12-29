//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.javassem.util;

public class PagingVO {
    private int nowPage;
    private int startPage;
    private int endPage;
    private int total;
    private int cntPerPage;
    private int lastPage;
    private int start;
    private int end;
    private int cntPage = 5;

    public PagingVO() {
    }

    public PagingVO(int total, int nowPage, int cntPerPage) {
        this.setNowPage(nowPage);
        this.setCntPerPage(cntPerPage);
        this.setTotal(total);
        this.calcLastPage(this.getTotal(), this.getCntPerPage());
        this.calcStartEndPage(this.getNowPage(), this.cntPage);
        this.calcStartEnd(this.getNowPage(), this.getCntPerPage());
    }

    public void calcLastPage(int total, int cntPerPage) {
        this.setLastPage((int)Math.ceil((double)total / (double)cntPerPage));
    }

    public void calcStartEndPage(int nowPage, int cntPage) {
        this.setEndPage((int)Math.ceil((double)nowPage / (double)cntPage) * cntPage);
        if (this.getLastPage() < this.getEndPage()) {
            this.setEndPage(this.getLastPage());
        }

        this.setStartPage(this.getEndPage() - cntPage + 1);
        if (this.getStartPage() < 1) {
            this.setStartPage(1);
        }

    }

    public void calcStartEnd(int nowPage, int cntPerPage) {
        this.setEnd(nowPage * cntPerPage);
        this.setStart(this.getEnd() - cntPerPage + 1);
    }

    public int getNowPage() {
        return this.nowPage;
    }

    public void setNowPage(int nowPage) {
        this.nowPage = nowPage;
    }

    public int getStartPage() {
        return this.startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public int getEndPage() {
        return this.endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    public int getTotal() {
        return this.total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCntPerPage() {
        return this.cntPerPage;
    }

    public void setCntPerPage(int cntPerPage) {
        this.cntPerPage = cntPerPage;
    }

    public int getLastPage() {
        return this.lastPage;
    }

    public void setLastPage(int lastPage) {
        this.lastPage = lastPage;
    }

    public int getStart() {
        return this.start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return this.end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int setCntPage() {
        return this.cntPage;
    }

    public void getCntPage(int cntPage) {
        this.cntPage = cntPage;
    }

    public String toString() {
        return "PagingVO [nowPage=" + this.nowPage + ", startPage=" + this.startPage + ", endPage=" + this.endPage + ", total=" + this.total + ", cntPerPage=" + this.cntPerPage + ", lastPage=" + this.lastPage + ", start=" + this.start + ", end=" + this.end + ", cntPage=" + this.cntPage + "]";
    }
}
