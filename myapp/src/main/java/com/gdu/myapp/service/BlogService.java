package com.gdu.myapp.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface BlogService {
  ResponseEntity<Map<String, Object>> summernoteImageUpload(MultipartFile multipartFile, String contextPath); 
  /*└─ 편집기 통해 이미지 첨부하게끔 함,
   *  이미지 하나당 summernoteImageUpload 가 한번씩 호출
   *  한페이지 내에서 동작할 거기때문에, 비동기로 처리 
   * */

  int registerBlog(HttpServletRequest request);   // 작성완료
  /*
   * int registerBlog(리퀘스트, 리퀘스트파람, 커맨드객체);  <- 세개가 변수로 들어갈 수 O
   * */
  
}
