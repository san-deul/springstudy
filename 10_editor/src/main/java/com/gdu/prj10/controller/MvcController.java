package com.gdu.prj10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class MvcController {


  
  @GetMapping(value={"/", "/main.do"})
  public String welcome() {

    return "index";
  }

}