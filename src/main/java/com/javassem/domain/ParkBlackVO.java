package com.javassem.domain;

public class ParkBlackVO {
	
  private String userID;
  private String reason;
  private String userPN;
  private String userName;
  private int warnCnt;
  
public int getWarnCnt() {
    return this.warnCnt;
  }
  
  public void setWarnCnt(int warnCnt) {
    this.warnCnt = warnCnt;
  }
  
  public String getReason() {
    return this.reason;
  }
  
  public void setReason(String reason) {
    this.reason = reason;
  }
  
  public String getUserPN() {
    return this.userPN;
  }
  
  public void setUserPN(String userPN) {
    this.userPN = userPN;
  }
  
  public String getUserName() {
    return this.userName;
  }
  
  public void setUserName(String userName) {
    this.userName = userName;
  }
  
  public String getUserID() {
    return this.userID;
  }
  
  public void setUserID(String userID) {
    this.userID = userID;
  }
}
