package com.javassem.domain;

import java.io.File;
import java.io.IOException;
import java.util.UUID;
import org.springframework.web.multipart.MultipartFile;

// 구직자 이력서 VO
public class UserInfoViewVO {
	private int userNum;
	// 최종학력
	private String userSchool;
	// 구직자 경력
	private String userCareerList;
	// 일했던 직장
	private String shopName;
	// 경력 날짜
	private String careerDate;
	// 부서 이름
	private String depatementName;
	// 자격증 이름
	private String certficateName;
	// 자격증 취득 날짜
	private String certficateDate;
	// 구직자 사진
	private String userImg;
	private String userImg1;
	MultipartFile file;
	
	public MultipartFile getFile() {
		return this.file;
    }
		  
    public void setFile(MultipartFile file) {
		this.file = file;
		if (!file.isEmpty()) {
		this.userImg = file.getOriginalFilename();
		UUID uuid = UUID.randomUUID();
		this.userImg1 = String.valueOf(uuid.toString()) + "_" + this.userImg;
		File f = new File("/home/temp/tomcat8.5/webapps/project1982/resources/upload/" + this.userImg1);
		try {
		file.transferTo(f);
		} catch (IllegalStateException e) {
		e.printStackTrace();
		} catch (IOException e) {
		e.printStackTrace();
		} 
	} 
}
	
	public int getUserNum() {
		return userNum;
	}
	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}
	public String getUserSchool() {
		return userSchool;
	}
	public void setUserSchool(String userSchool) {
		this.userSchool = userSchool;
	}
	public String getUserCareerList() {
		return userCareerList;
	}
	public void setUserCareerList(String userCareerList) {
		this.userCareerList = userCareerList;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getCareerDate() {
		return careerDate;
	}
	public void setCareerDate(String careerDate) {
		this.careerDate = careerDate;
	}
	public String getDepatementName() {
		return depatementName;
	}
	public void setDepatementName(String depatementName) {
		this.depatementName = depatementName;
	}
	public String getCertficateName() {
		return certficateName;
	}
	public void setCertficateName(String certficateName) {
		this.certficateName = certficateName;
	}
	public String getCertficateDate() {
		return certficateDate;
	}
	public void setCertficateDate(String certficateDate) {
		this.certficateDate = certficateDate;
	}

	public String getUserImg() {
		return userImg;
	}

	public void setUserImg(String userImg) {
		this.userImg = userImg;
	}

	public String getUserImg1() {
		return userImg1;
	}

	public void setUserImg1(String userImg1) {
		this.userImg1 = userImg1;
	}
	
	
}
