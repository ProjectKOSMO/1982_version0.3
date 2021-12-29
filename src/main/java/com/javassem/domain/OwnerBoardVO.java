package com.javassem.domain;
import java.util.Date;
public class OwnerBoardVO {
  private int board_owner_seq;
  
  private String normal_emergency;
  
  private String jobDate;
  
  private String jobTime_start;

  private String jobTime_end;

  private String ownersub;

  private String writer;

  private String content;
  
  private String shopname;
  
  private String shopaddr;
  
  private String shopdate;
  
  private String shoppay;

  private String need_Num;

  private int ownernum;



private Date regDate;

  public int getBoard_owner_seq() {
    return this.board_owner_seq;
  }
  
  public void setBoard_owner_seq(int board_owner_seq) {
    this.board_owner_seq = board_owner_seq;
  }
  
  public String getShopname() {
    return this.shopname;
  }
  
  public void setShopname(String shopname) {
    this.shopname = shopname;
  }
  
  public String getJobDate() {
    return this.jobDate;
  }
  
  public void setJobDate(String jobDate) {
    this.jobDate = jobDate;
  }
  
  public String getJobTime_start() {
    return this.jobTime_start;
  }
  
  public void setJobTime_start(String jobTime_start) {
    this.jobTime_start = jobTime_start;
  }
  
  public String getJobTime_end() {
    return this.jobTime_end;
  }
  
  public void setJobTime_end(String jobTime_end) {
    this.jobTime_end = jobTime_end;
  }
  
  public String getNormal_emergency() {
    return this.normal_emergency;
  }
  
  public void setNormal_emergency(String normal_emergency) {
    this.normal_emergency = normal_emergency;
  }
  
  public String getNeed_Num() {
    return this.need_Num;
  }
  
  public void setNeed_Num(String need_Num) {
    this.need_Num = need_Num;
  }
  
  public String getWriter() {
    return this.writer;
  }
  
  public void setWriter(String writer) {
    this.writer = writer;
  }
  
  public String getContent() {
    return this.content;
  }
  
  public void setContent(String content) {
    this.content = content;
  }
  
  public Date getRegDate() {
    return this.regDate;
  }
  
  public void setRegDate(Date regDate) {
    this.regDate = regDate;
  }
  
  public String getShopaddr() {
    return this.shopaddr;
  }
  
  public void setShopaddr(String shopaddr) {
    this.shopaddr = shopaddr;
  }
  
  public String getShopdate() {
    return this.shopdate;
  }
  
  public void setShopdate(String shopdate) {
    this.shopdate = shopdate;
  }
  
  public String getShoppay() {
    return this.shoppay;
  }
  
  public void setShoppay(String shoppay) {
    this.shoppay = shoppay;
  }

  public String getOwnersub() {
	return ownersub;
}

  public void setOwnersub(String ownersub) {
	this.ownersub = ownersub;
}
  public int getOwnernum() {
	return ownernum;
}

  public void setOwnernum(int ownernum) {
	this.ownernum = ownernum;
}
}
