package com.javassem.domain;

public class ShopInfoVO {
	private String shopname;
	private String shopaddr;
	private String shoppn;
	private String shopcontent;
	private String si_fname;
	private String si_realname;
	private String shopdate;
	private String shopupdate;
	private int shopnum;
	private String ownernum;
	private double location_y;
	private double location_x;
	
	private int board_owner_seq;
	
	public int getBoard_owner_seq() {
		return board_owner_seq;
	}
	public void setBoard_owner_seq(int board_owner_seq) {
		this.board_owner_seq = board_owner_seq;
	}
	public String getShopName() {
		return shopname;
	}
	public void setShopName(String shopName) {
		this.shopname = shopName;
	}
	public String getShopaddr() {
		return shopaddr;
	}
	public void setShopaddr(String shopaddr) {
		this.shopaddr = shopaddr;
	}
	public String getShoppn() {
		return shoppn;
	}
	public void setShoppn(String shoppn) {
		this.shoppn = shoppn;
	}
	public String getShopcontent() {
		return shopcontent;
	}
	public void setShopcontent(String shopcontent) {
		this.shopcontent = shopcontent;
	}
	public String getSi_fname() {
		return si_fname;
	}
	public void setSi_fname(String si_fname) {
		this.si_fname = si_fname;
	}
	public String getSi_realname() {
		return si_realname;
	}
	public void setSi_realname(String si_realname) {
		this.si_realname = si_realname;
	}
	public String getShopdate() {
		return shopdate;
	}
	public void setShopdate(String shopdate) {
		this.shopdate = shopdate;
	}
	public String getShopupdate() {
		return shopupdate;
	}
	public void setShopupdate(String shopupdate) {
		this.shopupdate = shopupdate;
	}
	public int getShopnum() {
		return shopnum;
	}
	public void setShopnum(int shopnum) {
		this.shopnum = shopnum;
	}
	public String getOwnernum() {
		return ownernum;
	}
	public void setOwnernum(String ownernum) {
		this.ownernum = ownernum;
	}
	public double getLocation_y() {
		return location_y;
	}
	public void setLocation_y(double location_y) {
		this.location_y = location_y;
	}
	public double getLocation_x() {
		return location_x;
	}
	public void setLocation_x(double location_x) {
		this.location_x = location_x;
	}
	
}
