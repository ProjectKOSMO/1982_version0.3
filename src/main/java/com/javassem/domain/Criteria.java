package com.javassem.domain;

public class Criteria {
  private int page = 1;
  
  private int pageSize = 10;
  
  public int getPage() {
    return this.page;
  }
  
  public void setPage(int page) {
    if (page <= 0) {
      this.page = 1;
      return;
    } 
    this.page = page;
  }
  
  public int getPageSize() {
    return this.pageSize;
  }
  
  public void setPageSize(int pageSize) {
    if (pageSize <= 0 || pageSize > 100) {
      this.pageSize = 10;
      return;
    } 
    this.pageSize = pageSize;
  }
  
  public int getPageStart() {
    return (this.page - 1) * this.pageSize;
  }
  
  public String toString() {
    return "Criteria [page=" + this.page + ", pageSize=" + this.pageSize + "]";
  }
}
