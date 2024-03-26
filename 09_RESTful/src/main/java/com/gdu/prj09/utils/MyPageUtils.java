package com.gdu.prj09.utils;

import lombok.Data;

@Data
public class MyPageUtils {
  
  private int total;//전체 게시글 개수
  private int display;//한번에 보여줄 게시글 개수
  private int page; // 현재페이지  
  private int begin;
  private int end;
  
  private int pagePerBlock = 10;
  private int totalPage;
  private int beginPage;
  private int endPage;
  
  public void setPaging(int total, int display, int page) {
    
    this.total = total;
    this.display = display;
    this.page = page;
    
    begin = (page - 1) *display + 1;
    end = begin + display - 1;    
    /*
     *begin end
    1 - 1   20
    1 - 21  40
    3 - 41  60
    */
    
    
        /*
    total display totalPage
    1000    20    1000/20 = 50.0 =50
    1001    20    1001/20 = 50.x = 51 (올림처리)
    */
    
    totalPage = (int) Math.ceil((double)total / display);
    beginPage = ((page-1)/pagePerBlock) * pagePerBlock + 1;
    
    endPage = Math.min(totalPage, beginPage + pagePerBlock - 1);
    
  }
  
  
  /*
   * 
  SPA 싱글페이지 어플리케이션, 싱글페이지(페이지 안바뀜)
  페이지 안바뀌느거임
  
  페이지 번호? 가져올건데, 예전처럼 a태그 이용하지않고,
  자바스크립트 function getPaging ... 페이징 가져오는 스크립트로 해줄거
   * */
  public String getAsyncPaging() {
    
    StringBuilder builder = new StringBuilder();
    

    // <
    if(beginPage==1) {
      builder.append("<a>&lt;</a>");
    }else {
      builder.append("<a href=\"javascript:fnPaging(" + (beginPage - 1 ) + ")\">&lt;</a>");
      
    }
    
    //  1 2 3 4 5 6 7 8 9 10
    for(int p = beginPage; p <= endPage; p++) {
      if(p == page) {
        builder.append("<a>" + p + "</a>");
      }else {
        builder.append("<a href=\"javascript:fnPaging(" + p + ")\">" + p + "</a>");
      }
    }
    
    // >
    if(endPage == totalPage) {
      builder.append("<a>&gt;</a>");
    }else {
      builder.append("<a href=\"javascript:fnPaging("+(endPage + 1) + ")\">&gt;</a>");
    }
    
    
    return builder.toString();
  }
  
}
