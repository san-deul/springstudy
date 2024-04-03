package com.gdu.myapp.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface BbsService {
  
  int registerBbs(HttpServletRequest request); // ip 등 뽑아옴
  
  //모델을 컨트롤러에서 선언 , attribute는 실을게 많으니 service에서
  void loadBbsList(HttpServletRequest request, Model model);
  
  int registerReply(HttpServletRequest request);
  int removeBbs(int bbsNo);
  
  void loadBbsSearchList(HttpServletRequest request, Model model);

} 
