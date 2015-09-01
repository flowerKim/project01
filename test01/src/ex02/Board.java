package ex02;

import java.io.Serializable;
import java.sql.Date;

public class Board implements Serializable {
  private static final long serialVersionUID = 1L;
  protected int no;
  protected String title;
  protected String content;
  protected int viewCount;
  protected Date createDate;
  protected String password;
  protected String attachFile1;
  protected String attachFile2;
  protected String attachFile3;
  
  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }
  public int getViewCount() {
    return viewCount;
  }
  public void setViewCount(int viewCount) {
    this.viewCount = viewCount;
  }
  public Date getCreateDate() {
    return createDate;
  }
  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  public String getAttachFile1() {
    return attachFile1;
  }
  public void setAttachFile1(String attachFile1) {
    this.attachFile1 = attachFile1;
  }
  public String getAttachFile2() {
    return attachFile2;
  }
  public void setAttachFile2(String attachFile2) {
    this.attachFile2 = attachFile2;
  }
  public String getAttachFile3() {
    return attachFile3;
  }
  public void setAttachFile3(String attachFile3) {
    this.attachFile3 = attachFile3;
  }
  
  
  
}
