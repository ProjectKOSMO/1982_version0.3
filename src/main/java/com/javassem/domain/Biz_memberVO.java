package com.javassem.domain;

public class Biz_memberVO {
	private String pay_coupon;
	private String biz_email;
	private int ownernum;
	
	public int getOwnernum() {
		return ownernum;
	}
	public void setOwnernum(int ownernum) {
		this.ownernum = ownernum;
	}
	public String getPay_coupon() {
		return pay_coupon;
	}
	public void setPay_coupon(String pay_coupon) {
		this.pay_coupon = pay_coupon;
	}
	public String getBiz_email() {
		return biz_email;
	}
	public void setBiz_email(String biz_email) {
		this.biz_email = biz_email;
	}
	
}
