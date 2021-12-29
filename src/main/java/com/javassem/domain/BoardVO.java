package com.javassem.domain;
import java.io.File;
import java.io.IOException;
import java.util.UUID;
import org.springframework.web.multipart.MultipartFile;
public class BoardVO {
  private int b_id;
  
  private String b_name;
  
  private String b_email;
  
  private String b_title;
  
  private String b_content;
  
  private String b_pwd;
  
  private String b_date;
  
  private int b_count;
  
  private String b_fname;
  
  private String b_realfname;
  
  private long b_fsize;
  
  MultipartFile file;
  
  public MultipartFile getFile() {
    return this.file;
  }
  
  public void setFile(MultipartFile file) {
    this.file = file;
    if (!file.isEmpty()) {
      this.b_fname = file.getOriginalFilename();
      this.b_fsize = file.getSize();
      UUID uuid = UUID.randomUUID();
      this.b_realfname = String.valueOf(uuid.toString()) + "_" + this.b_fname;
      File f = new File("C:\\Programing\\git\\project1982\\src\\main\\webapp\\resources\\upload\\" + this.b_realfname);
      try {
        file.transferTo(f);
      } catch (IllegalStateException e) {
        e.printStackTrace();
      } catch (IOException e) {
        e.printStackTrace();
      } 
    } 
  }
  
  public int getB_id() {
    return this.b_id;
  }
  
  public void setB_id(int b_id) {
    this.b_id = b_id;
  }
  
  public String getB_name() {
    return this.b_name;
  }
  
  public void setB_name(String b_name) {
    this.b_name = b_name;
  }
  
  public String getB_email() {
    return this.b_email;
  }
  
  public void setB_email(String b_email) {
    this.b_email = b_email;
  }
  
  public String getB_title() {
    return this.b_title;
  }
  
  public void setB_title(String b_title) {
    this.b_title = b_title;
  }
  
  public String getB_content() {
    return this.b_content;
  }
  
  public void setB_content(String b_content) {
    this.b_content = b_content;
  }
  
  public String getB_pwd() {
    return this.b_pwd;
  }
  
  public void setB_pwd(String b_pwd) {
    this.b_pwd = b_pwd;
  }
  
  public String getB_date() {
    return this.b_date;
  }
  
  public void setB_date(String b_date) {
    this.b_date = b_date;
  }
  
  public int getB_count() {
    return this.b_count;
  }
  
  public void setB_count(int b_count) {
    this.b_count = b_count;
  }
  
  public String getB_realfname() {
    return this.b_realfname;
  }
  
  public void setB_realfname(String b_realfname) {
    this.b_realfname = b_realfname;
  }
  
  public String getB_fname() {
    return this.b_fname;
  }
  
  public void setB_fname(String b_fname) {
    this.b_fname = b_fname;
  }
  
  public long getB_fsize() {
    return this.b_fsize;
  }
  
  public void setB_fsize(long b_fsize) {
    this.b_fsize = b_fsize;
  }
}
