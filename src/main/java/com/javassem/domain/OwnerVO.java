package com.javassem.domain;

import java.io.File;
import java.io.IOException;
import java.util.UUID;
import org.springframework.web.multipart.MultipartFile;


public class OwnerVO {
  private int ownernum;

  private String ownerid;
  
  private String ownerpass;
  
  private String ownername;
  
  private String ownerbirth;
  
  private String ownercode;
  
  private String ownergender;
  
  private String ownerpn;
  
  private String ownermail;
  
  private String ownerdate;
  
  private String shopname;
  
  private String shopaddr;
  
  private String shoppn;
  
  private String shopcontent;
  
  private String shopnum;
  
  private String ownersub;
  
private int board_owner_seq;
  
  public int getBoard_owner_seq() {
	return board_owner_seq;
}

public void setBoard_owner_seq(int board_owner_seq) {
	this.board_owner_seq = board_owner_seq;
}

public String getOwnersub() {
	return ownersub;
}

public void setOwnersub(String ownersub) {
	this.ownersub = ownersub;
}
private String shopupdate;
  private String shopUpdate;

  private String location_y;
  private String location_x;

  public String getLocation_y() {
	return location_y;
}

public void setLocation_y(String location_y) {
	this.location_y = location_y;
}

public String getLocation_x() {
	return location_x;
}

public void setLocation_x(String location_x) {
	this.location_x = location_x;
}

public String getShopUpdate() {
	return shopUpdate;
}

public void setShopUpdate(String shopUpdate) {
	this.shopUpdate = shopUpdate;
}
public String getShopupdate() {
	return shopupdate;
}
public void setShopupdate(String shopupdate) {
	this.shopupdate = shopupdate;
}
private String si_fname;
  
  private String si_realname;
  
  private long si_fsize;
  
  MultipartFile file;
  
  public String getShopnum() {
    return this.shopnum;
  }
  
  public void setShopnum(String shopnum) {
    this.shopnum = shopnum;
  }
  
  public MultipartFile getFile() {
    return this.file;
  }
  
  public void setFile(MultipartFile file) {
    this.file = file;
    if (!file.isEmpty()) {
      this.si_fname = file.getOriginalFilename();
      this.si_fsize = file.getSize();
      UUID uuid = UUID.randomUUID();
      this.si_realname = String.valueOf(uuid.toString()) + "_" + this.si_fname;
      File f = new File("D:\\project1982_local\\project1982\\src\\main\\webapp\\resources\\upload\\" + this.si_realname);
      try {
        file.transferTo(f);
      } catch (IllegalStateException e) {
        e.printStackTrace();
      } catch (IOException e) {
        e.printStackTrace();
      } 
    } 
  }
  
  public int getOwnernum() {
    return this.ownernum;
  }
  
  public void setOwnernum(int ownernum) {
    this.ownernum = ownernum;
  }
  
  public String getOwnerid() {
    return this.ownerid;
  }
  
  public void setOwnerid(String ownerid) {
    this.ownerid = ownerid;
  }
  
  public String getOwnerpass() {
    return this.ownerpass;
  }
  
  public void setOwnerpass(String ownerpass) {
    this.ownerpass = ownerpass;
  }
  
  public String getOwnername() {
    return this.ownername;
  }
  
  public void setOwnername(String ownername) {
    this.ownername = ownername;
  }
  
  public String getOwnercode() {
    return this.ownercode;
  }
  
  public void setOwnercode(String ownercode) {
    this.ownercode = ownercode;
  }
  
  public String getOwnergender() {
    return this.ownergender;
  }
  
  public void setOwnergender(String ownergender) {
    this.ownergender = ownergender;
  }
  
  public String getOwnerpn() {
    return this.ownerpn;
  }
  
  public void setOwnerpn(String ownerpn) {
    this.ownerpn = ownerpn;
  }
  
  public String getOwnermail() {
    return this.ownermail;
  }
  
  public void setOwnermail(String ownermail) {
    this.ownermail = ownermail;
  }
  
  public String getOwnerdate() {
    return this.ownerdate;
  }
  
  public void setOwnerdate(String ownerdate) {
    this.ownerdate = ownerdate;
  }
  
  public String getShopname() {
    return this.shopname;
  }
  
  public void setShopname(String shopname) {
    this.shopname = shopname;
  }
  
  public String getShopaddr() {
    return this.shopaddr;
  }
  
  public void setShopaddr(String shopaddr) {
    this.shopaddr = shopaddr;
  }
  
  public String getShoppn() {
    return this.shoppn;
  }
  
  public void setShoppn(String shoppn) {
    this.shoppn = shoppn;
  }
  
  public String getShopcontent() {
    return this.shopcontent;
  }
  
  public void setShopcontent(String shopcontent) {
    this.shopcontent = shopcontent;
  }
  
  public String getSi_fname() {
    return this.si_fname;
  }
  
  public void setSi_fname(String si_fname) {
    this.si_fname = si_fname;
  }
  
  public String getSi_realname() {
    return this.si_realname;
  }
  
  public void setSi_realname(String si_realname) {
    this.si_realname = si_realname;
  }
  
  public long getSi_fsize() {
    return this.si_fsize;
  }
  
  public void setSi_fsize(long si_fsize) {
    this.si_fsize = si_fsize;
  }
}
