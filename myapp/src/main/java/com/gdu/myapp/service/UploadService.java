package com.gdu.myapp.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.gdu.myapp.dto.UploadDto;

public interface UploadService {
  
  public boolean registerUpload(MultipartHttpServletRequest multipartHttpServletRequest);
  // 파일추가가 있어야 하기 때문에 일반 request는 안됨
  public void loadUploadList(Model model); // 새로운 형태, request빼고 model만

  UploadDto getUploadByNo(int uploadNo, Model model);
}
