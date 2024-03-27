package com.gdu.prj10.service;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.support.AbstractMultipartHttpServletRequest;

public interface BoardService {
  
  ResponseEntity<Map<String, Object>> summernoteImageUpload(MultipartHttpServletRequest multiparRequest);
  
  
}
