package com.javassem.domain;

public class ParkBlackVO {
	
  private String userId;
  private String reason;
  private String warnDate;
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
  
  public String getUserName() {
    return this.userName;
  }
  
  public void setUserName(String userName) {
    this.userName = userName;
  }
  
  public String getUserId() {
    return this.userId;
  }
  
  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getWarnDate() {
	  return warnDate;
  }
  public void setWarnDate(String warnDate) {
	  this.warnDate = warnDate;
  }
  
}
