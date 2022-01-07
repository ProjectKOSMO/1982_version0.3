package com.javassem.domain;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

public class UserVO {
	// 구직자 기본정보
	private int usernum;
	private String userid;
	private String userpass;
	private String userpass2;
	private String username;
	private String username2;
	private String usercode;
	private String usergender;
	private String userpn;
	private String useraddr;
	private String usermail;
	private String userdate;
	private String userbirth;
	
	// 구직자 이력서 관련
	private String userself;
	
	// 최종학력
	private String userschool;
	private String userschool_date;
	private String userschool_subject;
	private String userschool_end;
	private String userschool_bigo;
	private String userschool_date1;
	private String userschool_subject1;
	private String userschool1;
	private String userschool_end1;
	private String userschool_bigo1;
	
	// 구직자 경력
	private String usercareerlist;
	private String shopname;
	private String careerdate;
	private String departmentname;
	private String careerspot;
	private String careerbigo;
	private String careerdate1;
	private String departmentname1; 
	private String careerspot1; 
	private String usercareerlist1; 
	private String careerbigo1;
	private String careerdate2;
	private String departmentname2;
	private String careerspot2;
	private String usercareerlist2;
	private String careerbigo2;
	
	// 구직자 자격증
	private String certficatename;
	private String certficatedate;
	private String certficate_company;
	private String certficatedate1;
	private String certficatename1;
	private String certficate_company1;
	private String certficatedate2;
	private String certficatename2;
	private String certficate_company2;
	
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
		//File f = new File("C:\\programing\\WorkSpace\\project1982\\project1982\\src\\main\\webapp\\resources\\upload\\" + this.userimg1);
//		File f = new File("/home/temp/tomcat8.5/webapps/project1982/resources/upload/" + this.userimg1);
		
		File f = new File("C:\\Users\\Kosmo\\Desktop\\git\\project1982\\src\\main\\webapp\\resources\\upload\\" + this.userimg1);

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

public String getUserschool() {
	return userschool;
}

public void setUserschool(String userschool) {
	this.userschool = userschool;
}

public String getUserschool_date() {
	return userschool_date;
}

public void setUserschool_date(String userschool_date) {
	this.userschool_date = userschool_date;
}

public String getUserschool_subject() {
	return userschool_subject;
}

public void setUserschool_subject(String userschool_subject) {
	this.userschool_subject = userschool_subject;
}

public String getUserschool_end() {
	return userschool_end;
}

public void setUserschool_end(String userschool_end) {
	this.userschool_end = userschool_end;
}

public String getUserschool_bigo() {
	return userschool_bigo;
}

public void setUserschool_bigo(String userschool_bigo) {
	this.userschool_bigo = userschool_bigo;
}

public String getUserschool_date1() {
	return userschool_date1;
}

public void setUserschool_date1(String userschool_date1) {
	this.userschool_date1 = userschool_date1;
}

public String getUserschool_subject1() {
	return userschool_subject1;
}

public void setUserschool_subject1(String userschool_subject1) {
	this.userschool_subject1 = userschool_subject1;
}

public String getUserschool1() {
	return userschool1;
}

public void setUserschool1(String userschool1) {
	this.userschool1 = userschool1;
}

public String getUserschool_end1() {
	return userschool_end1;
}

public void setUserschool_end1(String userschool_end1) {
	this.userschool_end1 = userschool_end1;
}

public String getUserschool_bigo1() {
	return userschool_bigo1;
}

public void setUserschool_bigo1(String userschool_bigo1) {
	this.userschool_bigo1 = userschool_bigo1;
}

public String getUsercareerlist() {
	return usercareerlist;
}

public void setUsercareerlist(String usercareerlist) {
	this.usercareerlist = usercareerlist;
}

public String getShopname() {
	return shopname;
}

public void setShopname(String shopname) {
	this.shopname = shopname;
}

public String getCareerdate() {
	return careerdate;
}

public void setCareerdate(String careerdate) {
	this.careerdate = careerdate;
}

public String getCareerspot() {
	return careerspot;
}

public void setCareerspot(String careerspot) {
	this.careerspot = careerspot;
}

public String getCareerbigo() {
	return careerbigo;
}

public void setCareerbigo(String careerbigo) {
	this.careerbigo = careerbigo;
}

public String getCareerdate1() {
	return careerdate1;
}

public void setCareerdate1(String careerdate1) {
	this.careerdate1 = careerdate1;
}

public String getDepartmentname1() {
	return departmentname1;
}

public void setDepartmentname1(String departmentname1) {
	this.departmentname1 = departmentname1;
}

public String getCareerspot1() {
	return careerspot1;
}

public void setCareerspot1(String careerspot1) {
	this.careerspot1 = careerspot1;
}

public String getUsercareerlist1() {
	return usercareerlist1;
}

public void setUsercareerlist1(String usercareerlist1) {
	this.usercareerlist1 = usercareerlist1;
}

public String getCareerbigo1() {
	return careerbigo1;
}

public void setCareerbigo1(String careerbigo1) {
	this.careerbigo1 = careerbigo1;
}

public String getCareerdate2() {
	return careerdate2;
}

public void setCareerdate2(String careerdate2) {
	this.careerdate2 = careerdate2;
}

public String getDepartmentname2() {
	return departmentname2;
}

public void setDepartmentname2(String departmentname2) {
	this.departmentname2 = departmentname2;
}

public String getCareerspot2() {
	return careerspot2;
}

public void setCareerspot2(String careerspot2) {
	this.careerspot2 = careerspot2;
}

public String getUsercareerlist2() {
	return usercareerlist2;
}

public void setUsercareerlist2(String usercareerlist2) {
	this.usercareerlist2 = usercareerlist2;
}

public String getCareerbigo2() {
	return careerbigo2;
}

public void setCareerbigo2(String careerbigo2) {
	this.careerbigo2 = careerbigo2;
}

public String getCertficatename() {
	return certficatename;
}

public void setCertficatename(String certficatename) {
	this.certficatename = certficatename;
}

public String getCertficatedate() {
	return certficatedate;
}

public void setCertficatedate(String certficatedate) {
	this.certficatedate = certficatedate;
}

public String getCertficate_company() {
	return certficate_company;
}

public void setCertficate_company(String certficate_company) {
	this.certficate_company = certficate_company;
}

public String getCertficatedate1() {
	return certficatedate1;
}

public void setCertficatedate1(String certficatedate1) {
	this.certficatedate1 = certficatedate1;
}

public String getCertficatename1() {
	return certficatename1;
}

public void setCertficatename1(String certficatename1) {
	this.certficatename1 = certficatename1;
}

public String getCertficate_company1() {
	return certficate_company1;
}

public void setCertficate_company1(String certficate_company1) {
	this.certficate_company1 = certficate_company1;
}

public String getCertficatedate2() {
	return certficatedate2;
}

public void setCertficatedate2(String certficatedate2) {
	this.certficatedate2 = certficatedate2;
}

public String getCertficatename2() {
	return certficatename2;
}

public void setCertficatename2(String certficatename2) {
	this.certficatename2 = certficatename2;
}

public String getCertficate_company2() {
	return certficate_company2;
}

public void setCertficate_company2(String certficate_company2) {
	this.certficate_company2 = certficate_company2;
}

public String getUsername2() {
	return username2;
}

public void setUsername2(String username2) {
	this.username2 = username2;
}

public String getDepartmentname() {
	return departmentname;
}

public void setDepartmentname(String departmentname) {
	this.departmentname = departmentname;
}
  
  
}
