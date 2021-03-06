package wiki;

import java.sql.Timestamp;


public class WikiPage {

  //ページの名前
  private String name;

  // ページの内容
  private String content;

  // 更新日時
  private Timestamp updateTime;

  // 整形を行った内容を繰り返す
  public String getFormatedContent(){
    WikiFormater formater = new WikiFormater();
    return formater.formatText(content);
  }

  //以下はgetter,setter
  public String getContent(){
    return content;
  }
  
  public void setContent(String contents){
    this.content = contents;
  }
  
  
  public String getName(){
    return name;
  }
  
  public void setName(String name){
    this.name = name;
  }
  
  
  public Timestamp getUpdateTime(){
    return updateTime;
  }
  
  public void setUpdateTime(Timestamp updateTime){
    this.updateTime = updateTime;
  }
  
}
