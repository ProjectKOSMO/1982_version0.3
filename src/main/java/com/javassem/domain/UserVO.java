package com.javassem.domain;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

public class UserVO {
	// 구직자 번호
	private int usernum;
	// 구직자 아이디
	private String userid;
	// 구직자 비밀번호
	private String userpass;
	private String userpass2;
	// 구직자 이름
	private String username;
	private String usercode;
	// 구직자 성별
	private String usergender;
	// 구직자 핸드폰번호
	private String userpn;
	// 구직자 주소
	private String useraddr;
	// 구직자 메일
	private String usermail;
	// 가입 날짜
	private String userdate;
	// 생일
	private String userbirth;
	// 구직자 자기소개
	private String userself;
	// 최종학력
	private String userschool;
	// 구직자 경력
	private String usercareerlist;
	// 일했던 직장
	private String shopname;
	// 경력 날짜
	private String careerdate;
	// 부서 이름
	private String depatementname;
	// 자격증 이름
	private String certficatename;
	// 자격증 취득 날짜
	private String certficatedate;
	// 구직자 사진
	private String userimg;
	private String userimg1;
	MultipartFile file;
	
	public MultipartFile getFile() {
		return this.file;
  }
		  
  public void setFile(MultipartFile file) {
		this.file = file;
		if (!file.isEmpty()) {
		this.userimg = file.getOriginalFilename();
		UUID uuid = UUID.randomUUID();
		this.userimg1 = String.valueOf(uuid.toString()) + "_" + this.userimg;
		File f = new File("C:\\programing\\WorkSpace\\project1982\\project1982\\src\\main\\webapp\\resources\\upload\\" + this.userimg1);
		/*File f = new File("/home/temp/tomcat8.5/webapps/project1982/resources/upload/" + this.userimg1);*/
		try {
		file.transferTo(f);
		} catch (IllegalStateException e) {
		e.printStackTrace();
		} catch (IOException e) {
		e.printStackTrace();
		} 
	} 
}
  

  public UserVO() {}
  
  public UserVO(String userid, String userpass, String userpass2, String username, String userpn, String usermail, String userbirth, String userdate) {
    this.userid = userid;
    this.userpass = userpass;
    this.userpass2 = userpass2;
    this.username = username;
    this.userpn = userpn;
    this.usermail = usermail;
    this.userbirth = userbirth;
    this.userdate = userdate;
  }
  
  public int getUsernum() {
    return this.usernum;
  }
  
  public void setUsernum(int usernum) {
    this.usernum = usernum;
  }
  
  public String getUserid() {
    return this.userid;
  }
  
  public void setUserid(String userid) {
    this.userid = userid;
  }
  
  public String getUserpass() {
    return this.userpass;
  }
  
  public void setUserpass(String userpass) {
    this.userpass = userpass;
  }
  
  public String getUserpass2() {
    return this.userpass2;
  }
  
  public void setUserpass2(String userpass2) {
    this.userpass2 = userpass2;
  }
  
  public String getUsername() {
    return this.username;
  }
  
  public void setUsername(String username) {
    this.username = username;
  }
  
  public String getUsercode() {
    return this.usercode;
  }
  
  public void setUsercode(String usercode) {
    this.usercode = usercode;
  }
  
  public String getUsergender() {
    return this.usergender;
  }
  
  public void setUsergender(String usergender) {
    this.usergender = usergender;
  }
  
  public String getUserpn() {
    return this.userpn;
  }
  
  public void setUserpn(String userpn) {
    this.userpn = userpn;
  }
  
  public String getUseraddr() {
    return this.useraddr;
  }
  
  public void setUseraddr(String useraddr) {
    this.useraddr = useraddr;
  }
  
  public String getUsermail() {
    return this.usermail;
  }
  
  public void setUsermail(String usermail) {
    this.usermail = usermail;
  }
  
  
  public String getUserdate() {
    return this.userdate;
  }
  
  public void setUserdate(String userdate) {
    this.userdate = userdate;
  }
  
  public String getUserbirth() {
    return this.userbirth;
  }
  
  public void setUserbirth(String userbirth) {
    this.userbirth = userbirth;
  }

public String getUserimg() {
	return userimg;
}

public void setUserimg(String userimg) {
	this.userimg = userimg;
}

public String getUserSchool() {
	return userschool;
}

public void setUserSchool(String userSchool) {
	this.userschool = userSchool;
}

public String getUserCareerList() {
	return usercareerlist;
}

public void setUserCareerList(String userCareerList) {
	this.usercareerlist = userCareerList;
}

public String getShopName() {
	return shopname;
}

public void setShopName(String shopName) {
	this.shopname = shopName;
}

public String getCareerDate() {
	return careerdate;
}

public void setCareerDate(String careerDate) {
	this.careerdate = careerDate;
}

public String getDepatementName() {
	return depatementname;
}

public void setDepatementName(String depatementName) {
	this.depatementname = depatementName;
}

public String getCertficateName() {
	return certficatename;
}

public void setCertficateName(String certficateName) {
	this.certficatename = certficateName;
}

public String getCertficateDate() {
	return certficatedate;
}

public void setCertficateDate(String certficateDate) {
	this.certficatedate = certficateDate;
}

public String getUserimg1() {
	return userimg1;
}

public void setUserimg1(String userimg1) {
	this.userimg1 = userimg1;
}

public String getUserself() {
	return userself;
}

public void setUserself(String userself) {
	this.userself = userself;
}
  
  
}
