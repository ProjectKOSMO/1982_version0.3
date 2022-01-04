package com.javassem.domain;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SubscribeVO {
	
	private int coupon_type;
	private int ownernum;
	private long pay_date;
	private long pay_date_end;
	private int payed_list_seq;
	private int amount;
	//통계용
	private double expectation;
	
	
	public int getCoupon_type() {
		return coupon_type;
	}
	public void setCoupon_type(int coupon_type) {
		this.coupon_type = coupon_type;
	}
	public int getOwnernum() {
		return ownernum;
	}
	public void setOwnernum(int ownernum) {
		this.ownernum = ownernum;
	}
	public String getPay_date() {
		return convertDate(pay_date);
	}
	public void setPay_date(long pay_date) {
		this.pay_date = pay_date;
	}
	public String getPay_date_end() {
		return convertDate(pay_date_end);
	}
	public void setPay_date_end(long pay_date_end) {
		this.pay_date_end = pay_date_end;
	}
	public int getPayed_list_seq() {
		return payed_list_seq;
	}
	public void setPayed_list_seq(int payed_list_seq) {
		this.payed_list_seq = payed_list_seq;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	// 통계용
	public double getExpectation() {
		return expectation;
	}
	public void setExpectation(double expectation) {
		this.expectation = expectation;
	}
	//날짜변환
	public static String convertDate(long second){
		String pattern="yyyy-MM-dd";
		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		String date=(String)formatter.format(new Timestamp(second));
		return date;
	}

}
