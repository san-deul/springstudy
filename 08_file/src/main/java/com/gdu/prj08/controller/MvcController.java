package com.gdu.prj08.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.gdu.prj08.utils.MyFileUtils;

@Controller
public class MvcController {


  
  @GetMapping(value={"/", "/main.do"})
  public String welcome() {

    return "index";
  }

}