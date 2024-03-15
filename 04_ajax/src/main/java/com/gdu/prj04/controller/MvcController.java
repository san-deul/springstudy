package com.gdu.prj04.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MvcController {


  @GetMapping(value={"/", "/main.do"})
  public String welcome() {
    //System.out.println(boardDao.getBoardList());
    return "index";
  }
  
  @GetMapping("/exercise1.do")
  public void exercise1() {
    
  }
  
  /*
   * exercise.do 가
보이드반환에 의해서
exercise.jsp가 됨
   * */
  
  @GetMapping("/exercise2.do")
  public String exercise2() {
    return "exercise2";
  }
  
  @GetMapping("/exercise3.do")
  public String exercise3() {
    return "exercise3";
  }
  
  
  
}
