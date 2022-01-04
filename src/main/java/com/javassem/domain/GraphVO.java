package com.javassem.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GraphVO {
	
	//매칭률
	private int matching;
	private int whole_apply;
	private int matching_success;
	// 재이용
	private int reusing;
	private int whole_use;
	private int reusing_ratio;
	//가입현황
	private int total;
	private int today;
	private int before1;
	private int before2;
	private int before3;
	private int before4;

	
	
	public int getMatching() {
		return matching;
	}
	public void setMatching(int matching) {
		this.matching = matching;
	}
	public int getWhole_apply() {
		return whole_apply;
	}
	public void setWhole_apply(int whole_apply) {
		this.whole_apply = whole_apply;
	}

	public int getMatching_success() {
		return matching_success;
	}
	public void setMatching_success(int matching_success) {
		this.matching_success = matching_success;
	}
	public int getReusing() {
		return reusing;
	}
	public void setReusing(int reusing) {
		this.reusing = reusing;
	}
	public int getWhole_use() {
		return whole_use;
	}
	public void setWhole_use(int whole_use) {
		this.whole_use = whole_use;
	}
	public int getReusing_ratio() {
		return reusing_ratio;
	}
	public void setReusing_ratio(int reusing_ratio) {
		this.reusing_ratio = reusing_ratio;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getToday() {
		return today;
	}
	public void setToday(int today) {
		this.today = today;
	}
	public int getBefore1() {
		return before1;
	}
	public void setBefore1(int before1) {
		this.before1 = before1;
	}
	public int getBefore2() {
		return before2;
	}
	public void setBefore2(int before2) {
		this.before2 = before2;
	}
	public int getBefore3() {
		return before3;
	}
	public void setBefore3(int before3) {
		this.before3 = before3;
	}
	public int getBefore4() {
		return before4;
	}
	public void setBefore4(int before4) {
		this.before4 = before4;
	}
	

}
