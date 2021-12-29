package com.javassem.domain;

public class ParkownerVO {
  private String userName;
  
  private String shopName;
  
  private int deposit;
  
  private String state;
  
  public String getUserName() {
    return this.userName;
  }
  
  public void setUserName(String userName) {
    this.userName = userName;
  }
  
  public String getShopName() {
    return this.shopName;
  }
  
  public void setShopName(String shopName) {
    this.shopName = shopName;
  }
  
  public int getDeposit() {
    return this.deposit;
  }
  
  public void setDeposit(int deposit) {
    this.deposit = deposit;
  }
  
  public String getState() {
    return this.state;
  }
  
  public void setState(String state) {
    this.state = state;
  }
}
