package com.gdu.myapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class MvcController {


  
  @GetMapping(value={"/", "/main.page"})
  public String welcome() {

    return "index";
  }

}